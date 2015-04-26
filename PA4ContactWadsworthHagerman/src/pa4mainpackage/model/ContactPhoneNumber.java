package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
@modified by John Hagerman April 26th, modified getallphonenumbers method, 

@author Ben Wadsworth, John Hagerman
*/
public class ContactPhoneNumber implements Serializable
{
    private ArrayList<String> phoneList;
    
    /**
     *
     * @param phoneNumber
     */
    public ContactPhoneNumber(ArrayList<String> phoneNumber)
    {
        phoneList = phoneNumber;
        
    }//End of ContactPhoneNumber constructor
    
    /**
     *
     * @param phoneNumber
     */
    public void addPhoneNumber(String phoneNumber)
    {
        phoneList.add(phoneNumber);
        
    }//End of addPhoneNumber(String phoneNumber) method
    
    /**
     *
     * @param index
     */
    public void deletePhoneNumber(int index)
    {
        phoneList.remove(index);
        
    }//End of deletePhoneNumber(int index) method
    
    /**
     *
     * @return
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
        
    }//End of getAllPhoneNumbers() method
    
    /**
     *
     * @return
     */
    public int size()
    {
        return(phoneList.size());
        
    }//End of size() method
    
    /**
     *
     * @return
     */
    public Iterator iterator()
    {
        return(phoneList.iterator());
        
    }//End of iterator() method
    
    @Override
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
        
    }//End of toString() method
    
}//End of ContactPhoneNumber Class