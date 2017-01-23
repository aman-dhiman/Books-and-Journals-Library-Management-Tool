/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aman dhiman
 */
public class MainPanel extends JPanel{
    
    public MainPanel(){
        super();
        this.setLayout(new BorderLayout());
        this.setBorder (new EmptyBorder (250,150,0,150));
        
        JLabel welcome = new JLabel("Welcome to Library Search.");
        add(welcome, BorderLayout.NORTH);
        
        JTextArea message = new JTextArea ("Choose a command from the \"Commands\" menu"
        + " above for adding a reference, searching references, or quitting the"
        + " program", 5, 30);
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setBackground(this.getBackground());
        message.setMargin(new Insets (10,0,0,10));
        add(message, BorderLayout.CENTER);
    }
        
}
