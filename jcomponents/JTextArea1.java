package jcomponents;

import javax.swing.*;
import java.awt.*;

// modificado el 04/08/2021
public class JTextArea1 extends JTextArea
{
    public JTextArea1(boolean editable, int width, int height)
    {
        setPreferredSize(new Dimension(width,height));
        setEditable(editable);
        setBackground(new Color(238,238,238));
    }
    public JTextArea1(boolean editable)
    {
        setEditable(editable);
        setBackground(new Color(238,238,238));
    }

    public void lineWrapSettings(boolean word)
    {
        setLineWrap(true);
        setWrapStyleWord(word);
    }

    public void backgroundSettings(int r, int g, int b)
    {
        setBackground(new Color(r, g, b));
    }
}
