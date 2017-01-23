/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**This class represents the structure of a journal. It includes all the
 * variables and accessors associated with journals and also includes
 * initialization, equals and toString methods.
 *
 * @author aman dhiman
 */
public class Journal extends Reference{
    private String organization;
    
    public Journal (String callNumber, String title, String organization, int year){
        this.callNumber = callNumber;
        this.title = title;
        this.organization = organization;
        this.year = year;
    }
    
    public String getOrganization (){
        return organization;
    }
    
    /**Checks if two journals are equal.
    @param ref The reference to be compared to.
    @return Whether journals are equal.*/
    @Override
    public boolean equals (Reference ref){
        if (this.callNumber.equals(ref.getCallNumber()) &&
            this.year == ref.getYear()){
            return true;
        }
        return false;
    }
    
    /**Returns a formatted string with the journal's information.
     * @return String
     */
    @Override
    public String toString (){
        return ("type = \"journal\"" + NL + "callnumber = \"" + callNumber + 
                "\"" + NL + "title = \"" + title + "\"" + NL + "organization = \""
                + organization + "\"" + NL + "year = \"" + year + "\"" + NL);
    }
}    
