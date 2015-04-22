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
    
    public void addEmail(String email)
    {
        emailList.add(email);
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