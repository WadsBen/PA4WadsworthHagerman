
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
                
            }
            else if (actionCommand.equals( "DESCENDING"))
            {
                
            }
            else if (actionCommand.equals( "ADD"))
            {
                AddView addView = new AddView();
                AddController addController = new AddController(addView, modelHandler);
            }
            else if(actionCommand.equalsIgnoreCase("EDITENTRY"))
            {
                EditView editView = new EditView("Ben", "Wadsworth", "Student", null, null);
                EditController editController = new EditController(editView, modelHandler);
            }
            else if (actionCommand.equals( "DELETE"))
            {
                //
            }
            else if (actionCommand.equals( "DELETEMIN"))
            {
                //
            }
            else if (actionCommand.equals( "DELETEMAX"))
            {
                
            }
            else if (actionCommand.equals( "FINDMAX"))
            {
                ContactTable table = new ContactTable(modelHandler);
                mainView.updateTableArea(table.formattedJTable());
            }
            else if (actionCommand.equals( "FINDMIN"))
            {
                
            }
            else if (actionCommand.equals( "ABOUT"))
            {
                mainView.showAbout();
            }
            else if(actionCommand.equals( "CLOSEABOUTWINDOW"))
            {
                mainView.closeAbout();
            }
        }
 
    }
}
