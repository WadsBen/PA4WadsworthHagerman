package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ContactPhoneNumber implements Serializable
{
    private ArrayList<String> phoneList;
    
    public ContactPhoneNumber(ArrayList<String> phoneNumber)
    {
        phoneList = phoneNumber;
    }
    
    public void addPhoneNumber(String phoneNumber)
    {
        phoneList.add(phoneNumber);
    }
    
    public void deletePhoneNumber(int index)
    {
        phoneList.remove(index);
    }
    
    public String getAllPhoneNumbers()
    {
        Iterator iter = phoneList.iterator();
        String returnString = "";
        
        while(iter.hasNext())
        {
            returnString = returnString + iter.next() + "\n";
        }
        
        return(returnString);
    }
    
    public int size()
    {
        return(phoneList.size());
    }
    
    public Iterator iterator()
    {
        return(phoneList.iterator());
    }
    
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
    }
}