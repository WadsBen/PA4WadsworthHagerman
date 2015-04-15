
package pa4mainpackage;

import pa4mainpackage.delegate.Controller;
import pa4mainpackage.model.Contact;
import pa4mainpackage.model.PA4TreeMapStore;

/**
 *
 * @author Ben Wadsworth
 */
public class PA4WadsworthHagermanMain 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Controller start = new Controller();
        
        PA4TreeMapStore test = new PA4TreeMapStore();
        
        test.put(new Integer(1001), new Contact("Ben", "Wadsworth", "419-765-0435"));
        
    }
    
}
