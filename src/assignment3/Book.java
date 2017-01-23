/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;

/**This class represents the structure of a book. It includes all the
 * variables and accessors associated with books and also includes
 * initialization, equals and toString methods.
 *
 * @author aman dhiman
 */
public class Book extends Reference{
    private ArrayList<String> author = new ArrayList<>();
    private String publisher;
    
    
    public Book (String callNumber, String title, String publisher, int year){
        this.callNumber = callNumber;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }
    
    public void addAuthor (String name){
        author.add(name);
    }

    public String getPublisher (){
        return publisher;
    }

    public ArrayList<String> getAuthor(){
        return author;
    }
    
    /**Checks if two books are equal.
    @param ref The reference to be compared to.
    @return Whether books are equal.*/
    @Override
    public boolean equals (Reference ref){
        if (this.callNumber.equals(ref.getCallNumber()) &&
            this.year == ref.getYear()){
            return true;
        }
        return false;
    }
    
    /**Returns a formatted string with the book's information.
     * @return String
     */
    @Override
    public String toString (){
        String output;
        int i = 1;
        output = "type = \"book\"" +NL + "callnumber = \"" + callNumber + "\"" +
                NL + "authors = \"";
        for (String name : author){
            output += name;
            if (i < author.size()){
                output += ", ";
            }
            i++;
        }
        output += "\"" + NL + "title = \"" + title + "\"" + NL + "publisher = \""
                + publisher + "\"" + NL + "year = \"" + year + "\"" + NL;
        return output;
    }
}
