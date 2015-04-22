
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
        AddView shit = new AddView();
        
        Controller bitch = new Controller(fuck, mh, shit);
        
     //   AddView fatass = new AddView();
        
        //mh.addContact("BEN", "WADSWORTH", new String[]{"419-765-5555", "320-235-5668"}, new String[]{"bwadswor@heidelberg.edu", "wadsworth.benjamin.m@gmail.com"});
        //mh.addContact("BEN", "WADSWORTH", new String[]{"419-765-5555", "320-235-5668"}, new String[]{"bwadswor@heidelberg.edu", "wadsworth.benjamin.m@gmail.com"});
        System.out.println(mh.toString());
        
        
    }
}
