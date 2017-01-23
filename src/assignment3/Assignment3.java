/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author aman dhiman
 */
public class Assignment3 {

    public static void main (String[] args) throws FileNotFoundException{
        String filename = "output.txt";
        LibrarySearch library = new LibrarySearch();
        FileIO fileIO = new FileIO();
        fileIO.input(filename, library.getReferences());
        MainScreen mainScreen = new MainScreen(library.getReferences(), fileIO, filename);
    }
    
}
