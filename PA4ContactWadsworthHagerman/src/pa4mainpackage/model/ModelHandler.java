/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.model;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * MAIN CLASS TO INTERACT WITH SUB-MODEL CLASSES!
 * @author Ben Wadsworth
 */
public class ModelHandler 
{
    TreeMap storage;
    PrimaryKeyHandler keys;
    
    public ModelHandler()
    {
        storage = new TreeMap();
        keys = new PrimaryKeyHandler();
    }
    
    public void addContact(String firstName, String lastName,String organization, 
            ArrayList<String> phoneNumbers,
            ArrayList<String>emailAddresses)
    {
        Contact tempContact;
        tempContact = new Contact(keys.getNextAvailableKey(), firstName, lastName, organization, phoneNumbers, emailAddresses);
        storage.put(tempContact.getKeyID(), tempContact);
    }
    
    public void deleteContact(Integer treeLocation)
    {
        if(storage.containsKey(treeLocation))
        {
            storage.remove(treeLocation);
            keys.addAKey(treeLocation);
        }
    }
    
    public Contact getContact(Integer treeLocation)
    {
        return((Contact) storage.get(treeLocation));
    }
    
    public String formattedGUIContact(Integer treeLocation)
    {
        String returnString = "";
        Contact tempContact = (Contact) storage.get(treeLocation);
        
        returnString = "ID    -     Last Name     -     First Name     -     Organization     -     " +
                "Phone Numbers   -   Email Addresses\n" + 
                "====================================================================" +
                "============================\n" +
                treeLocation + "     " + tempContact.getLastName() + String.format("%" + (29 - (tempContact.getLastName().length() * 2)) + "s", " ") + 
                tempContact.getFirstName() + String.format("%" + (30 - tempContact.getFirstName().length() * 2) + "s", " ") + 
                tempContact.getOrganization() + String.format("%" + (19 - tempContact.getOrganization().length()) + "s", " ") +
                tempContact.getContactPhoneNumber().getAllPhoneNumbers();
        
        return(returnString);
    }
    
    public TreeMap getTreeMapStorage()
    {
        return(storage);
    }
    
    public String toString()
    {
        return(storage.toString());
    }
}
