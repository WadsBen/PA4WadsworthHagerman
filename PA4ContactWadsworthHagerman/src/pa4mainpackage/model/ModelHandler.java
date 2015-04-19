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
    
    public void addContact(String firstName, String lastName, String phoneNumbers,
            String emailAddresses)
    {
        Contact tempContact;
        tempContact = new Contact(firstName, lastName, phoneNumbers, emailAddresses);
        storage.put(keys.getNextAvailableKey(), tempContact);
    }
    
    public String toString()
    {
        return(storage.toString());
    }
}
