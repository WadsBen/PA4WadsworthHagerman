
package pa4mainpackage.delegate.adddelegate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * GUI interface for adding new contacts
 * 
 * @author John Hagerman
 */
public final class AddView
{
    private JFrame          addFrame, errorFrame;
    private JTextField      lastNameField, nameField, orgField,email1,email2,email3,
                            email4,email5, email6, phone1, phone2, phone3, phone4, phone5, phone6;
    private JPanel          topPanel, bottomPanel, bottomLeftPanel, 
                            bigPanel, bottomRightPanel, veryBottom;
    private JLabel          fNLabel, lNLabel, orgLabel, emailLabel, phoneLabel,error1;
    private JButton         submitBTN, cancelBTN, closeErrorButton;
    
    /*
    * Invokes the displayAddEntry() method creating GUI for adding new contacts
    */
    public  AddView()
    {
       displayAddEntry();
       
    }//End of Constructor
    
    
    /**
     * Creates and displays GUI for adding new contacts
     */
    public void displayAddEntry()
    {
        addFrame = new JFrame();
        addFrame.setTitle("Add Entry");
        addFrame.setLocationRelativeTo(null);
        addFrame.setSize(500,400);
        addFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        addFrame.setResizable(false);
       
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel,BoxLayout.PAGE_AXIS));
        topPanel = new JPanel(new GridLayout(2,3,5,5));
        bottomPanel = new JPanel(new GridLayout(1,2,10,10));
        
        bottomLeftPanel = new JPanel(new GridLayout(7,1,0,0));
        bottomRightPanel = new JPanel(new GridLayout(7,1,0,0));
        
        topPanel.setMaximumSize(new Dimension(500,80));
        topPanel.setPreferredSize(new Dimension(500,80));
        bottomPanel.setMaximumSize(new Dimension(500,280));
        bottomPanel.setPreferredSize(new Dimension(500,280));
        
        fNLabel  = new JLabel("First Name");
        fNLabel.setHorizontalAlignment(JLabel.CENTER);
        lNLabel  = new JLabel("Last Name");
        lNLabel.setHorizontalAlignment(JLabel.CENTER);
        orgLabel = new JLabel("Organization");
        orgLabel.setHorizontalAlignment(JLabel.CENTER);
        phoneLabel = new JLabel("Phone Number(s) ");
        phoneLabel.setHorizontalAlignment(JLabel.CENTER);
        emailLabel = new JLabel("Email Address(es)");
        emailLabel.setHorizontalAlignment(JLabel.CENTER);
        
        nameField = new JTextField();
        lastNameField = new JTextField();
        orgField = new JTextField();
        phone1 = new JTextField();
        phone2 = new JTextField();
        phone3 = new JTextField();
        phone4 = new JTextField();
        phone5 = new JTextField();
        phone6 = new JTextField();
        email1 = new JTextField();
        email2 = new JTextField();
        email3 = new JTextField();
        email4 = new JTextField();
        email5 = new JTextField();
        email6 = new JTextField();
        
        topPanel.add(fNLabel);
        topPanel.add(lNLabel);
        topPanel.add(orgLabel);
        topPanel.add(nameField);
        topPanel.add(lastNameField);
        topPanel.add(orgField);
      
        bottomLeftPanel.add(phoneLabel);
        bottomLeftPanel.add(phone1);
        bottomLeftPanel.add(phone2);
        bottomLeftPanel.add(phone3);
        bottomLeftPanel.add(phone4);
        bottomLeftPanel.add(phone5);
        bottomLeftPanel.add(phone6);
        bottomRightPanel.add(emailLabel);
        bottomRightPanel.add(email1);
        bottomRightPanel.add(email2);
        bottomRightPanel.add(email3);
        bottomRightPanel.add(email4);
        bottomRightPanel.add(email5);
        bottomRightPanel.add(email6);
        
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(bottomRightPanel);
        
        veryBottom = new JPanel( new FlowLayout());
        cancelBTN = new JButton("Cancel");
        cancelBTN.setActionCommand("CLOSEADDWINDOW");
        submitBTN = new JButton("Submit");
        submitBTN.setActionCommand("SUBMITADD");
        
        veryBottom.add(submitBTN);
        veryBottom.add(cancelBTN);
        
        bigPanel.add(topPanel);
        bigPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        bigPanel.add(bottomPanel);
        bigPanel.add(veryBottom);
        
        addFrame.add(bigPanel);
        addFrame.setVisible(true);
        
    }//End of displayAddEntry() method
    
    
    /**
     * Takes all the phone numbers entered from the
     * text fields and adds them to an ArrayList.
     * 
     * @return ArrayList of all phone numbers entered
     */
    public ArrayList<String> getPhoneNumbers()
    {
        ArrayList<String> outPut = new ArrayList<>();

        if(!phone1.getText().equals(""))
            outPut.add(phone1.getText());
        if(!phone2.getText().equals(""))
            outPut.add(phone2.getText());
        if(!phone3.getText().equals(""))
            outPut.add(phone3.getText());
        if(!phone4.getText().equals(""))
            outPut.add(phone4.getText());
        if(!phone5.getText().equals(""))
            outPut.add(phone5.getText());
        if(!phone6.getText().equals(""))
            outPut.add(phone6.getText());
        
        return outPut;
  
    }//End of getPhoneNumbers() method
    
    
    /**
     * Takes all the email addresses entered from the
     * text fields and adds them to an ArrayList.
     * 
     * @return ArrayList of all email addresses entered
     */
    public ArrayList<String> getEmailAddresses()
    {
        ArrayList<String> outPut = new ArrayList<>();

        if(!email1.getText().equals(""))
            outPut.add(email1.getText());
        if(!email2.getText().equals(""))
            outPut.add(email2.getText());
        if(!email3.getText().equals(""))
            outPut.add(email3.getText());
        if(!email4.getText().equals(""))
            outPut.add(email4.getText());
        if(!email5.getText().equals(""))
            outPut.add(email5.getText());
        if(!email6.getText().equals(""))
            outPut.add(email6.getText());
        
        return outPut;
        
    }//End of getEmailAddresses() method
    
    
    /**
     * Gets First Name from TextField
     * 
     * @return String of first name entered
     */
    public String getFirstName()
    {
        return nameField.getText();
        
    }//End of getFirstName() method
     
    
    /**
     * Gets Last Name from TextField
     * 
     * @return String of last name entered
     */
    public String getLastName()
    {
        return lastNameField.getText();
        
    }//End of getLastName() method
    
    
    /**
     * Gets Organization Name from TextField
     * 
     * @return String of organization name entered
     */
    public String getOrgName()
    {
        return orgField.getText();
        
    }//End of getOrgName() method
    
    
    /**
     * Closes the addFrame
     */
    public void closeAdd()
    {
        addFrame.dispose();
        
    }//End of closeAdd() method
    
    
    /**
     * Creates and displays error frame
     */
    public void displayErrorFrame()
    {
        errorFrame = new JFrame();
        errorFrame.setTitle("Error!");
        errorFrame.setLocationRelativeTo(null);
        errorFrame.setSize(260,80);
        errorFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setResizable(false);
        errorFrame.setLayout( new FlowLayout() );
        
        error1  = new JLabel("Error: Incorrect Input, please try again");
        error1.setHorizontalAlignment(JLabel.CENTER);
        errorFrame.add(error1);

        closeErrorButton = new JButton("Close");
        closeErrorButton.setActionCommand("CLOSEERRORTWINDOW");
        errorFrame.add(closeErrorButton);
        
        errorFrame.setVisible(true);     
    
    }//End of displayErrorFrame() method
    
    
    /**
     * Closes the error frame
     */
    public void closeErrorFrame()
    {
        errorFrame.dispose();
        
    }//End of closeErrorFrame() method
    
    
    /**
     * Checks to make sure input is not blank
     * 
     * @return Boolean
     */
    public boolean correctInput()
    {
        if(getLastName().equals("") || getFirstName().equals("") || getOrgName().equals(""))
        {
            return false;    
        }

        else
        {
            return true;
        }
            
    }//End of correctInput() method
    
    
    /**
     * Sets Listeners
     * 
     * @param al
     */
    public void setActionListeners(ActionListener al)
    {

         cancelBTN.addActionListener(al);
         submitBTN.addActionListener(al);

        
    }//End of setActionListeners() method
    
}//End of AddView() Class
