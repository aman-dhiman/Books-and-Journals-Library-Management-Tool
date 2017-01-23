/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**This class takes care of the file input and output methods
 *
 * @author aman dhiman
 */
public class FileIO {
    
    /**Uses the filename of the input file to populate the reference arraylist
     * 
     * @param name name of the file
     * @param ref reference arraylist
     */
    public void input (String name, ArrayList<Reference> ref) {
        Scanner stream = null;
        String [] token;
        String line;
        String callNumber;
        String title;
        int year;
        String type;
        
        /*If the file doesn't exist, creates an empty array*/
        try {
            stream = new Scanner (new FileInputStream (name));
        }
        catch (FileNotFoundException e) {
            
        }
        if (stream != null && stream.hasNextLine()){
            do {
                line = stream.nextLine();
                token = line.split(" ");

                if (token[0].equalsIgnoreCase("type")){
                    token = line.split("\"");
                    type = token[1];
                    if (type.equalsIgnoreCase("book")){
                        String publisher = "";
                        String authors;
                        String [] author = {};
                        boolean authorExist = false;
                        boolean bookExists = false;
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        callNumber = token[1];
                        
                        line = stream.nextLine();
                        token = line.split ("\"");
                        if (token.length > 1){
                            authors = token[1];
                            author = authors.split(" ,");
                            authorExist = true;
                        }
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        title = token[1];
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        if (token.length > 1){
                            publisher = token[1];
                        }
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        year = Integer.parseInt(token[1]);
                        
                        Book temp = new Book(callNumber, title, publisher, year);
                        if (authorExist == true){
                            for (String cur : author){
                                temp.addAuthor(cur);
                            }
                        }
                        
                        for (Reference reference : ref){
                            if (temp.equals(reference)){
                                bookExists = true;
                            }
                        }
                        if (bookExists == false){
                            ref.add(temp);
                        }
                        else {
                            System.out.println("The reference already exists.\n");
                        }
                    }
                    
                    else if (type.equalsIgnoreCase("journal")){
                        String organization = "";
                        boolean journalExists = false;
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        callNumber = token[1];
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        title = token[1];
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        if (token.length > 1){
                            organization = token[1];
                        }
                        
                        line = stream.nextLine();
                        token = line.split("\"");
                        year = Integer.parseInt(token[1]);
                        
                        Journal temp = new Journal (callNumber, title, organization, year);
                        for (Reference reference : ref){
                            if (temp.equals(reference)){
                                journalExists = true;
                            }
                        }
                        if (journalExists == false){
                            ref.add(temp);
                        }
                        else {
                            System.out.println("The reference already exists.\n");
                        }
                    }
                }
            }while (stream.hasNextLine() && !token[0].equalsIgnoreCase("type"));
            
            stream.close();
        }
    }
    
    /**Outputs all the references in a typical format to the given filename
     * 
     * @param name name of the file
     * @param ref reference arraylist
     * @throws FileNotFoundException 
     */ 
    public void output (String name, ArrayList<Reference> ref) throws FileNotFoundException{
        PrintWriter output = null;
        try {
            output = new PrintWriter (new FileOutputStream (name));
        }
        catch (FileNotFoundException e){
            System.out.println ("Error opening the file.");
            System.exit(0);
        }
        
        for (Reference current : ref){
            output.println(current.toString());
        }
        output.close();
    }
}
