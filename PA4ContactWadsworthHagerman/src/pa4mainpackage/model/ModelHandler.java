
package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This class is what the controller should use to interact with the sub-model
 * classes and provides all the access needed to manipulate the model.
 * 
 * @author Ben Wadsworth, John Hagerman
 * @version 4-28-2015
 */
public class ModelHandler implements Serializable
{
    
    TreeMap storage;
    PrimaryKeyHandler keys;
    
    /**
     * No-arg constructor
     */
    public ModelHandler()
    {
        storage = new TreeMap();
        keys = new PrimaryKeyHandler();
        
    }//End of no-arg ModelHandler constructor
    
    /**
     * Method for adding a new contact to the TreeMap
     * 
     * @param firstName the first name of the contact     
     * @param lastName the last name of the contact
     * @param organization the organization name of the contact
     * @param phoneNumbers phone numbers of the contact
     * @param emailAddresses email addresses of the contact
     */
    public void addContact(String firstName, String lastName,String organization, 
            ArrayList<String> phoneNumbers,
            ArrayList<String>emailAddresses)
    {
        
        Contact tempContact;
        tempContact = new Contact(keys.getNextAvailableKey(), firstName, lastName, organization, phoneNumbers, emailAddresses);
        storage.put(tempContact.getKeyID(), tempContact);
        
    }//End of addContact Method

    /**
     * Method to delete a contact from the TreeMap storage.
     * 
     * @param treeLocation the key value which specifies where in the tree to
     * delete the contact
     */
    public void deleteContact(Integer treeLocation)
    {
        
        if(storage.containsKey(treeLocation))
        {
            storage.remove(treeLocation);
            keys.addAKey(treeLocation);
        }
        
    }//End of deleteContact method

    /**
     * Method to retrieve a contact from the TreeMap storage.
     * 
     * @param treeLocation the key value which specifies where in the tree to get
     * the contact
     * @return Contact the contact at the specified location
     */
    public Contact getContact(Integer treeLocation)
    {
        return((Contact) storage.get(treeLocation));
    }//End of getContact method

    /**
     * Method to get the TreeMap collection storing the contacts.
     * 
     * NOTE: It doesn't seem like it's a good idea to offer the full
     * storage. In the future there should probably be more methods that provide
     * specified access to the storage.
     * 
     * @return TreeMap the TreeMap collection storing the contacts.
     */
    public TreeMap getTreeMapStorage()
    {
        return(storage);
    }//End of getTreeMapStorage method    
     
    /**
     * Method for deleting the last item in the TreeMap.
     */
    public void deleteMax()
    {
        
        if (isStorageEmpty() == false)
            storage.remove(storage.lastKey());
        
    }//End of deleteMax method
    
    
    /**
     * Method for deleting the first item in the TreeMap
     */
    public void deleteMin()
    {
        
        if (isStorageEmpty() == false)
            storage.remove(storage.firstKey());
        
    }//End of deleteMin method
    
    /**
     * Checks if there is a key available to use.
     * 
     * @return boolean true if there is a key, false otherwise
     */
    public boolean isAvailableKey()
    {
        return(keys.isEmpty());
    }//end isAvailableKey method
    
    /**
     * Method for checking if the TreeMap collection is empty.
     * 
     * @return boolean true if collection is empty, false if there is at least one element
     */
    public boolean isStorageEmpty()
    {
        return storage.isEmpty();
    }//End of isEmpty method

}//End of ModelHandler Class
