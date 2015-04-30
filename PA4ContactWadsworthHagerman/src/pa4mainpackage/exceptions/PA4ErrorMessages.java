package pa4mainpackage.exceptions;

import javax.swing.JOptionPane;

/**
 * Provides static methods to be called in case of specific errors.
 * 
 * @author Ben Wadsworth
 * @version 4-30-2015
 */
public class PA4ErrorMessages 
{
    /**
     * Dialog informing user that the file cannot be read/open.
     */
    public static void cannotOpenFile()
    {
        JOptionPane.showMessageDialog(null, "Error: Cannot read/open file.", "Error", JOptionPane.ERROR_MESSAGE);
    }//End cannotOpenFile method
    
    /**
     * Dialog informing user that the file cannot be saved.
     */
    public static void cannotSaveFile()
    {
        JOptionPane.showMessageDialog(null, "Error: Cannot save file to that location.", "Error", JOptionPane.ERROR_MESSAGE);
    }//End cannotSaveFile method
    
    /**
     * Dialog informing user of invalid input. Any string can be used however certain Strings
     * will provide addition instructions on how to enter valid input.
     * 
     * @param invalidString 
     */
    public static void invalidInput(String invalidString)
    {
        JOptionPane.showMessageDialog(null, "The field: " + invalidString + 
                " has invalid input.\n\n" + inputInstructions(invalidString),
                "Error", JOptionPane.ERROR_MESSAGE);
    }//End invalidInput method
    
    /**
     * Dialog informing user that the contact list is full.
     */
    public static void contactListIsFull()
    {
        JOptionPane.showMessageDialog(null, "The contact list is full. Please delete a contact" + 
                " to add more.", "Error", JOptionPane.ERROR_MESSAGE);
    }//End contactListIsFull method
    
   /**
    * Dialog informing user of incorrect input, generic.
    */
    public static void incorrectInputMessageBox(String message)
    {

        JOptionPane.showMessageDialog(null,
        message, "Error!" , JOptionPane.ERROR_MESSAGE);
        
    }//End incorrectInputMessageBox method
    
    /**
     * Private method to add additional instructions depending on the passed string.
     * 
     * @param invalidString the String of which input box was incorrect.
     * @return String of instructions on how to fix the error
     */
    private static String inputInstructions(String invalidString)
    {
        switch(invalidString)
        {
            case("First Name"):
            {
                return("Valid characters are A-Z, a-z.");
            }
            case("Last Name"):
            {
                return("Valid characters are A-Z, a-z.");
            }
            case("Organization"):
            {
                return("Valid characters are A-Z, a-z.");
            }
            case("Phone Number"):
            {
                return("Valid input is 0-9 with [10-11] characters.");
            }
            case("Email Address"):
            {
                return("Valid input is A-Z, a-z, 0-9, Special characters: " +
                        "-+._\n It must be formated abcd@xyz.QQQ");
            }
            default:
            {
                return(null);
            }
        }
    }//End inputInsturctions private method
    
}//End PA4ErrorMessages class
