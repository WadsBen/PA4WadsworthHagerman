
package pa4mainpackage.exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben Wadsworth
 */
public class PA4ErrorMessages 
{
    public static void cannotOpenFile()
    {
        JOptionPane.showMessageDialog(null, "Error: Cannot read/open file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void cannotSaveFile()
    {
        JOptionPane.showMessageDialog(null, "Error: Cannot save file to that location.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void invalidInput(String invalidString)
    {
        JOptionPane.showMessageDialog(null, "The field: " + invalidString + 
                " has invalid input.\n\n" + inputInstructions(invalidString),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
   /**
    * Error Message Box
    */
    public static void incorrectInputMessageBox(String message)
    {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
        message, "Error!" , JOptionPane.ERROR_MESSAGE);
        
    }//End of incorrectInputMessageBox()
    
    
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
    }
}
