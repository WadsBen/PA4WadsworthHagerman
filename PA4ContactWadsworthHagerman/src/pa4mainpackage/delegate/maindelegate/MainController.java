
package pa4mainpackage.delegate.maindelegate;

import pa4mainpackage.delegate.maindelegate.MainView;
import pa4mainpackage.model.ModelHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import pa4mainpackage.delegate.adddelegate.AddController;
import pa4mainpackage.delegate.adddelegate.AddView;
import pa4mainpackage.delegate.maindelegate.editdelegate.EditController;
import pa4mainpackage.delegate.maindelegate.editdelegate.EditView;
import pa4mainpackage.delegate.fileio.FileIO;
import pa4mainpackage.exceptions.PA4ErrorMessages;

/**
 *  
 * @author John Thomas Hagerman
 * @author Benjamin Awesomesauce Wadsworth
 */
public class MainController 
{
    
    private final MainView mainView;
    private  ModelHandler modelHandler;
    private boolean inOrder = true;
    private FormattedOutput formatted;
    
    
    public MainController(MainView mainView, ModelHandler modelHandler)
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
                finally
                {
                    FormattedOutput fo = new FormattedOutput();
                    
                    if(inOrder == true)
                        mainView.updateTextBox(fo.ascendingContactView(modelHandler.getTreeMapStorage()));
                    else
                        mainView.updateTextBox(fo.descendingContactView(modelHandler.getTreeMapStorage()));
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
                FormattedOutput fo = new FormattedOutput();
                mainView.updateTextBox(fo.ascendingContactView(modelHandler.getTreeMapStorage()));
                inOrder = true;
            }  
            else if (actionCommand.equals( "DESCENDING"))
            {
                FormattedOutput fo = new FormattedOutput();
                mainView.updateTextBox(fo.descendingContactView(modelHandler.getTreeMapStorage()));
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
                mainView.showDeleteWindow();

            }
                       else if (actionCommand.equals( "DELETEMIN"))
            {
                if(modelHandler.isStorageEmpty() == false)
                    mainView.reassuranceMinWindow();
            }    
            else if (actionCommand.equals("DELETEMINBTN"))
            {
                modelHandler.deleteMin();
                mainView.endMinMAx();
                
                FormattedOutput fo = new FormattedOutput();
                    
                    if(inOrder == true)
                        mainView.updateTextBox(fo.ascendingContactView(modelHandler.getTreeMapStorage()));
                    else
                        mainView.updateTextBox(fo.descendingContactView(modelHandler.getTreeMapStorage()));
                
            }    
            else if (actionCommand.equals("CANCELDELETEMINMAX"))
            {
                mainView.endMinMAx();
            }

            else if (actionCommand.equals( "DELETEMAX"))
            {
                 if(modelHandler.isStorageEmpty() == false)
                    mainView.reassuranceMaxWindow();
            }
            
             else if (actionCommand.equals("DELETEMAXBTN"))
            {
                modelHandler.deleteMax();
                mainView.endMinMAx();
                
                FormattedOutput fo = new FormattedOutput();
                    
                    if(inOrder == true)
                        mainView.updateTextBox(fo.ascendingContactView(modelHandler.getTreeMapStorage()));
                    else
                        mainView.updateTextBox(fo.descendingContactView(modelHandler.getTreeMapStorage()));
                
            }
            
            
            else if (actionCommand.equals( "FINDMAX"))
            {
                mainView.findMaxWindow(modelHandler.getLast());
            }
         
            else if (actionCommand.equals( "FINDMIN"))
            {
                mainView.findMinWindow(modelHandler.getMin());
            }
            
            else if (actionCommand.equals( "ABOUT"))
            {
                mainView.showAboutWindow();
            }
            
            else if(actionCommand.equals( "CLOSEABOUTWINDOW"))
            {
                mainView.closeAbout();
            }
            
            else if(actionCommand.equals("CLOSEDELETEBOX"))
            {
                mainView.closeDeleteBox();
            }
            
            else if(actionCommand.equals("SEARCHBYKEY"))
            {
                mainView.searchByKeyWindow();
            }
            else if(actionCommand.equals("SEARCHBYKEYBTN"))
            {
                Integer x; 
                FormattedOutput fo = new FormattedOutput();
                
                try 
                {
                    x = Integer.parseInt(mainView.getSearchKey());
                     
                    if(modelHandler.getContact(x) != null)
                    {
                       // modelHandler.deleteContact(x);
                    
                    
                        if(inOrder == true)
                        {
                            mainView.updateTextBox(fo.ascendingContactView(modelHandler.getTreeMapStorage()));
                            mainView.closeSearchBox();
                        }
                        else
                        {
                            mainView.updateTextBox(fo.descendingContactView(modelHandler.getTreeMapStorage()));
                            mainView.closeSearchBox();
                        }
                    }
                    else
                        PA4ErrorMessages.incorrectInputMessageBox("Invalid Integer");
                  
                }
                catch (NumberFormatException z)
                {
                    System.out.println("Incorrect Key");
                    PA4ErrorMessages.incorrectInputMessageBox("Key Must be an Integer");
                }           
            
            }
            
            else if(actionCommand.equals("CLOSEDSEARCHBOX"))
            {
                mainView.closeSearchBox();
            }
            
            else if(actionCommand.equals("DELETECONTACT"))
            {
                int x;
                FormattedOutput fo = new FormattedOutput();
                
                try 
                {
                    x = Integer.parseInt(mainView.getDeleteString());
                     
                    if(modelHandler.getContact(x) != null)
                    {
                        modelHandler.deleteContact(x);
                    
                    
                        if(inOrder == true)
                        {
                            mainView.updateTextBox(fo.ascendingContactView(modelHandler.getTreeMapStorage()));
                            mainView.closeDeleteBox();
                        }
                        else
                        {
                            mainView.updateTextBox(fo.descendingContactView(modelHandler.getTreeMapStorage()));
                            mainView.closeDeleteBox();
                        }
                    }
                    else
                        PA4ErrorMessages.incorrectInputMessageBox("Invalid Integer");
                  
                }
                catch (NumberFormatException z)
                {
                    System.out.println("Incorrect Key");
                    PA4ErrorMessages.incorrectInputMessageBox("Key Must be an Integer");
                }           
            }
        }
    }
}
