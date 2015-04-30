package pa4mainpackage.delegate.maindelegate.editdelegate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import pa4mainpackage.delegate.RegexChecker;
import pa4mainpackage.delegate.maindelegate.FormattedOutput;
import pa4mainpackage.delegate.maindelegate.MainView;
import pa4mainpackage.exceptions.PA4ErrorMessages;
import pa4mainpackage.model.Contact;
import pa4mainpackage.model.ModelHandler;


/**
 * Controller class for the EditView class.
 * 
 * @author Ben Wadsworth
 * @version 4-30-2015
 */
public class EditController
{
    
    private final EditView editView;
    private final ModelHandler modelHandler;
    private final MainView mainView;
    private final Integer key;
    
    /**
     * EditController constructor
     * 
     * @param editView EditView to be used
     * @param mainView MainView to be used
     * @param modelHandler ModelHandler to be used
     */
    public EditController(EditView editView, MainView mainView, ModelHandler modelHandler)
    {
        this.editView = editView;
        this.modelHandler = modelHandler;
        this.mainView = mainView;
        
        editView.setActionListeners(new EditViewListener());
        
        key = getKeyValue();
        
        Contact tempContact = (Contact) modelHandler.getTreeMapStorage().get(key);
        
        editView.populateEditWindow(tempContact.getFirstName(), tempContact.getLastName(),
                tempContact.getOrganization(), tempContact.getContactPhoneNumber().getPhoneList(),
                tempContact.getContactEmailAddress().getEmailList());
    }//End EditController constructor
    
    /**
     * Checks for valid phone numbers in fields provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidPhoneNumbers()
    {
        ArrayList<String> phoneList = editView.getPhoneNumbers();
        
        for(String numbers : phoneList)
        {
            if(!RegexChecker.regexCheck(RegexChecker.RegexMethod.PHONE_NUMBER, numbers))
                return(false);    
        }
        
        return(true);
    }//End isValidPhoneNumbers method
    
    /**
     * Checks for valid email addresses in fields provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidEmailAddresses()
    {
        ArrayList<String> emailList = editView.getEmailAddresses();
        
        for(String emails : emailList)
        {
            if(!RegexChecker.regexCheck(RegexChecker.RegexMethod.EMAIL_ADDRESS, emails))
                return(false);    
        }
        
        return(true);
    }//End isValidEmailAddresses method
    
    /**
     * Checks for valid first name in field provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidFirstName()
    {
        return(RegexChecker.regexCheck(RegexChecker.RegexMethod.SIXTEEN_ALPHABET, editView.getFirstName()));
    }//End isValidFirstName method
    
    /**
     * Checks for valid last name in field provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidLastName()
    {
        return(RegexChecker.regexCheck(RegexChecker.RegexMethod.SIXTEEN_ALPHABET, editView.getLastName()));
    }//End isValidLastName method
    
    /**
     * Checks for valid organization name in field provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidOrganizationName()
    {
        return(RegexChecker.regexCheck(RegexChecker.RegexMethod.SIXTEEN_ALPHABET, editView.getOrgName()));
    }//End isValidOrganizationName
    
    /**
     * Checks for complete valid information in fields provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidInfo()
    {
        return(isValidFirstName() &&
                isValidLastName() &&
                isValidOrganizationName() &&
                isValidPhoneNumbers() &&
                isValidEmailAddresses());
    }//End isValidInfo method
    
    /**
     * Opens dialog asking for a key value to edit a contact.
     * 
     * @return Integer key value
     */
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
    }//End getKeyValue
    
    /**
     * Private inner class that sets up logic and listeners for the EditView class
    */
    private class EditViewListener implements ActionListener
    {
        /**
         * Defines logic for actions performed in EditView
         * @param e ActionEvent that took place
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String actionEvent = e.getActionCommand();
            
            if(actionEvent.equalsIgnoreCase("SUBMITEDIT"))
            {
                if(isValidInfo())
                {
                    Contact tempContact = modelHandler.getContact(key);
                    tempContact.setFirstName(editView.getFirstName());
                    tempContact.setLastName(editView.getLastName());
                    tempContact.setOrganization(editView.getOrgName());
                    tempContact.setContactPhoneNumbers(editView.getPhoneNumbers());
                    tempContact.setContactEmailAddresses(editView.getEmailAddresses());
                    
                    mainView.updateTextBox(new FormattedOutput().ascendingContactView(modelHandler.getTreeMapStorage()));
                    editView.close();
                }
                else
                {
                    if(!isValidFirstName())
                        PA4ErrorMessages.invalidInput("First Name");
                    else if(!isValidLastName())
                        PA4ErrorMessages.invalidInput("Last Name");
                    else if(!isValidOrganizationName())
                        PA4ErrorMessages.invalidInput("Organization");
                    else if(!isValidPhoneNumbers())
                        PA4ErrorMessages.invalidInput("Phone Number");
                    else if(!isValidEmailAddresses())
                        PA4ErrorMessages.invalidInput("Email Address");
                }
            }
            else if(actionEvent.equals("CLOSEEDITWINDOW"))
            {
                editView.close();
            }
            
        }//End actionPerformed Override
        
    }//End EditViewListener inner class
    
}//End EditController class