package pa4mainpackage.delegate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pa4mainpackage.model.Contact;
import pa4mainpackage.model.ModelHandler;



public class EditController
{
    
    private final EditView editView;
    private final ModelHandler modelHandler;
    private final Integer key;
    
    public EditController(EditView editView, ModelHandler modelHandler, Integer key)
    {
        this.editView = editView;
        this.modelHandler = modelHandler;
        this.key = key;
        
        editView.setActionListeners(new EditViewListener());
    }
    
    private class EditViewListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String actionEvent = e.getActionCommand();
            
            if(actionEvent.equalsIgnoreCase("SUBMITEDIT"))
            {
                Contact tempContact = modelHandler.getContact(key);
                tempContact.setFirstName(editView.getFirstName());
                tempContact.setLastName(editView.getLastName());
                tempContact.setOrganization(editView.getOrganizationName());
            }
        }
    }
}