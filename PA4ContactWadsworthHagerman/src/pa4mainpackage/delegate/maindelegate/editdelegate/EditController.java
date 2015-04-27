package pa4mainpackage.delegate.maindelegate.editdelegate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import pa4mainpackage.model.Contact;
import pa4mainpackage.model.ModelHandler;



public class EditController
{
    
    private final EditView editView;
    private final ModelHandler modelHandler;
    private final Integer key;
    
    public EditController(EditView editView, ModelHandler modelHandler)
    {
        this.editView = editView;
        this.modelHandler = modelHandler;
        
        
        editView.setActionListeners(new EditViewListener());
        
        key = getKeyValue();
        
        Contact tempContact = (Contact) modelHandler.getTreeMapStorage().get(key);
        
        editView.populateEditWindow(tempContact.getFirstName(), tempContact.getLastName(),
                tempContact.getOrganization(), tempContact.getContactPhoneNumber().getPhoneList(),
                tempContact.getContactEmailAddress().getEmailList());
    }
    
    private Integer getKeyValue()
    {
        Integer tempKey = new Integer(-1);
        String tempKeyString;
        boolean isValid = false;
        
        while(isValid == false)
        {
            tempKeyString = editView.getEditKey();
            tempKey = Integer.parseInt(tempKeyString);
            if(modelHandler.getTreeMapStorage().containsKey(tempKey));
                isValid = true;
        }
        
        return(tempKey);
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
                tempContact.setContactPhoneNumbers(editView.getPhoneNumbers());
                tempContact.setContactEmailAddresses(editView.getEmailAddresses());
            }
            else if(actionEvent.equals("CLOSEEDITWINDOW"))
            {
                editView.close();
            }
        }
    }
}