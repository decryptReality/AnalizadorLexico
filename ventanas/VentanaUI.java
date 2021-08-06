package ventanas;

import jcomponents.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaUI 
{
    public static void main(String[] args) {
        menu1();
    }

    static void menu1()
    {
        JLabel1 lGuia = new JLabel1("INGRESE UNA O VARIAS LINEAS DE TEXTO", SwingConstants.CENTER, 320, 26);
        
        JTextArea1 taTexto = new JTextArea1(true);
        JTextArea1 taResultado = new JTextArea1(false);
        taTexto.backgroundSettings(0, 255, 200);
        taResultado.backgroundSettings(0, 255, 200);

        JScrollPane1 spTexto = new JScrollPane1(taTexto, 320, 100);
        JScrollPane1 spResultado = new JScrollPane1(taResultado, 320, 100);
        
        JButton1 bVerificar = new JButton1("VERIFICAR", 140, 25);

        JFrame1 dMenu = new JFrame1("ANALIZADOR LEXICO");

        dMenu.add(lGuia);
        dMenu.add(spTexto);
        dMenu.add(bVerificar);
        dMenu.add(spResultado);

        bVerificar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    System.out.println("ENTER");
                }
            }
        );
        dMenu.sizeSettings(true, 360, 320);
        dMenu.locationSettings();
    } 
}
