package pa4mainpackage.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ContactPhoneNumber extends PriorityQueue
{
    private ArrayList<String> phoneList;
    
    public ContactPhoneNumber(String... phoneNumber)
    {
        phoneList = new ArrayList<>();
        
        for(String phone : phoneNumber)
        {
            phoneList.add(phone);
        }
    }
    
    public void addPhoneNumber(String phoneNumber)
    {
        phoneList.add(phoneNumber);
    }
    
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