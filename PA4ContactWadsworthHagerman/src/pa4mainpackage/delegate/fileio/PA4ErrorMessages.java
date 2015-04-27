/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate.fileio;

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
}
