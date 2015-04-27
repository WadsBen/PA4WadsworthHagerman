/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.exceptions;

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
