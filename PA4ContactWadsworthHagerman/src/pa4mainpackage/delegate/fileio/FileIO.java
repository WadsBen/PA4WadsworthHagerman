/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import pa4mainpackage.delegate.maindelegate.MainController;
import pa4mainpackage.model.ModelHandler;

/**
 *
 * @author Ben Wadsworth
 */
public class FileIO 
{
    
    public static ModelHandler openFile(File fileToOpen) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        
        String fileName = fileToOpen.getName();
        ModelHandler mhReturn = null;

        // Read from disk using FileInputStream
        FileInputStream f_in = null;
        ObjectInputStream obj_in = null;
        
        
        f_in = new FileInputStream(fileName);
        obj_in = new ObjectInputStream(f_in);
        mhReturn = (ModelHandler) obj_in.readObject();
        obj_in.close();
        
        
        
        return(mhReturn);
    }
    
    public static void saveFile(File fileToSave, ModelHandler mhToSave)
    {
        String fileName = fileToSave.getName();
        
        FileOutputStream f_out = null;
        ObjectOutputStream obj_out = null;
        
        try
        {
            f_out = new FileOutputStream(fileName);
            obj_out = new ObjectOutputStream(f_out);
            obj_out.writeObject(mhToSave);
            obj_out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
