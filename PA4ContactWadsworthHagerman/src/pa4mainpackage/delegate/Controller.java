
package pa4mainpackage.delegate;

import pa4mainpackage.model.ModelHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import pa4mainpackage.delegate.fileio.FileIO;
import pa4mainpackage.delegate.fileio.PA4ErrorMessages;

/**
 *  
 * @author John Thomas Hagerman
 * @author Benjamin Awesomesauce Wadsworth
 */
public class Controller 
{
    
    private final MainView mainView;
    private  ModelHandler modelHandler;
    private boolean inOrder = true;
    
    
    public Controller(MainView mainView, ModelHandler modelHandler)
    {
        this.mainView = mainView;
        this.modelHandler = modelHandler;
        
        mainView.setActionListeners(new AllWidgetListener());
    }
    
   
    
    private class AllWidgetListener implements ActionListener
    {
         @Override
        public void actionPerformed( ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            
            if (actionCommand.equals( "QUIT" ))
            {
                System.exit( 0 );
            }
            else if (actionCommand.equals("OPEN"))
            {
                File tempFile = mainView.openFile();
                
                try
                {
                    modelHandler = FileIO.openFile(tempFile);
                }
                catch(Exception ex)
                {
                    PA4ErrorMessages.cannotOpenFile();
                }
            }
            else if (actionCommand.equals( "SAVE"))
            {
                // Write to disk with FileOutputStream
                File tempFile;
                try 
                {
                    tempFile = mainView.saveFileName();
                    FileIO.saveFile(tempFile, modelHandler);
                } 
                catch (IOException ex) 
                {
                    PA4ErrorMessages.cannotSaveFile();
                }
            }
            else if (actionCommand.equals( "ASCENDING"))
            {
                mainView.updateTextBox(modelHandler.toString());
                inOrder = true;
            }
            else if (actionCommand.equals( "DESCENDING"))
            {
                mainView.updateTextBox(modelHandler.reverseToString());
                inOrder = false;
            }
            else if (actionCommand.equals( "ADD"))
            {
                AddView addView = new AddView();
                AddController addController = new AddController(addView, modelHandler);
            }
            else if(actionCommand.equalsIgnoreCase("EDITENTRY"))
            {
                EditView editView = new EditView();
                EditController editController = new EditController(editView, modelHandler);
            }
            else if (actionCommand.equals( "DELETE"))
            {
                mainView.showDeleteBox();

            }
            else if (actionCommand.equals( "DELETEMIN"))
            {
                 modelHandler.deleteMin();
                 if(inOrder == true)
                     mainView.updateTextBox(modelHandler.toString());
                 else
                    mainView.updateTextBox(modelHandler.reverseToString());
            }
            else if (actionCommand.equals( "DELETEMAX"))
            {
                 modelHandler.deleteMax();
                 if(inOrder == true)
                     mainView.updateTextBox(modelHandler.toString());
                 else
                    mainView.updateTextBox(modelHandler.reverseToString());

            
            }
            else if (actionCommand.equals( "FINDMAX"))
            {
                mainView.findMax(modelHandler.getLast());
            }
            else if (actionCommand.equals( "FINDMIN"))
            {
                mainView.findMin(modelHandler.getMin());
            }
            else if (actionCommand.equals( "ABOUT"))
            {
                mainView.showAbout();
            }
            else if(actionCommand.equals( "CLOSEABOUTWINDOW"))
            {
                mainView.closeAbout();
            }
            else if(actionCommand.equals("CLOSEDELETEBOX"))
            {
                mainView.closeDeleteBox();
            }
            else if(actionCommand.equals("DELETECONTACT"))
            {
                int x;
                
                try 
                {
                    x = Integer.parseInt(mainView.getDeleteString());
                     
                    if(modelHandler.getContact(x) != null)
                    {
                        modelHandler.deleteContact(x);
                    
                    
                        if(inOrder == true)
                        {
                            mainView.updateTextBox(modelHandler.toString());
                            mainView.closeDeleteBox();
                        }
                        else
                        {
                            mainView.updateTextBox(modelHandler.reverseToString());
                            mainView.closeDeleteBox();
                        }
                    }
                    else
                        mainView.incorrectInputMessageBox("Invalid Integer");
                  
                }
                catch (NumberFormatException z)
                {
                    System.out.println("Incorrect Key");
                    mainView.incorrectInputMessageBox("Key Must be an Integer");
                }
                
                
                      
            }
        }
 
    }
}
