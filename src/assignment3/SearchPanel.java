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
public class SearchPanel extends JPanel implements ActionListener{
    JPanel input;
    JPanel buttons;
    JTextArea results;
    JTextField callField;
    JTextField titleField;
    JTextField startYear;
    JTextField endYear;
    ArrayList<Reference> ref;
    JButton reset;
    JButton search;
    HashMap<String, List<Integer>> theMap;
    SearchHashMap theSearchMap;
    
    public SearchPanel (ArrayList<Reference> reference, HashMap<String, List<Integer>> map, SearchHashMap searchMap){
        super();
        ref = reference;
        theMap = map;
        theSearchMap = searchMap;
        input = new JPanel();
        buttons = new JPanel();
        JPanel fields = new JPanel();
        JPanel labels = new JPanel();
        JPanel message = new JPanel();
        labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
        fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
        
        JLabel call = new JLabel("Call No:");
        callField = new JTextField(30);
        labels.add(createVerticalStrut(32));
        labels.add(call);
        labels.add(createVerticalStrut(14));
        fields.add(createVerticalStrut(35));
        fields.add(callField);
        fields.add(createVerticalStrut(10));
        
        JLabel title = new JLabel("Title Keywords:");
        titleField = new JTextField(30);
        labels.add(title);
        labels.add(createVerticalStrut(14));
        fields.add(titleField);
        fields.add(createVerticalStrut(10));
        
        JLabel yearS = new JLabel("Start Year:");
        startYear = new JTextField(30);
        labels.add(yearS);
        labels.add(createVerticalStrut(14));
        fields.add(startYear);
        fields.add(createVerticalStrut(10));
        
        JLabel yearJ = new JLabel("End Year:");
        endYear = new JTextField(30);
        labels.add(yearJ);
        labels.add(createVerticalStrut(12));
        fields.add(endYear);
        fields.add(createVerticalStrut(10));
        
        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
        input.add(labels);
        input.add(createHorizontalStrut(8));
        input.add(fields);
        input.setBorder(new EmptyBorder (30,20,50,0));
        
        add(input);
        
        reset = new JButton("Reset");
        reset.setMargin(new Insets (0,16,0,16));
        reset.addActionListener(this);

        search = new JButton("Search");
        search.setMargin(new Insets (0,16,0,16));
        search.addActionListener(this);
        
        buttons.setLayout (new GridLayout (2,1,0,20));
        buttons.add(reset);
        buttons.add(search);
        buttons.setBorder(new EmptyBorder(10,60,20,20));
        
        add(buttons);
        
        BorderLayout messageB = new BorderLayout();
        messageB.setVgap(10);
        message.setLayout(messageB);
        JLabel res = new JLabel("Search Results");
        results = new JTextArea (20,55);
        results.setEditable(false);
        JScrollPane text = new JScrollPane (results);
        message.add(res, BorderLayout.NORTH);
        message.add(text, BorderLayout.CENTER);
        
        add(message);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        results.setText("");
        String callNumber = "";
        String title = "";
        int yearS = 0;
        int yearE = 0;
        String sYearStr = "";
        String eYearStr = "";
        boolean exists = false;
        String [] keywords;
        String [] keys;
        int occurs;
        int matchedReferences = 0;
        String[] titleWords;
        boolean equalCall;
        boolean equalYear;
        boolean equalTitle = true;
        boolean keysExist = true;
        
        if (e.getSource() == reset){
            callField.setText("");
            titleField.setText("");
            startYear.setText("");
            endYear.setText("");
        }
        else if (e.getSource() == search){
            callNumber = callField.getText();
            title = titleField.getText();
            sYearStr = startYear.getText();
            eYearStr = endYear.getText();
            keywords = title.split(" +");
            results.setText("");
            
            keys = new String [keywords.length];
            for (int i = 0; i < keywords.length; i++){
                keys[i] = keywords[i].toLowerCase();
            }
            if (sYearStr.isEmpty()){
                yearS = 1000;
            }
            else {
                try {
                    yearS = Integer.parseInt(sYearStr);
                }
                catch (NumberFormatException f){
                    yearS = 0;
                    results.setText("Invalid input for Start Year.\n");
                    return;
                }
            }
            
            if (eYearStr.isEmpty()){
                yearE = 9999;
            }
            else {
                try {
                    yearE = Integer.parseInt(eYearStr);
                }
                catch (NumberFormatException f){
                    yearE = 0;
                    results.setText("Invalid input for End Year.\n");
                    return;
                }
            }
            if (yearE < yearS){
                results.setText("Start Year cannot be greater than End Year.\n");
                return;
            }
            if (!title.isEmpty()){
                int numWords = keywords.length;
                List<Integer> ints = new ArrayList<Integer>();
                if (theMap.containsKey(keys[0])){
                    ints.addAll(theMap.get(keys[0]));
                }
                for (int i = 1; i < numWords; i++){
                    if (theMap.containsKey(keys[i])){
                        ints.retainAll(theMap.get(keys[i]));
                    }
                    else {
                        keysExist = false;
                    }
                }

                for (int i = 0; i < ints.size(); i++){
                    int index = ints.get(i);
                    if ((callNumber.equals(ref.get(index).getCallNumber()) ||
                            callNumber.isEmpty()) &&
                            ref.get(index).getYear() >= yearS &&
                            ref.get(index).getYear() <= yearE &&
                            keysExist){
                        results.append(ref.get(index).toString() + "\n");
                        matchedReferences ++;
                    }
                }
                results.append(matchedReferences + " reference(s) found.\n");
            }
            /*Checks for the equality between call numbers, years and title 
            keywords and prints the matching list of ref.*/
            else if (title.isEmpty()){
                for (Reference reference : ref){
                    titleWords = reference.getTitle().split(" +");
                    if (callNumber.equals(reference.getCallNumber()) || callNumber.isEmpty()){
                        equalCall = true;
                    }
                    else {
                        equalCall = false;
                    }

                    if (reference.getYear() >= yearS && reference.getYear() <= yearE){
                        equalYear = true;
                    }
                    else {
                        equalYear = false;
                    }


                    if (equalCall && equalYear && equalTitle){
                        results.append(reference.toString() + "\n");
                        matchedReferences += 1;
                    }
                }
                results.append(matchedReferences + " reference(s) found.\n");
            }
        }
        validate();
        repaint();
    }
}
