
package pa4mainpackage.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.*;

/**
 * MAIN CLASS TO INTERACT WITH SUB-MODEL CLASSES
 * @author Ben Wadsworth, John Hagerman
 */
public class ModelHandler 
{
    TreeMap storage;
    PrimaryKeyHandler keys;
    
    /**
     * 
     */
    public ModelHandler()
    {
        storage = new TreeMap();
        keys = new PrimaryKeyHandler();
        
    }//End of Constructor
    
    /**
     * Method for adding a new contact to the TreeMap
     * 
     * @param firstName     
     * @param lastName
     * @param organization
     * @param phoneNumbers
     * @param emailAddresses
     */
    public void addContact(String firstName, String lastName,String organization, 
            ArrayList<String> phoneNumbers,
            ArrayList<String>emailAddresses)
    {
        Contact tempContact;
        tempContact = new Contact(keys.getNextAvailableKey(), firstName, lastName, organization, phoneNumbers, emailAddresses);
        storage.put(tempContact.getKeyID(), tempContact);
        
    }//End of addContact() Method
    
    
    /**
     *
     * @param treeLocation
     */
    public void deleteContact(Integer treeLocation)
    {
        if(storage.containsKey(treeLocation))
        {
            storage.remove(treeLocation);
            keys.addAKey(treeLocation);
        }
        
    }//End of deleteContact() method
    
    
    /**
     *
     * @param treeLocation
     * @return
     */
    public Contact getContact(Integer treeLocation)
    {
        return((Contact) storage.get(treeLocation));
        
    }//End of getContact(Integer treeLocation) method
    
    
    /**
     * This method formats a contact so that is is in columns of fixed width
     * 
     * @param treeLocation      //Key
     * @return String representation of formatted Contact
     */
    public String formattedGUIContact(Integer treeLocation)
    {
        String returnString = "";
        Contact tempContact = (Contact) storage.get(treeLocation);
        
        String phoneString = tempContact.getContactPhoneNumber().getAllPhoneNumbers();
        List<String> phoneList = new ArrayList<>(Arrays.asList(phoneString.split(" ")));
        String phoneListString = "           ";
        String emailString = tempContact.getContactEmailAddress().getAllEmailAddresses();
        List<String> emailList = new ArrayList<>(Arrays.asList(emailString.split(" ")));
        String emailListString = "           ";
        
        String extraString = "";
        
        String[][] outPutArray = new String[6][2];
        
        if(emailList.isEmpty() == false)
            emailListString = emailList.get(0);
        
        if(phoneList.isEmpty() == false)
            phoneListString = phoneList.get(0);

        for (int i = 0; i < phoneList.size(); i++)
            outPutArray[i][0] = phoneList.get(i);
        
        for (int i = 0; i < emailList.size(); i++)
            outPutArray[i][1] = emailList.get(i);
        
        if((outPutArray[1][0] != null) || (outPutArray[1][1] != null))
            extraString +="\n";
       
        for(int i = 1; i < 5; i++)
        {
            if( (outPutArray[i][0] != null) && (outPutArray[i][1] != null)) 
            {
                extraString += String.format("%71s", outPutArray[i][0]) + " "
                        + outPutArray[i][1]; 
                  
                  if(i != 5)
                      if((outPutArray[i + 1][0] != null) && (outPutArray[i + 1][1] != null));
                          extraString += "\n";                    
            }
     
            else if( (outPutArray[i][0] == null) && (outPutArray[i][1] != null)) 
            {
                extraString += String.format("%71s", "           ") + " "
                        + outPutArray[i][1]; 
                
                if(i != 5)
                    if((outPutArray[i + 1][0] != null) && (outPutArray[i + 1][1] != null));
                        extraString += "\n";
                
            }
            else if( (outPutArray[i][0] != null) && (outPutArray[i][1] == null)) 
            {
                 extraString += String.format("%71s", outPutArray[i][0]);
                 
                 if(i != 5)
                    if((outPutArray[i + 1][0] != null) && (outPutArray[i + 1][1] != null));
                        extraString += "\n";
            }             
        }
        returnString = "  " +
                String.format("%-8s", treeLocation) + " " +
                String.format("%-16s",tempContact.getLastName()) + " " +
                String.format("%-16s",tempContact.getFirstName()) + " " +
                String.format("%-16s",tempContact.getOrganization()) +
                phoneListString + " " + emailListString + extraString ;
                         
        return(returnString);
        
    }//End of formattedGUIContact() method
    
    
    /**
     * 
     * @return 
     */
    public TreeMap getTreeMapStorage()
    {
        return(storage);
        
    }//End of getTreeMapStorage() method
    
    
    /**
     *  Takes the last element in the TreeMap and returns it as
     *  a string it also checks to make sure isEmpty() is false
     * 
     * @return String representation of contact
     */
    public String getLast()
    {
        if(isEmpty() == false)
        {
            String returnString = "";
            Contact tempContact = (Contact) storage.get(storage.lastKey());
        
            returnString =   "Last Name:  " + tempContact.getLastName()
                    + "\n" + "First Name: " + tempContact.getFirstName() 
                    + "\n" + "Org Name:   " + tempContact.getOrganization()
                    + "\n" + "Phone Numbers:   " + tempContact.getContactPhoneNumber()
                    + "\n" + "Email Addresses: " + tempContact.getContactEmailAddress();
                    
             return(returnString);
       
        }
        else
            return("Error: The Collection is Empty");

    }//End of getLast() method
    
    
    /**
     * Takes the first element in the TreeMap and returns it as
     * a string it also checks to make sure isEmpty() is false
     * 
     * @return String representation of contact
     */
    public String getMin()
    {
        if(isEmpty() == false)
        {
            String returnString = "";
            Contact tempContact = (Contact) storage.get(storage.firstKey());
        
            returnString =   "Last Name:  " + tempContact.getLastName()
                    + "\n" + "First Name: " + tempContact.getFirstName() 
                    + "\n" + "Org Name:   " + tempContact.getOrganization()
                    + "\n" + "Phone Numbers:   " + tempContact.getContactPhoneNumber()
                    + "\n" + "Email Addresses: " + tempContact.getContactEmailAddress();
               
             return(returnString);
       
        }
        else
            return("Error: The Collection is Empty");

    }//End of getMin() method
    
    
    /**
     * Method for deleting the last item in the TreeMap.
     */
    public void deleteMax()
    {
        if (isEmpty() == false)
            storage.remove(storage.lastKey());
        
    }//End of deleteMax() method
    
    
    /**
     * Method for deleting the first item in the TreeMap
     */
    public void deleteMin()
    {
        if (isEmpty() == false)
            storage.remove(storage.firstKey());
        
    }//End of deleteMin() method
  
    
    /**
     * Method for checking if treeMap is empty
     * 
     * @return Boolean 
     */
    public boolean isEmpty()
    {
        return storage.isEmpty();
        
    }//End of isEmpty() method
    
    
    /**
     * Iterates through the TreeMap and prepares a formatted
     * string of all the elements within the tree.
     * 
     * @return string representation of TreeMap
     */
    @Override
    public String toString()
    {
         Set set = storage.entrySet();
         String returnString = "";
         Iterator i = set.iterator();
       
         while(i.hasNext()) 
         {
             Map.Entry entry = (Map.Entry)i.next();
             int x = (int) entry.getKey();
             returnString += formattedGUIContact(x);
             returnString += "\n";
         }
         return(returnString);
         
    }//End of toString() method
    
    
    /**
     * Iterates through the TreeMap in reverse and prepares a 
     * formatted string of all the elements within the tree.
     * 
     * @return String representation of TreeMap
     */
    public String reverseToString()
    {
         NavigableMap nmap = storage.descendingMap();
         Set set = nmap.entrySet();
         String returnString = "";
         Iterator i = set.iterator();
         
         while(i.hasNext()) 
         {
             Map.Entry entry = (Map.Entry)i.next();
             int x = (int) entry.getKey();
             returnString += formattedGUIContact(x);
             returnString += "\n";
         }
        return(returnString);
        
    }//End of reverseToString() method
    
}//End of ModelHandler Class
