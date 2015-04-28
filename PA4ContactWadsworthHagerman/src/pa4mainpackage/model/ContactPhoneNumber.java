package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This classes provides storage of PhoneNumbers to be used by the Contact class
 * 
 * @author Ben Wadsworth
 * @version 4-28-2015
 */
public class ContactPhoneNumber implements Serializable
{
    
    private ArrayList<String> phoneList;
    
    /**
     * Constructor to set the phoneList ArrayList to the passed ArrayList.
     * 
     * @param phoneNumber the ArrayList to set phoneList to
     */
    public ContactPhoneNumber(ArrayList<String> phoneNumber)
    {
        phoneList = phoneNumber;
        
    }//End of ContactPhoneNumber constructor
    
    /**
     * Overwrites the phoneList with a new list.
     * 
     * NOTE: This may not be the best way to modify the list? But it could be.
     * 
     * @param list the ArrayList to overwrite the current phoneList
     */
    public void setPhoneNumbersList(ArrayList<String> list)
    {
        phoneList = list;
    }//End setPhoneNumbersList method
    
    /**
     * Returns the phoneList ArrayList.
     * 
     * @return ArrayList the phoneList ArrayList
     */
    public ArrayList<String> getPhoneList()
    {
        return(phoneList);
    }//End getPhoneList method
    
    /**
     * Returns a String representation of the phoneList ArrayList.
     * 
     * @return String a String representation the the phoneList ArrayList
     */
    public String getAllPhoneNumbers()
    {
        
        Iterator iter = phoneList.iterator();
        String returnString = "";
        
        while(iter.hasNext())
        {
            returnString = returnString + iter.next();

            if(iter.hasNext() == true)
                returnString +=" ";
        }
        
        return(returnString);
        
    }//End of getAllPhoneNumbers method
    
    /**
     *
     * @return
     */
    public int size()
    {
        return(phoneList.size());
        
    }//End of size method
    
    /**
     * Returns the iterator of the phoneList ArrayList
     * 
     * @return Iterator an iterator object from phoneList
     */
    public Iterator iterator()
    {
        return(phoneList.iterator());
        
    }//End of iterator method

    @Override
    /**
     * Returns a string representation of the phoneList
     * 
     * @retrun String a string representation of the phoneList
     */
    public String toString()
    {
        Collection c = phoneList;
        Iterator iter = c.iterator();
        
        String returnString = "";
        
        while(iter.hasNext())
        {
            returnString = returnString + " | " + iter.next();
        }
        
        return(returnString);
        
    }//End of toString method
    
}//End of ContactPhoneNumber Class