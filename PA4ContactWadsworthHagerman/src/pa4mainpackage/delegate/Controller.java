
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
    private final AddView addView;
    
    
    public Controller(MainView mainView, ModelHandler modelHandler, AddView addView)
    {
        this.mainView = mainView;
        this.modelHandler = modelHandler;
        this.addView = addView;
        
        mainView.setActionListeners(new AllWidgetListener());
        addView.setActionListeners(new AllWidgetListener());
        
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
                addView.displayAddEntry();
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
            else if (actionCommand.equals( "CLOSEADDWINDOW"))
            {
                addView.closeAdd();
            }
            else if (actionCommand.equals( "CLOSEERRORTWINDOW"))
            {
            
                addView.closeErrorFrame();
            }
            else if(actionCommand.equals( "SUBMITADD"))
            {
                if (addView.correctInput() == true)
                {
                    modelHandler.addContact(addView.getFirstName(), addView.getLastName()
                        , addView.getOrgName(), new String[]{"419-765-5555", "320-235-5668"}, 
                        new String[]{"bwadswor@heidelberg.edu", "wadsworth.benjamin.m@gmail.com"});

               
                    System.out.println(addView.getFirstName());
                    System.out.println(modelHandler.toString());
                    addView.closeAdd();
                    mainView.updateTextArea(modelHandler.toString());
                    
                    //UPDATE JTEXT AREA
                } 
                else
                {
                    addView.displayErrorFrame();
                }
                
            }
            
          
        
        }
 
    }
}
