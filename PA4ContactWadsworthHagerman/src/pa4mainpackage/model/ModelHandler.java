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
    
    public void addContact(String firstName, String lastName,String organization, String[] phoneNumbers,
            String[] emailAddresses)
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
    
    public String formattedContact(Integer treeLocation)
    {
        String returnString = "";
        
        returnString = "ID   -   Last Name   -   First Name   -   Organization   -   " +
                "Phone Numbers   -   Email Addresses\n" + 
                "====================================================================" +
                "============================\n" +
                treeLocation + "     " + getLastName(treeLocation) + String.format("%" + (16 - getLastName(treeLocation).length()) + "s", " ") + 
                getFirstName(treeLocation) + String.format("%" + (17 - getFirstName(treeLocation).length()) + "s", " ") + 
                getOrganization(treeLocation) + String.format("%" + (19 - getOrganization(treeLocation).length()) + "s", " ");
        
        return(returnString);
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
    
    public String getOrganization(Integer treeLocation)
    {
        Contact temp = (Contact) storage.get(treeLocation);
        return(temp.getOrganization());
    }
    
    public void deletePhoneNumber(Integer treeLocation, int index)
    {
        Contact tempContact = (Contact) storage.get(treeLocation);
        tempContact.getContactPhoneNumber().deletePhoneNumber(index);
    }
    
    public void deleteEmailAddress(Integer treeLocation, int index)
    {
        Contact tempContact = (Contact) storage.get(treeLocation);
        tempContact.getContactEmailAddress().deleteEmailAddress(index);
    }
    
    public void addPhoneNumber(Integer treeLocation, String phoneNumber)
    {
        Contact tempContact = (Contact) storage.get(treeLocation);
        tempContact.getContactPhoneNumber().addPhoneNumber(phoneNumber);
    }
    
    public void addEmailAddress(Integer treeLocation, String emailAddress)
    {
        Contact tempContact = (Contact) storage.get(treeLocation);
        tempContact.getContactEmailAddress().addEmailAddress(emailAddress);
    }
    
    public String toString()
    {
        return(storage.toString());
    }
}
