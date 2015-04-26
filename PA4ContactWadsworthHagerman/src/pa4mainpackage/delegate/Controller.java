
package pa4mainpackage.delegate;

import pa4mainpackage.model.ModelHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  
 * @author John Thomas Hagerman
 * @author Benjamin Awesomesauce Wadsworth
 */
public class Controller 
{
    
    private final MainView mainView;
    private final ModelHandler modelHandler;
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
                mainView.openFile();
            }
            else if (actionCommand.equals( "SAVE"))
            {
                
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
                EditView editView = new EditView("Ben", "Wadsworth", "Student", null, null);
            //    EditController editController = new EditController(editView, modelHandler);
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
                    mainView.incorrectInputMessageBox();
                }
                catch (NumberFormatException z)
                {
                    System.out.println("Incorrect Key");
                    mainView.incorrectInputMessageBox();
                }
                
                
                      
            }
        }
 
    }
}
