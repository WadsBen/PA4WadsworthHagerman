package pa4mainpackage;

import pa4mainpackage.delegate.maindelegate.MainController;
import pa4mainpackage.delegate.maindelegate.MainView;
import pa4mainpackage.model.ModelHandler;

/**
 * Main entry point for PA4Contact
 * 
 * @author Ben Wadsworth
 * @author John Hagerman
 * @version 4-30-2015
 */
public class PA4WadsworthHagermanMain 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
       // MainController ass = new MainController();

        ModelHandler modelHandler = new ModelHandler();
        MainView mainView = new MainView();
        
        MainController start = new MainController(mainView, modelHandler);
        
    }//End main method
    
}//End PA4WadsworthHagermanMain
