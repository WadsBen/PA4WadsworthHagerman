package pa4mainpackage;

import pa4mainpackage.delegate.maindelegate.MainController;
import pa4mainpackage.delegate.maindelegate.MainView;
import pa4mainpackage.model.ModelHandler;

/**
 *
 * @author Ben Wadsworth
 * 
 */
public class PA4WadsworthHagermanMain 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
       // MainController ass = new MainController();

        ModelHandler mh = new ModelHandler();
        MainView fuck = new MainView();
        
        MainController bitch = new MainController(fuck, mh);
        
    }
}
