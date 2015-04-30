package pa4mainpackage.delegate.adddelegate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import pa4mainpackage.delegate.RegexChecker;
import pa4mainpackage.delegate.RegexChecker.RegexMethod;
import pa4mainpackage.delegate.maindelegate.FormattedOutput;
import pa4mainpackage.delegate.maindelegate.MainView;
import pa4mainpackage.exceptions.PA4ErrorMessages;
import pa4mainpackage.model.ModelHandler;

/**
 * Controller for the AddView class.
 * 
 * @author Ben Wadsworth
 * @version 4-30-2015
 */
public class AddController 
{
    private final AddView addView;
    private final ModelHandler modelHandler;
    private final MainView mainView;
    
    /**
     * AddController constructor.
     * 
     * @param addView AddView to be used
     * @param mainView MainView to be used
     * @param modelHandler ModelHandler to be used
     */
    public AddController(AddView addView, MainView mainView, ModelHandler modelHandler)
    {
        this.addView = addView;
        this.modelHandler = modelHandler;
        this.mainView = mainView;
        
        addView.setActionListeners(new AddViewListener());
    }//End AddController constructor
    
    /**
     * Checks for valid phone numbers in fields provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidPhoneNumbers()
    {
        ArrayList<String> phoneList = addView.getPhoneNumbers();
        
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
        ArrayList<String> emailList = addView.getEmailAddresses();
        
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
        return(RegexChecker.regexCheck(RegexChecker.RegexMethod.SIXTEEN_ALPHABET, addView.getFirstName()));
    }//End isValidFirstName method
    
    /**
     * Checks for valid last name in field provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidLastName()
    {
        return(RegexChecker.regexCheck(RegexChecker.RegexMethod.SIXTEEN_ALPHABET, addView.getLastName()));
    }//End isValidLastName method
    
    /**
     * Checks for valid organization name in field provided.
     * 
     * @return boolean of if valid input
     */
    private boolean isValidOrganizationName()
    {
        return(RegexChecker.regexCheck(RegexChecker.RegexMethod.SIXTEEN_ALPHABET, addView.getOrgName()));
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
     * Private inner class that sets up logic and listeners for the AddView class
    */
    private class AddViewListener implements ActionListener
    {
        /**
         * Defines logic for actions performed in AddView
         * @param e ActionEvent that took place
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            
            if (actionCommand.equals( "CLOSEADDWINDOW"))
            {
                addView.closeAdd();
            }
            else if (actionCommand.equals( "CLOSEERRORTWINDOW"))
            {
                addView.closeErrorFrame();
            }
            else if(actionCommand.equals( "SUBMITADD"))
            {
                if(isValidInfo())
                {
                    if(!modelHandler.isAvailableKey())
                    {
                        modelHandler.addContact(addView.getFirstName(),
                            addView.getLastName(), addView.getOrgName(),
                            addView.getPhoneNumbers(), addView.getEmailAddresses());
                        
                        mainView.updateTextBox(new FormattedOutput().ascendingContactView(modelHandler.getTreeMapStorage()));
                        addView.closeAdd();
                    }
                    else if(modelHandler.isAvailableKey())
                    {
                        PA4ErrorMessages.contactListIsFull();
                        addView.closeAdd();
                    }
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
        }//End actiionPerformed method
        
    }//End ActionListener inner class
    
}//End AddController class

