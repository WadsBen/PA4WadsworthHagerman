/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.model;

/**
 * MAIN CLASS TO INTERACT WITH SUB-MODEL CLASSES!
 * @author Ben Wadsworth
 */
public class ModelHandler 
{
    PA4TreeMapStore storage;
    PrimaryKeyHandler keys;
    
    public ModelHandler()
    {
        storage = new PA4TreeMapStore();
        keys = new PrimaryKeyHandler();
    }
    
    public void addContact(String firstName, String lastName, String[] phoneNumbers,
            String[] emailAddresses)
    {
        Contact tempContact;
        tempContact = new Contact(keys.getNextAvailableKey(), firstName, lastName, phoneNumbers, emailAddresses);
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
    
    public String getFirstName(Integer treeLocation)
    {
        Contact temp = (Contact) storage.get(treeLocation);
        return(temp.getFirstName());
    }
    
    public String getLastName(Integer treeLocation)
    {
        Contact temp = (Contact) storage.get(treeLocation);
        return(temp.getLastName());
    }
    
    public void deletePhoneNumber(Integer treeLocation, int index)
    {
        Contact tempContact = (Contact) storage.get(treeLocation);
        System.out.println(tempContact);
        tempContact.getContactPhoneNumber().deletePhoneNumber(index);
    }
    
    public void deleteEmailAddress(Integer treeLocation, int index)
    {
        Object tempContact = storage.get(treeLocation);
        Contact xtempContact = (Contact) tempContact;
        xtempContact.getContactEmailAddress().deleteEmailAddress(index);
    }
    
    public String toString()
    {
        return(storage.toString());
    }
}
