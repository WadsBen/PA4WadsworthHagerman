package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
@author Ben Wadsworth, John Hagerman

UPDATED THE GET ALL EMAIL ADDRESS METHOD CHANGED A WEE BIT WITH IT
*/

public class ContactEmailAddress implements Serializable
{
    private ArrayList<String> emailList;
    
    /**
     *
     * @param email
     */
    public ContactEmailAddress(ArrayList<String> email)
    {
        emailList = email;
        
    }//End of ContactEmailAddess() constructor
    
    /**
     *
     * @param email
     */
    public void addEmailAddress(String email)
    {
        emailList.add(email);
        
    }//End of addEmailAddress() method
    
    /**
     *
     * @param index
     */
    public void deleteEmailAddress(int index)
    {
        emailList.remove(index);
        
    }//End of deleteEmailAddress() method
    
    public void setEmailList(ArrayList<String> list)
    {
        emailList = list;
    }
    
    public ArrayList<String> getEmailList()
    {
        return(emailList);
    }
    
    /**
     *
     * @return
     */
    public int size()
    {
        return(emailList.size());
        
    }//End of size() method
    
    /**
     *
     * @return
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
        
    }//End of getAllEmailAddresses() method
    
    /**
     *
     * @return
     */
    public Iterator iterator()
    {
        return(emailList.iterator());
        
    }//End of iterator() method
    
    /**
     *
     * @return
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
        
    }//End of toString() method
    
}//End of ContactEmailAddress Class