
package pa4mainpackage.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.*;

/**
 * MAIN CLASS TO INTERACT WITH SUB-MODEL CLASSES!
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
        
    }//ENd of Constructor
    
    /**
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
     *
     * @param treeLocation
     * @return
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
        
    }//End of formattedGUIContact(Integer treeLocation) method
    
    /**
     *
     * @return String returnString
     */
    public TreeMap getTreeMapStorage()
    {
        return(storage);
        
    }//End of getTreeMapStorage() method
    
    public String getLast()
    {
        if(isEmpty() == false)
        {
            String returnString = "";
            Contact tempContact = (Contact) storage.get(storage.lastKey());
        
            returnString = "  " + tempContact.getLastName() + " " + tempContact.getFirstName() + " " +
                tempContact.getOrganization() + " " + tempContact.getContactPhoneNumber() + 
                   " " + tempContact.getContactEmailAddress();
               
             return(returnString);
       
        }
        else
            return("Error: The Collection is Empty");

    }
    
    public String getMin()
    {
        if(isEmpty() == false)
        {
            String returnString = "";
            Contact tempContact = (Contact) storage.get(storage.firstKey());
        
            returnString = "  " + tempContact.getLastName() + " " + tempContact.getFirstName() + " " +
                tempContact.getOrganization() + " " + tempContact.getContactPhoneNumber() + 
                   " " + tempContact.getContactEmailAddress();
               
             return(returnString);
       
        }
        else
            return("Error: The Collection is Empty");

    }
    
    public void deleteMax()
    {
        if (isEmpty() == false)
            storage.remove(storage.lastKey());
    }
    
    public void deleteMin()
    {
        if (isEmpty() == false)
            storage.remove(storage.firstKey());
    }
  
    
    public boolean isEmpty()
    {
        return storage.isEmpty();
    }
    
    
    /**
     *  
     * @return String returnSting
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
    }
    
}//End of ModelHandler Class
