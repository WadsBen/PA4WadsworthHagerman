
package pa4mainpackage;

import pa4mainpackage.model.ModelHandler;

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
        
        //Controller start = new Controller();

        ModelHandler mh = new ModelHandler();
        
        mh.addContact("BEN", "WADSWORTH", "555-222-5623", "BWADSWOR@YOLO.COM");
        System.out.println(mh.toString());
        
        
    }
}
