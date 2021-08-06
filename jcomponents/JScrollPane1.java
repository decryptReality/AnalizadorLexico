package jcomponents;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

// modificado el 04/08/2021
public class JScrollPane1 extends JScrollPane 
{
    public JScrollPane1(Component view, int width, int height)
    {
        super(view);
        setPreferredSize(new Dimension(width, height));
    }
}
