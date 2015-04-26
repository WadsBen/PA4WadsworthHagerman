package pa4mainpackage.model;

import java.util.ArrayList;

/**
 * Contact represents a phone contact.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class Contact implements Comparable<Contact>
{
    private String firstName, lastName, organization;
    private ContactPhoneNumber phoneNumbers;
    private ContactEmailAddress emailAddresses;
    private Integer keyID;

    /**
     * Sets up this contact with the specified information.
     *
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
    }
    
    /**
     *
     * @return
     */
    public String getFirstName()
    {
        return(firstName);
    }
    
    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     *
     * @return
     */
    public String getLastName()
    {
        return(lastName);
    }
    
    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    /**
     *
     * @return
     */
    public String getOrganization()
    {
        return(organization);
    }
    
    /**
     *
     * @param organization
     */
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }    
    
    /**
     *
     * @return
     */
    public ContactEmailAddress getContactEmailAddress()
    {
        return(emailAddresses);
    }
    
    /**
     *
     * @param emailAddress
     */
    public void addEmailAddress(String emailAddress)
    {
        if(emailAddresses.size() < 6)
            emailAddresses.addEmailAddress(emailAddress);
    }
    
    /**
     *
     * @param index
     */
    public void deleteEmailAddress(int index)
    {
        emailAddresses.deleteEmailAddress(index);
    }
    
    /**
     *
     * @return
     */
    public ContactPhoneNumber getContactPhoneNumber()
    {
        return(phoneNumbers);
    }
    
    /**
     *
     * @param phoneNumber
     */
    public void addPhoneNumber(String phoneNumber)
    {
        if(phoneNumbers.size() < 6)
            phoneNumbers.addPhoneNumber(phoneNumber);
    } 
    
    /**
     *
     * @param index
     */
    public void deletePhoneNumber(int index)
    {
        phoneNumbers.deletePhoneNumber(index);
    }

    /**
     *
     * @return
     */
    public Integer getKeyID()
    {
        return(keyID);
    }

    /**
     * Uses both last and first names to determine lexical ordering.
     *
     * @param other the contact to be compared to this contact
     * @return      the integer result of the comparison
     */
    public int compareTo(Contact other)
    {
        int result;

        if (lastName.equals(other.lastName))
            result = firstName.compareTo(other.firstName);
        else
            result = lastName.compareTo(other.lastName);

        return result;
    }
    
    /**
     * Returns a description of this contact as a string..
     *
     * @return a string representation of this contact
     */
    public String toString()
    {
        return(lastName + ", " + firstName + ". PHONE NUMBERS: " + phoneNumbers.toString() +
                "." + " EMAIL: " + emailAddresses.toString());
    }
}
