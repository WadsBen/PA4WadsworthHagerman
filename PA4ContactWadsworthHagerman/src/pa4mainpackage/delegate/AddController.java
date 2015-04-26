/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import pa4mainpackage.delegate.RegexChecker.RegexMethod;
import pa4mainpackage.model.ModelHandler;

/**
 *
 * @author Ben Wadsworth
 */
public class AddController 
{
    private final AddView addView;
    private final ModelHandler modelHandler;
    
    public AddController(AddView addView, ModelHandler modelHandler)
    {
        this.addView = addView;
        this.modelHandler = modelHandler;
        
        addView.setActionListeners(new AddViewListener());
    }
    
    private boolean isValidPhoneNumbers()
    {
        ArrayList<String> phoneList = addView.getPhoneNumbers();
        
        for(String numbers : phoneList)
        {
            if(!RegexChecker.regexCheck(RegexMethod.PHONE_NUMBER, numbers))
                return(false);    
        }
        
        return(true);
    }
    
    private boolean isValidEmailAddresses()
    {
        ArrayList<String> emailList = addView.getEmailAddresses();
        
        for(String emails : emailList)
        {
            if(!RegexChecker.regexCheck(RegexMethod.EMAIL_ADDRESS, emails))
                return(false);    
        }
        
        return(true);
    }
    
    private boolean isValidFirstName()
    {
        return(RegexChecker.regexCheck(RegexMethod.SIXTEEN_ALPHABET, addView.getFirstName()));
    }
    
    private boolean isValidLastName()
    {
        return(RegexChecker.regexCheck(RegexMethod.SIXTEEN_ALPHABET, addView.getLastName()));
    }
    
    private boolean isValidOrganizationName()
    {
        return(RegexChecker.regexCheck(RegexMethod.SIXTEEN_ALPHABET, addView.getOrgName()));
    }
    
    private boolean isValidInfo()
    {
        return(isValidFirstName() &&
                isValidLastName() &&
                isValidOrganizationName() &&
                isValidPhoneNumbers() &&
                isValidEmailAddresses());
    }
    
    private class AddViewListener implements ActionListener
    {
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
                    System.out.println("GOOD INFO");
                    modelHandler.addContact(addView.getFirstName(),
                            addView.getLastName(), addView.getOrgName(),
                            addView.getPhoneNumbers(), addView.getEmailAddresses());
                }
                else
                    System.out.println("BAD INFO");
            }
        }
    }
}

