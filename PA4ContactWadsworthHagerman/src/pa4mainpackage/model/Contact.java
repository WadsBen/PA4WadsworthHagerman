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
    private final ContactPhoneNumber phoneQueue = new ContactPhoneNumber();

    /**
     * Sets up this contact with the specified information.
     *
     * @param first     a string representation of a first name
     * @param last      a string representation of a last name
     * @param telephone a string representation of a phone number
     */
    public Contact(String first, String last, String telephone)
    {
        firstName = first;
        lastName = last;
        phoneQueue.addPhoneNumber(telephone);
    }

    /**
     * Returns a description of this contact as a string..
     *
     * @return a string representation of this contact
     */
    public String toString()
    {
        return null;
        //return lastName + ", " + firstName + "\t" + phone;
    }
    
    public boolean containsPhoneNumber(String phoneNumber)
    {
        return phoneQueue.contains(phoneNumber);
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
