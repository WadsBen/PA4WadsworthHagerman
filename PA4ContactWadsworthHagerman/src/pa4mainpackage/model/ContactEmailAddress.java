package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ContactEmailAddress implements Serializable
{
    private ArrayList<String> emailList;
    
    public ContactEmailAddress(String... email)
    {
        emailList = new ArrayList<>();
        
        for(String emails : email)
        {
            emailList.add(emails);
        }
    }
    
    public void addEmailAddress(String email)
    {
        emailList.add(email);
    }
    
    public void deleteEmailAddress(int index)
    {
        emailList.remove(index);
    }
    
    public int size()
    {
        return(emailList.size());
    }
    
    public String getAllEmailAddresses()
    {
        Iterator iter = emailList.iterator();
        String returnString = "";
        
        while(iter.hasNext())
        {
            returnString = returnString + iter.next() + String.format("%n", "");
        }
        
        return(returnString);
    }
    
    public Iterator iterator()
    {
        return(emailList.iterator());
    }
    
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
    }
}