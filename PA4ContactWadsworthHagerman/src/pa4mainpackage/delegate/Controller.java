
package pa4mainpackage.delegate;

import pa4mainpackage.model.ModelHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *   Sets up the GUI
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
            else if (actionCommand.equals( "Save"))
            {
                //Save action
            }
            else if (actionCommand.equals( "Ascending"))
            {
                
            }
            else if (actionCommand.equals( "Descending"))
            {
                //Sort Action
            }
            else if (actionCommand.equals( "ADD"))
            {
               AddView x = new AddView();
                
            }
            else if (actionCommand.equals( "Delete"))
            {
                //
            }
            else if (actionCommand.equals( "Find Min"))
            {
                //
            }
            else if (actionCommand.equals( "Find Max"))
            {
                //
                
            }
            else if (actionCommand.equals( "About"))
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
