/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.Box;
import static javax.swing.Box.createHorizontalStrut;
import static javax.swing.Box.createVerticalStrut;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author aman dhiman
 */
public class AddPanel extends JPanel implements ActionListener{
    
    int panel;
    JPanel inputBook;
    JPanel inputJournal;
    JPanel message;
    JComboBox typeSelectB;
    JComboBox typeSelectJ;
    JButton reset;
    JButton add;
    JPanel buttons;
    JTextField callFieldB;
    JTextField callFieldJ;
    JTextField authorField;
    JTextField titleFieldB;
    JTextField titleFieldJ;
    JTextField pubField;
    JTextField yearFieldB;
    JTextField yearFieldJ;
    JTextField orgField;
    ArrayList<Reference> ref;
    JTextArea prompt;
    EmptyBorder emJ = new EmptyBorder (10,60,20,20);
    EmptyBorder emB = new EmptyBorder(10,60,20,20);
    HashMap<String, List<Integer>> theMap;
    SearchHashMap theSearchMap;
    public AddPanel(ArrayList<Reference> reference, HashMap<String, List<Integer>> map, SearchHashMap searchMap){
        super();
        ref = reference;
        inputBook = new JPanel();
        inputJournal = new JPanel();
        buttons = new JPanel();
        message = new JPanel();
        JPanel inputBFields = new JPanel();
        JPanel inputJFields = new JPanel();
        JPanel inputBLabel = new JPanel();
        JPanel inputJLabel = new JPanel();
        inputBFields.setLayout(new BoxLayout(inputBFields, BoxLayout.Y_AXIS));
        inputJFields.setLayout(new BoxLayout(inputJFields, BoxLayout.Y_AXIS));
        inputBLabel.setLayout(new BoxLayout(inputBLabel, BoxLayout.Y_AXIS));
        inputJLabel.setLayout(new BoxLayout(inputJLabel, BoxLayout.Y_AXIS));
        
        theMap = map;
        theSearchMap = searchMap;
        
        JLabel typeB = new JLabel("Type: ");
        String[] refTypeB = {"Book", "Journal"};
        typeSelectB = new JComboBox(refTypeB);
        typeSelectB.setSelectedIndex(0);
        typeSelectB.addActionListener(this);
//        typePanelB.setLayout(new BoxLayout(typePanelB, BoxLayout.X_AXIS));
//        typePanelB.add(typeB);
//        typePanelB.add(typeSelectB);
        inputBLabel.add(createVerticalStrut(3));
        inputBLabel.add(typeB);
        inputBLabel.add(createVerticalStrut(14));
        inputBFields.add(typeSelectB);
        inputBFields.add(createVerticalStrut(10));
        
        
        JLabel typeJ = new JLabel("Type: ");
        String[] refTypeJ = {"Book", "Journal"};
        typeSelectJ = new JComboBox(refTypeJ);
        typeSelectJ.setSelectedIndex(1);
        typeSelectJ.addActionListener(this);
//        typePanelJ.setLayout(new BoxLayout(typePanelJ, BoxLayout.X_AXIS));
//        typePanelJ.add(typeJ);
//        typePanelJ.add(typeSelectJ);
        inputJLabel.add(createVerticalStrut(3));
        inputJLabel.add(typeJ);
        inputJLabel.add(createVerticalStrut(14));
        inputJFields.add(typeSelectJ);
        inputJFields.add(createVerticalStrut(10));
        
        
        JLabel callB = new JLabel("Call No:");
        callFieldB = new JTextField(30);
 //       callPanelB.setLayout(new BoxLayout(callPanelB, BoxLayout.X_AXIS));
 //       callPanelB.setBorder (new EmptyBorder (20,0,0,0));
 //       callPanelB.add(callB);
 //       callPanelB.add(callFieldB);
        inputBLabel.add(callB);
        inputBLabel.add(createVerticalStrut(14));
        inputBFields.add(callFieldB);
        inputBFields.add(createVerticalStrut(10));
        
        JLabel callJ = new JLabel("Call No:");
        callFieldJ = new JTextField(30);
//        callPanelJ.setLayout(new BoxLayout(callPanelJ, BoxLayout.X_AXIS));
//        callPanelJ.setBorder (new EmptyBorder (20,0,0,0));
//        callPanelJ.add(callJ);
//        callPanelJ.add(callFieldJ);
        inputJLabel.add(callJ);
        inputJLabel.add(createVerticalStrut(14));
        inputJFields.add(callFieldJ);
        inputJFields.add(createVerticalStrut(10));
        
        JLabel author = new JLabel("Author(s):");
        authorField = new JTextField(30);
//        authorPanel.setLayout(new BoxLayout(authorPanel, BoxLayout.X_AXIS));
//        authorPanel.setBorder (new EmptyBorder (20,0,0,0));
//        authorPanel.add(author);
//        authorPanel.add(authorField);
        inputBLabel.add(author);
        inputBLabel.add(createVerticalStrut(14));
        inputBFields.add(authorField);
        inputBFields.add(createVerticalStrut(10));
        
        JLabel titleB = new JLabel("Title:");
        titleFieldB = new JTextField(30);
//        titlePanelB.setLayout(new BoxLayout(titlePanelB, BoxLayout.X_AXIS));
//        titlePanelB.setBorder (new EmptyBorder (20,0,0,0));
//        titlePanelB.add(titleB);
//        titlePanelB.add(titleFieldB);
        inputBLabel.add(titleB);
        inputBLabel.add(createVerticalStrut(14));
        inputBFields.add(titleFieldB);
        inputBFields.add(createVerticalStrut(10));
        
        
        JLabel titleJ = new JLabel("Title:");
        titleFieldJ = new JTextField(30);
//        titlePanelJ.setLayout(new BoxLayout(titlePanelJ, BoxLayout.X_AXIS));
//        titlePanelJ.setBorder (new EmptyBorder (20,0,0,0));
//        titlePanelJ.add(titleJ);
//        titlePanelJ.add(titleFieldJ);
        inputJLabel.add(titleJ);
        inputJLabel.add(createVerticalStrut(14));
        inputJFields.add(titleFieldJ);
        inputJFields.add(createVerticalStrut(10));
        
        JLabel pub = new JLabel("Publisher:");
        pubField = new JTextField(30);
//        pubPanel.setLayout(new BoxLayout(pubPanel, BoxLayout.X_AXIS));
//        pubPanel.setBorder (new EmptyBorder (20,0,0,0));
//        pubPanel.add(pub);
//        pubPanel.add(pubField);
        inputBLabel.add(pub);
        inputBLabel.add(createVerticalStrut(14));
        inputBFields.add(pubField);
        inputBFields.add(createVerticalStrut(10));
        
        JLabel yearB = new JLabel("Year:");
        yearFieldB = new JTextField(30);
//        yearPanelB.setLayout(new BoxLayout(yearPanelB, BoxLayout.X_AXIS));
//        yearPanelB.setBorder (new EmptyBorder (20,0,0,0));
//        yearPanelB.add(yearB);
//        yearPanelB.add(yearFieldB);
        inputBLabel.add(yearB);
        inputBLabel.add(createVerticalStrut(14));
        inputBFields.add(yearFieldB);
        inputBFields.add(createVerticalStrut(10));
        
        JLabel yearJ = new JLabel("Year:");
        yearFieldJ = new JTextField(30);
//        yearPanelJ.setLayout(new BoxLayout(yearPanelJ, BoxLayout.X_AXIS));
//        yearPanelJ.setBorder (new EmptyBorder (20,0,0,0));
//        yearPanelJ.add(yearJ);
//        yearPanelJ.add(yearFieldJ);
        inputJLabel.add(yearJ);
        inputJLabel.add(createVerticalStrut(14));
        inputJFields.add(yearFieldJ);
        inputJFields.add(createVerticalStrut(10));
        
        JLabel org = new JLabel("Organization:");
        orgField = new JTextField(30);
//        orgPanel.setLayout(new BoxLayout(orgPanel, BoxLayout.X_AXIS));
//        orgPanel.setBorder (new EmptyBorder (20,0,0,0));
//        orgPanel.add(org);
//        orgPanel.add(orgField);
        inputJLabel.add(org);
        inputJLabel.add(createVerticalStrut(14));
        inputJFields.add(orgField);
        inputJFields.add(createVerticalStrut(10));
        
        inputBook.setLayout(new BoxLayout(inputBook, BoxLayout.X_AXIS));
        inputJournal.setLayout(new BoxLayout(inputJournal, BoxLayout.X_AXIS));
        
        /*inputBook.add(typePanelB);
        inputBook.add(callPanelB);
        inputBook.add(authorPanel);
        inputBook.add(titlePanelB);
        inputBook.add(pubPanel);
        inputBook.add(yearPanelB);*/
        inputBook.add(inputBLabel);
        inputBook.add(createHorizontalStrut(38));
        inputBook.add(inputBFields);
        inputBook.setBorder(new EmptyBorder (30,20,20,0));
        
        /*inputJournal.add(typePanelJ);
        inputJournal.add(callPanelJ);
        inputJournal.add(titlePanelJ);
        inputJournal.add(orgPanel);
        inputJournal.add(yearPanelJ);*/
        inputJournal.add(inputJLabel);
        inputJournal.add(createHorizontalStrut(20));
        inputJournal.add(inputJFields);
        inputJournal.setBorder(new EmptyBorder (30,20,50,0));
        
        add(inputBook);
        panel = 0;
        
        reset = new JButton("Reset");
        reset.setMargin(new Insets (0,20,0,20));
        reset.addActionListener(this);

        add = new JButton("Add");
        add.setMargin(new Insets (0,20,0,20));
        add.addActionListener(this);
        
        buttons.setLayout (new GridLayout (2,1,0,20));
        buttons.add(reset);
        buttons.add(add);
        buttons.setBorder(emB);
        
        add(buttons);
        
        BorderLayout messageB = new BorderLayout();
        messageB.setVgap(10);
        message.setLayout(messageB);
        JLabel mes = new JLabel("Messages");
        prompt = new JTextArea (20,55);
        prompt.setEditable(false);
        JScrollPane text = new JScrollPane (prompt);
        message.add(mes, BorderLayout.NORTH);
        message.add(text, BorderLayout.CENTER);
        
        add(message);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        prompt.setText("");
        String callNumber = "";
        String author = "";
        String title = "";
        String publisher = "";
        String organization = "";
        int year = 0;
        String yearStr = "";
        String[] authors = null;
        String authorStr = "";
        boolean exists = false;
        if ((e.getSource() == typeSelectB) || (e.getSource() == typeSelectJ)){
            JComboBox cb = (JComboBox)e.getSource();
            String cbString = (String)cb.getSelectedItem();

            if (cbString.equals("Journal")){
                if (panel == 0){
                    removeAll();
                    add(inputJournal);
                    buttons.setBorder (emJ);
                    add(buttons);
                    add(message);
                    cb.setSelectedIndex(0);
                    panel = 1;
                    validate();
                    repaint();
                }
            }
            else if (cbString.equals("Book")){
                if (panel == 1){
                    removeAll();
                    add(inputBook);
                    buttons.setBorder(emB);
                    add(buttons);
                    add(message);
                    cb.setSelectedIndex(1);
                    panel = 0;
                    validate();
                    repaint();
                }
            }
        }
        else if (e.getSource() == reset){
            if (panel == 0){
                callFieldB.setText("");
                authorField.setText("");
                titleFieldB.setText("");
                pubField.setText("");
                yearFieldB.setText("");
            }
            else if (panel == 1){
                callFieldJ.setText("");
                titleFieldJ.setText("");
                orgField.setText("");
                yearFieldJ.setText("");
            }
            validate();
            repaint();
        }
        else if (e.getSource() == add){
            if (panel == 0){
                Book temp;
                boolean success = true;
                callNumber = callFieldB.getText();
                title = titleFieldB.getText();
                publisher = pubField.getText();
                yearStr = yearFieldB.getText();
                if (callNumber.isEmpty()){
                    success = false;
                    prompt.setText("Cannot leave Call Number empty.\n");
                }
                if (title.isEmpty()){
                    prompt.append("Cannot leave Title empty.\n");
                    success = false;
                }
                if (yearStr.isEmpty()){
                    prompt.append("Cannot leave Year empty.\n");
                    success = false;
                }
                if (!yearStr.isEmpty()){
                    try {
                        year = Integer.parseInt(yearStr);
                    }
                    catch (NumberFormatException f){
                        year = 0;
                        success = false;
                        prompt.append("Invalid format for year.\n");
                    }
                }
                if ((year < 1000 || year > 9999) && !yearStr.isEmpty()){
                    success = false;
                    prompt.append("Year cannot be less than 1000 or more than 9999.\n");
                }
                if (success == true){
                    authorStr = authorField.getText();
                    authors = authorStr.split(",");
                }
                if (success == true){
                    temp = new Book (callNumber, title, publisher, year);
                    for (Reference current : ref){
                        if (temp.equals(current)){
                            exists = true;
                            break;
                        }
                    }
                    if (!exists){
                        ref.add(temp);
                        prompt.append ("Book successfully added.\n");
                        for (int i = 0; i < authors.length; i++){
                            temp.addAuthor(authors[i]);
                        }
                        theSearchMap.updateMap(theMap, ref);
                    }
                    else if (exists){
                        prompt.append("Book already exists.\n");
                    }
                }
            }
            else if (panel == 1){
                Journal temp;
                boolean success = true;
                callNumber = callFieldJ.getText();
                title = titleFieldJ.getText();
                organization = orgField.getText();
                yearStr = yearFieldJ.getText();
                if (callNumber.isEmpty()){
                    success = false;
                    prompt.setText("Cannot leave Call Number empty.\n");
                }
                if (title.isEmpty()){
                    prompt.append("Cannot leave Title empty.\n");
                    success = false;
                }
                if (yearStr.isEmpty()){
                    prompt.append("Cannot leave Year empty.\n");
                    success = false;
                }
                if (!yearStr.isEmpty()){
                    try {
                        year = Integer.parseInt(yearStr);
                    }
                    catch (NumberFormatException f){
                        year = 0;
                        success = false;
                        prompt.append("Invalid format for year.\n");
                    }
                }
                if ((year < 1000 || year > 9999) && !yearStr.isEmpty()){
                    success = false;
                    prompt.append("Year cannot be less than 1000 or more than 9999.\n");
                }
                if (success == true){
                    temp = new Journal (callNumber, title, organization, year);
                    for (Reference current : ref){
                        if (temp.equals(current)){
                            exists = true;;
                            break;
                        }
                    }
                    if (!exists){
                        ref.add(temp);
                        prompt.append ("Journal successfully added.\n");
                        theSearchMap.updateMap(theMap, ref);
                    }
                    else if (exists){
                        prompt.append("Journal already exists.\n");
                    }
                }
            }
        }
    }
}
