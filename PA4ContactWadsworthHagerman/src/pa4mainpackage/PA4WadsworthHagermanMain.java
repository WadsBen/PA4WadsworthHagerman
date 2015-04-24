package pa4mainpackage;

import pa4mainpackage.delegate.AddView;
import pa4mainpackage.delegate.Controller;
import pa4mainpackage.delegate.MainView;
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
        
       // Controller ass = new Controller();

        ModelHandler mh = new ModelHandler();
        MainView fuck = new MainView();
        
        Controller bitch = new Controller(fuck, mh);
        
    }
}
