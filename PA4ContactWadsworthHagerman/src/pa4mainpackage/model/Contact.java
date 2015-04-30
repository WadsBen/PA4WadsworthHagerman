package pa4mainpackage.model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Contact class stores all information relating to a specific contact including:
 * first name, last name, organization name, phone numbers, and email addresses.
 * 
 * Included also is a keyID which is determined automatically by the PrimaryKeyHandler class
 * and handled in the ModelHandler class.
 * 
 * Original file from: Lewis and Chase
 * Heavily edited by: Ben Wadsworth
 * 
 * @author Lewis and Chase
 * @author Ben Wadsworth
 * @version 4-30-2015
 */
public class Contact implements Comparable<Contact>, Serializable
{
    private String firstName, lastName, organization;
    private ContactPhoneNumber phoneNumbers;
    private ContactEmailAddress emailAddresses;
    private Integer keyID;

    /**
     * Sets up this contact with the specified information.
     *
     * @param keyID             an Integer representation of the key location of the contact
     * @param first             a string representation of a first name
     * @param last              a string representation of a last name
     * @param phoneNumbers      an object containing an ArrayList of phoneNumbers
     * @param emailAddresses    an object containing an ArrayList of emailAddresses
     */
    public Contact(Integer keyID, String first, String last, String organization, ArrayList<String> phoneNumbers,
            ArrayList<String> emailAddresses)
    {
        
        firstName = first;
        lastName = last;
        this.organization = organization;
        this.phoneNumbers = new ContactPhoneNumber(phoneNumbers);
        this.emailAddresses = new ContactEmailAddress(emailAddresses);
        this.keyID = keyID;
        
    }//End Contact constructor
    
    /**
     * Returns the first name of the contact.
     * 
     * @return the first name of the contact.
     */
    public String getFirstName()
    {
        return(firstName);
    }//End getFirstName method
    
    /**
     * Sets the first name of the contact.
     * 
     * @param firstName the String to set the firstName as
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }//End setFirstName method
    
    /**
     * Returns the last name of the contact.
     * 
     * @return the last name of the contact
     */
    public String getLastName()
    {
        return(lastName);
    }//End getLastName contact
    
    /**
     * Sets the last name of the contact
     * 
     * @param lastName the String to set the lastName as
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }//End setLastName contact
    
    /**
     * Returns the organization name of the contact.
     * 
     * @return the organization name of the contact
     */
    public String getOrganization()
    {
        return(organization);
    }//End getOrganization method
    
    /**
     * Sets the organization name of the contact.
     * 
     * @param organization String of organization name
     */
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }//End setOrganization method
    
    /**
     * Returns a ContactEmailAddress object stored in the contact.
     * 
     * @return a ContactEmailAddress object stored in the contact
     */
    public ContactEmailAddress getContactEmailAddress()
    {
        return(emailAddresses);
    }//End getContactEmailAddress method
    
    /**
     * Sets the ContactEmailAddress emailAddresses of the contact to the passed ArrayList object.
     * 
     * @param list ArrayList object to set phoneNumbers to.
     */
    public void setContactEmailAddresses(ArrayList<String> list)
    {
        emailAddresses.setEmailList(list);
    }//End setContactEmailaddresses method
    
    /**
     * Sets the ContactPhoneNumber phoneNumbers of the contact to the passed ArrayList object.
     * 
     * @param list ArrayList object to set phoneNumbers to.
     */
    public void setContactPhoneNumbers(ArrayList<String> list)
    {
        phoneNumbers.setPhoneNumbersList(list);
    }//End setContactPhoneNumbers method
    
    /**
     * Returns a ContactPhoneNumber object stored in the contact
     * 
     * @return a ContactPhoneNumber object stored in the contact
     */
    public ContactPhoneNumber getContactPhoneNumber()
    {
        return(phoneNumbers);
    }//End getContactPhoneNumber method

    /**
     * Returns the keyID value for the contact.
     * 
     * @return the Integer key
     */
    public Integer getKeyID()
    {
        return(keyID);
    }//End getKeyID method

    /**
     * Uses both last and first names to determine lexical ordering.
     *
     * @param other the contact to be compared to this contact
     * @return      the integer result of the comparison
     */
    @Override
    public int compareTo(Contact other)
    {
        
        int result;

        if (lastName.equals(other.lastName))
            result = firstName.compareTo(other.firstName);
        else
            result = lastName.compareTo(other.lastName);

        return result;
        
    }//End compareTo Override
    
    /**
     * Returns a description of this contact as a string.
     *
     * @return a string representation of this contact
     */
    @Override
    public String toString()
    {
        return(lastName + ", " + firstName + ". PHONE NUMBERS: " + phoneNumbers.toString() +
                "." + " EMAIL: " + emailAddresses.toString());
    }//End toString Override
    
}//End Contact class
