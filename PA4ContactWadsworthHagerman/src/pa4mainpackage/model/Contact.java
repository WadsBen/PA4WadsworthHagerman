package pa4mainpackage.model;

/**
 * Contact represents a phone contact.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class Contact implements Comparable<Contact>
{
    private String firstName, lastName;
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
    public Contact(Integer keyID, String first, String last, String[] phoneNumbers,
            String[] emailAddresses)
    {
        firstName = first;
        lastName = last;
        this.phoneNumbers = new ContactPhoneNumber(phoneNumbers);
        this.emailAddresses = new ContactEmailAddress(emailAddresses);
        this.keyID = keyID;
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
        //return lastName + ", " + firstName + "\t" + phone;
    }
    
    public String getFirstName()
    {
        return(firstName);
    }
    
    public String getLastName()
    {
        return(lastName);
    }
    
    public ContactEmailAddress getContactEmailAddress()
    {
        return(emailAddresses);
    }
    
    public ContactPhoneNumber getContactPhoneNumber()
    {
        return(phoneNumbers);
    }
    
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
}
