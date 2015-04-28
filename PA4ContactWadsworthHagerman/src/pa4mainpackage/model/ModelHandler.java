
package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.*;

/**
 * MAIN CLASS TO INTERACT WITH SUB-MODEL CLASSES
 * @author Ben Wadsworth, John Hagerman
 */
public class ModelHandler implements Serializable
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
     * 
     * @return 
     */
    public TreeMap getTreeMapStorage()
    {
        return(storage);
        
    }//End of getTreeMapStorage() method    
     
    /**
     * Method for deleting the last item in the TreeMap.
     */
    public void deleteMax()
    {
        if (isStorageEmpty() == false)
            storage.remove(storage.lastKey());
        
    }//End of deleteMax() method
    
    
    /**
     * Method for deleting the first item in the TreeMap
     */
    public void deleteMin()
    {
        if (isStorageEmpty() == false)
            storage.remove(storage.firstKey());
        
    }//End of deleteMin() method
    
    public boolean isAvailableKey()
    {
        return(keys.isEmpty());
    }
  
    
    /**
     * Method for checking if treeMap is empty
     * 
     * @return Boolean 
     */
    public boolean isStorageEmpty()
    {
        return storage.isEmpty();
        
    }//End of isEmpty() method

    
}//End of ModelHandler Class
