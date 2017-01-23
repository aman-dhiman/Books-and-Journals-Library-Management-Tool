/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
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
public class MainScreen extends JFrame implements ActionListener{
    
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    MainPanel mainPanel = new MainPanel();
    AddPanel addPanel;
    SearchPanel searchPanel;
    PrintMapPanel printPanel = new PrintMapPanel();
    int panel;
    FileIO fileIO = new FileIO();
    SearchHashMap searchMap = new SearchHashMap();
    HashMap<String, List<Integer>> map;
    FileIO file;
    ArrayList<Reference> ref;
    String filename;
    
    public MainScreen (ArrayList<Reference> reference, FileIO fileIO, String output){
        super();
        setSize (WIDTH, HEIGHT);
        
        setTitle ("Library Search");
        
        setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
        
        setLayout (new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        
        ref = reference;
        
        JMenu mainMenu = new JMenu("Commands");
        
        JMenuItem add = new JMenuItem ("Add");
        JMenuItem search = new JMenuItem ("Search");
        JMenuItem printMap = new JMenuItem ("Print Hash Map");
        JMenuItem quit = new JMenuItem ("Quit");
        
        add.addActionListener(this);
        search.addActionListener(this);
        printMap.addActionListener(this);
        quit.addActionListener(this);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e){
                try {
                    file.output(filename, ref);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
                }
        });
        
        mainMenu.add(add);
        mainMenu.add(search);
        mainMenu.add(printMap);
        mainMenu.add(quit);
        
        JMenuBar bar = new JMenuBar();
        bar.add(mainMenu);
        setJMenuBar (bar);
        
        
        filename = output;
        file = fileIO;
        map  = searchMap.createMap(reference);
        addPanel = new AddPanel(reference, map, searchMap);
        searchPanel = new SearchPanel(reference, map, searchMap);
        
        add(mainPanel);
        panel = 0;
        setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        String buttonString = e.getActionCommand();
        
        if (buttonString.equals("Add")){
            if (panel == 0){
                remove (mainPanel);
                add (addPanel);
                panel = 1;
                validate();
                repaint();
            }
            else if (panel == 2){
                remove (searchPanel);
                add (addPanel);
                panel = 1;
                validate();
                repaint();
            }
            else if (panel == 3){
                remove (printPanel);
                add (addPanel);
                panel = 1;
                validate();
                repaint();
            }
        }
        if (buttonString.equals("Search")){
            if (panel == 0){
                remove (mainPanel);
                add (searchPanel);
                panel = 2;
                validate();
                repaint();
            }
            else if (panel == 1){
                remove (addPanel);
                add (searchPanel);
                panel = 2;
                validate();
                repaint();
            }
            else if (panel == 3){
                remove (printPanel);
                add (searchPanel);
                panel = 2;
                validate();
                repaint();
            }
        }
        if (buttonString.equals("Print Hash Map")){
            if (panel == 0){
                remove (mainPanel);
                add (printPanel);
                panel = 3;
                validate();
                repaint();
            }
            else if (panel == 1){
                remove (addPanel);
                add (printPanel);
                panel = 3;
                validate();
                repaint();
            }
            else if (panel == 2){
                remove (searchPanel);
                add (printPanel);
                panel = 3;
                validate();
                repaint();
            }
            printPanel.printMap(map);
        }
        if (buttonString.equals("Quit")){
            try {
                file.output(filename, ref);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }
    
}
