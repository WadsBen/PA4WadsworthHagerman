package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * Handles storage and manipulation of the ArrayList emailList that stores all
 * the email addresses for a given contact.
 * 
 * @author Ben Wadsworth
 * @author John Hagerman
 * @version 4-30-2015
 */
public class ContactEmailAddress implements Serializable
{
    private ArrayList<String> emailList;
    
    /**
     * ContactEmailAddress constructor to initialize the ArrayList emailList to
     * the passed ArrayList object.
     * 
     * @param email ArrayList object to set emailList to.
     */
    public ContactEmailAddress(ArrayList<String> email)
    {
        emailList = email;
        
    }//End of ContactEmailAddess() constructor
    
    /**
     * Sets the emailList to the past ArrayList object.
     * 
     * @param list the passed ArrayList
     */
    public void setEmailList(ArrayList<String> list)
    {
        emailList = list;
    }//End setEmailList method
    
    /**
     * Returns the ArrayList object storing emailList.
     * 
     * @return ArrayList store of the emailList
     */
    public ArrayList<String> getEmailList()
    {
        return(emailList);
    }//End getEmailList method
    
    /**
     * Returns the size of the emailList.
     * 
     * @return int size of the emailList
     */
    public int size()
    {
        return(emailList.size());
        
    }//End size method
    
    /**
     * Returns a String representation of the emailList.
     * 
     * @return String representation of the emailList
     */
    public String getAllEmailAddresses()
    {
        Iterator iter = emailList.iterator();
        String returnString = "";
        
        while(iter.hasNext())
        {
            returnString = returnString + iter.next();
            if(iter.hasNext() == true)
                returnString +=" ";
                    //+ String.format("%n", "");
        }
        
        return(returnString);
        
    }//End getAllEmailAddresses method
    
    /**
     * Returns an iterator for the emailList.
     * 
     * @return Iterator an iterator for the emailList
     */
    public Iterator iterator()
    {
        return(emailList.iterator());
        
    }//End of iterator method
    
    /**
     *
     * @return String a string representation of the emailList
     */
    @Override
    public String toString()
    {
        Collection c = emailList;
        Iterator iter = c.iterator();
        
        String returnString = "";
        
        while(iter.hasNext())
        {
            returnString = returnString + " | " + iter.next();
        }
        
        return(returnString);
        
    }//End toString Override
    
}//End of ContactEmailAddress Class