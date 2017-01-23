/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class PrintMapPanel extends JPanel{
    JTextArea hashMap;
    public PrintMapPanel(){
        super();
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder (10,10,10,10));
        
        JLabel label = new JLabel("Hash Map");
        add(label, BorderLayout.NORTH);
        
        hashMap = new JTextArea ();
        hashMap.setEditable(false);
        hashMap.setLineWrap(true);
        hashMap.setWrapStyleWord(true);
        hashMap.setMargin(new Insets (0,0,0,0));
        add(hashMap, BorderLayout.CENTER);
    }
    
    public void printMap (HashMap<String, List<Integer>> map){
        hashMap.setText("");
        Set<Map.Entry<String, List<Integer>>> mapSet = map.entrySet();
        Iterator<Map.Entry<String, List<Integer>>> itr = mapSet.iterator();

        while (itr.hasNext()){
            Map.Entry<String, List<Integer>> entry = itr.next();
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            hashMap.append("Key = \"" + key + "\" has values: " + values + "\n");
        }
    }
    
}
