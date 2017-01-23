/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**This class is the search class. It creates and maintain the arrayList
 * for references. Its main purpose is to get input from the user to
 * search for matching items and list them. 
 *
 * @author aman dhiman
 */
public class LibrarySearch {
    private ArrayList<Reference> references = new ArrayList<>();
    
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    
    public ArrayList<Reference> getReferences(){
        return references;
    }
    
    public void listReferences (){
        System.out.println(references.size() + " reference(s) found\n");
        for (Reference temp : references){
            System.out.println (temp.toString());
        }
    }
    
    /**This method just prompts for call number and returns the value.
     @return call number string*/
    public String inputCallNumber() throws IOException{
        String callNumber;
        
        System.out.println("Please enter the Call Number:\n");
        callNumber = scan.readLine();
        
        return callNumber;
    }
    
    /**This method prompts the user to enter the year or the range of years 
    while explaining the rules of entering the year(s) and then returns the
    value.
    @return years range as integers.*/
    public int [] inputYear () throws IOException{
        String input;
        
        /**This stores the starting and ending years*/
        int[] years = new int[2];
        
        /**This stores the input from the user in array of words.*/
        String [] yearToken;
        
        do {
            
            years[0] = 0;
            years[1] = 0;
            System.out.println("Please enter the Year or range of Years:\n" +
                    "Rules:\nABCD (for a single year)\nABCD- (for ABCD and" +
                    " after)\n-ABCD (for ABCD and before)\nABCD-WXYZ (for" +
                    " years in that range)\n");
            input = scan.readLine();
            
            if (input.isEmpty()){
                years[0] = 1000;
                years[1] = 9999;
            }
        
            else if (!input.contains("-")){
                try {
                    years[0] = Integer.parseInt(input);
                    years[1] = years[0];
                }
                catch (NumberFormatException e){
                    years[0] = 0;
                    years[1] = 0;
                }
            }
            else if (input.contains("-")){
                yearToken = input.split("-");

                if (input.indexOf('-') == 0){
                    if (yearToken.length != 0){
                        try {
                            years[1] = Integer.parseInt(yearToken[1]);
                            years[0] = 1000;
                        }
                        catch (NumberFormatException e){
                            years[0] = 0;
                            years[1] = 0;
                        }
                    }
                }
                else {
                    if (yearToken.length == 1){
                        try {
                            years[0] = Integer.parseInt(yearToken[0]);
                            years[1] = 9999;
                        }
                        catch (NumberFormatException e){
                            years[0] = 0;
                            years[1] = 0;
                        }
                    }
                    else if (yearToken.length == 2){
                        try {
                            years[0] = Integer.parseInt(yearToken[0]);
                            years[1] = Integer.parseInt(yearToken[1]);
                        }
                        catch (NumberFormatException e){
                            years[0] = 0;
                            years[1] = 0;
                        }
                    }
                }
            }
            
            if (years[0] < 1000 || years[0] > 9999 || years[1] < 1000 ||
                years[1] > 9999){
                    System.out.println("Invalid input.\n");
            }
            
        } while (years[0] < 1000 || years[0] > 9999 || years[1] < 1000 ||
                years[1] > 9999);

        return years;
    }
    
    /**This is the core method of searching. It compares the values and
     prints the matching list of items from references.*/
    public void search(HashMap <String, List<Integer>> map) throws IOException{
        /**Starting and ending years.*/
        int [] years = new int[2];
        String callNumber;
        String title;
        
        /**The title keywords array.*/
        String [] keywords;
        
        /**Just to see that every keyword occurs atleast once in the title.*/
        int occurs;
        int matchedReferences = 0;
        String[] titleWords;
        
        /**If the call numbers are same.*/
        boolean equalCall;
        
        /**If the year is within the range.*/
        boolean equalYear;
        
        /**If all the keywords are in the title atleast once.*/
        boolean equalTitle = true;
        
        boolean keysExist = true;
        
        callNumber = inputCallNumber();
        years = inputYear();
        
        System.out.println("Please enter the keywords for title search:\n");
        title = scan.readLine();
        keywords = title.split(" +");
        
        /*Converts all keywords to lowercases*/
        String [] keys = new String [keywords.length];
        for (int i = 0; i < keywords.length; i++){
            keys[i] = keywords[i].toLowerCase();
        }
        
        /*If title is not empty, then it searches using the HashMap*/
        if (!title.isEmpty()){
            int numWords = keywords.length;
            List<Integer> ints = new ArrayList<Integer>();
            if (map.containsKey(keys[0])){
                ints.addAll(map.get(keys[0]));
            }
            for (int i = 1; i < numWords; i++){
                if (map.containsKey(keys[i])){
                    ints.retainAll(map.get(keys[i]));
                }
                else {
                    keysExist = false;
                }
            }
            
            for (int i = 0; i < ints.size(); i++){
                int index = ints.get(i);
                if ((callNumber.equals(references.get(index).getCallNumber()) ||
                        callNumber.isEmpty()) &&
                        references.get(index).getYear() >= years[0] &&
                        references.get(index).getYear() <= years[1] &&
                        keysExist){
                    System.out.println(references.get(index).toString());
                    matchedReferences ++;
                }
            }
            System.out.println(matchedReferences + " reference(s) found.\n");
        }
        /*Checks for the equality between call numbers, years and title 
        keywords and prints the matching list of references.*/
        if (title.isEmpty()){
            for (Reference ref : references){
                titleWords = ref.getTitle().split(" +");
                if (callNumber.equals(ref.getCallNumber()) || callNumber.isEmpty()){
                    equalCall = true;
                }
                else {
                    equalCall = false;
                }

                if (ref.getYear() >= years[0] && ref.getYear() <= years[1]){
                    equalYear = true;
                }
                else {
                    equalYear = false;
                }


                if (equalCall && equalYear && equalTitle){
                    System.out.println(ref.toString());
                    matchedReferences += 1;
                }
            }
            System.out.println(matchedReferences + " reference(s) found.\n");
        }
    }
}
