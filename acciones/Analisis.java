package acciones;

public class Analisis 
{
    static char[] digitos1 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] digitos2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
    static char[] letras1 = 
    {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] letras2 = 
    {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public static void main(String[] args) 
    {
        /*
        //limpiar(" 1   \n\n\n      A     AAA   A \n BBBBB BB B B   B");
        String[] texto = {"123","1.13","1..11","1....1","0.",".0"};
        for (int i = 0; i <texto.length; i = i + 1)
        {
            System.out.println(texto[i]);
            reconocerNumero(texto[i].toCharArray());
        }

        */
        separar("  AAA AA      G  123 654 5958  ");
    }

    static void reconocerNumero(char[] lexema)
    {
        boolean esNumero = true;
        boolean esEntero = true;
        boolean esDecimal = true;

        // SI es entero debe tener 1 o mas digitos 
        // Si es decimal debe tener al menos 2 digitos y un punto

        // si !esNumero return ERROR o intentar con otro tipo de token, como Simbol

        int puntoDecimal = 0;
        int iPuntoDecimal = -1;
        for (int i = 0; i < lexema.length; i = i + 1)
        {
            //System.out.println(lexema[i]);

            // SI UN char NO es digito Y NO es '.'
            if(!esDigito(lexema[i]) & (lexema[i] != '.'))
            {
                // el lexema NO es numero
                esNumero = false;
                break;
            }

            // SI UN char es '.'
            if(lexema[i] == '.')
            {
                puntoDecimal = puntoDecimal + 1;
                iPuntoDecimal = i;

                // el lexema NO es entero
                esEntero = false;
                // SI hay mas de un '.'
                if(puntoDecimal > 1)
                {
                    // el lexema NO es numero
                    esNumero = false;
                    break;
                }
            }
        }

        if(puntoDecimal == 0)
        {
            esDecimal = false;
        }

        if((iPuntoDecimal == 0)|(iPuntoDecimal == lexema.length - 1))
        {
            esNumero = false;
            System.out.println("[!] decimal en algun extremo");
        }

        // conclusion para el lexema
        if(esNumero)
        {
            if(esEntero)
            {
                System.out.println("[?] ZOI UN ENTERO");
            }
            if(esDecimal)
            {
                System.out.println("[?] ZOI UN DECIMAL");
            }
        }

        System.out.println("esNumero: " + esNumero);
        System.out.println("esEntero: " + esEntero);
        System.out.println("esDecimal: " + esDecimal);
    }

    static void separar(String sTexto)
    {
        char[] texto = limpiar(sTexto);

        String temporal = "";

        for (int i = 0; i < texto.length; i = i + 1)
        {
            // recorrer cadena hasta encontrar un espacio
            // guardar los elementos anterior a ese espacio
            if(texto[i] == ' ')// | (i == texto.length - 1))
            {
                System.out.print(">>");
                System.out.print(temporal);
                System.out.print("<.\n");
                temporal = "";
                //reconocerNumero(temporal.toCharArray());
            }
            else
            {
                temporal = temporal + texto[i];
            }
        }
    }

    static char[] limpiar(String sTexto)
    {
        // se agrega " " para evaluar todos los elementos char del 
        // String inicial
        sTexto = sTexto + " ";
        System.out.println(sTexto);
        char[] aTexto1 = sTexto.toCharArray();

        if(aTexto1.length > 1)
        {
            char[] aTexto2 = new char[aTexto1.length];
            int j = 0;

            // reemplazar "\n" por " "
            for (int i = 0; i < aTexto1.length - 1; i = i + 1)
            {
                if(aTexto1[i] == '\n')
                {
                    aTexto1[i] = ' ';
                }
            }

            for (int i = 0; i < aTexto1.length - 1; i = i + 1) 
            {  
                // para eliminar espacios adyacentes repetidos 
                // se aceptan los casos: "A ", " A", "AA"
                boolean condicion = 
                ((aTexto1[i] != ' ') & (aTexto1[i + 1] == ' ')) | 
                ((aTexto1[i] == ' ') & (aTexto1[i + 1] != ' ')) | 
                ((aTexto1[i] != ' ') & (aTexto1[i + 1] != ' '));

                if(condicion) 
                {
                    aTexto2[j] = aTexto1[i];
                    j = j + 1;
                }
            }

            // ultimo elemento es ' '
            char[] aTexto3 = new char[j + 1];

            for (int i = 0; i < j; i = i + 1)
            {
                aTexto3[i] = aTexto2[i];
                System.out.print(aTexto3[i]);
            }
            aTexto3[j] = ' ';

            return aTexto3;
        }
        return aTexto1;
    }     
    
    static void ejemplo()
    {
        String texto = "\n\nA \n\nB";
        char[] extrac = texto.toCharArray();
        for(int i=0; i<extrac.length; i = i + 1)
        {
            
            if(!(extrac[i]=='\n'))
            {
                System.out.print(" >>" + extrac[i] + "<.");
            }
            else
            {
                System.out.print(" >>" + "?" + "<.");
            }
        }
    }

    static boolean esDigito(char digito)
    {
        for (int i = 0; i < digitos1.length; i = i + 1)
        {
            if(digitos1[i] == digito)
            {
                return true;
            }
        }
        return false;
    }
    static boolean esLetraMa(char letra)
    {
        for (int i = 0; i < letras2.length; i = i + 1)
        {
            if(letras2[i] == letra)
            {
                return true;
            }
        }
        return false;
    }

    static boolean esLetraMi(char letra)
    {
        for (int i = 0; i < letras1.length; i = i + 1)
        {
            if(letras1[i] == letra)
            {
                return true;
            }
        }
        return false;
    }


}

