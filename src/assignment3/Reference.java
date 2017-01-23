/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**The parent class to both books and journals
 *
 * @author aman dhiman
 */
public class Reference {
    protected String callNumber;
    protected String title;
    protected int year;
    protected static final String NL = System.getProperty("line.separator");
    
    public String getCallNumber (){
        return callNumber;
    }
    
    public String getTitle (){
        return title;
    }
        
    public int getYear (){
        return year;
    }
    
    /**Checks if two references are equal
     * 
     * @param ref The reference arraylist
     * @return boolean
     */
    public boolean equals(Reference ref){
        if (this.callNumber.equals(ref.getCallNumber()) &&
            this.year == ref.getYear()){
            return true;
        }
        return false;
    }
    
    /**Returns a formatted string with reference's information
     * 
     * @return String
     */
    public String toString(){
        String output;
        output = "type = \"reference\"" + NL + "callnumber = \"" + callNumber + 
                "\"" + NL + "title = \"" + title + "\"" + NL + "year = \"" + year + 
                "\"" + NL;
        return output;
    }
}
