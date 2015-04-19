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

    /**
     * Sets up this contact with the specified information.
     *
     * @param first     a string representation of a first name
     * @param last      a string representation of a last name
     * @param telephone a string representation of a phone number
     */
    public Contact(String first, String last, String phoneNumbers,
            String emailAddresses)
    {
        firstName = first;
        lastName = last;
        this.phoneNumbers = new ContactPhoneNumber();
        this.phoneNumbers.add(phoneNumbers);
        this.emailAddresses = new ContactEmailAddress();
        this.emailAddresses.add(emailAddresses);
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
