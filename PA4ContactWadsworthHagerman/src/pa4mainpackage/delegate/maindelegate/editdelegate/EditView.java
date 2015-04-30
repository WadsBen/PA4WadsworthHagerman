package pa4mainpackage.delegate.maindelegate.editdelegate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class which presents the Edit View.
 * 
 * @author Ben Wadsworth
 * @author John Hagerman
 * @version 4-30-2015
 */
public class EditView 
{
    
    private JFrame          editFrame;
    private JPanel          bigPanel, topPanel, bottomPanel, bottomLeftPanel,
                            bottomRightPanel, veryBottom;
    private JLabel          fNLabel, lNLabel, orgLabel, phoneLabel, emailLabel;
    private JTextField      nameField, lastNameField, orgField,
                            phone1, phone2, phone3, phone4, phone5, phone6, editKeyField,
                            email1, email2, email3, email4, email5, email6;
    private JButton         cancelBTN, submitBTN;
    
    /**
     * EditView no-arg constructor initializes the window
    */
    public EditView()
    {
        initWindow();
    }//End EditView no-arg constructor
    
    /**
     * EditView constructor which populates the Edit window with the values of the
     * contact.
     * 
     * @param firstName String representation of the first name
     * @param lastName String representation of the last name
     * @param orgName String representation of the organization name
     * @param phoneList ArrayList object of the phoneList
     * @param emailList ArrayList object of the emailList
     */
    public EditView(String firstName, String lastName, String orgName,
            ArrayList<String> phoneList, ArrayList<String> emailList)
    {
         populateEditWindow(firstName, lastName, orgName, phoneList, emailList);
    }//End EditView constructor
    
    /**
     * Initializes the edit window.
     */
    public void initWindow()
    {
        editFrame = new JFrame();
        editFrame.setTitle("Edit Entry");
        editFrame.setLocationRelativeTo(null);
        editFrame.setSize(500,400);
        editFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        editFrame.setResizable(false);
        

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
        phoneLabel = new JLabel("Phone Number(s)");
        phoneLabel.setHorizontalAlignment(JLabel.CENTER);
        emailLabel = new JLabel("Email Address(es)");
        emailLabel.setHorizontalAlignment(JLabel.CENTER);
        
 
        nameField = new JTextField();;
        lastNameField = new JTextField();
        orgField = new JTextField();
        
        //PROBABLY CAN BE IN AN ARRAY OF SOME SORT!
        phone1 = new JTextField();
        phone2 = new JTextField();
        phone3 = new JTextField();
        phone4 = new JTextField();
        phone5 = new JTextField();
        phone6 = new JTextField();
        
        //PROBABLY CAN BE IN AN ARRAY OF SOME SORT!
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
      
        //topPanel.addSeparator();
        
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
        cancelBTN.setActionCommand("CLOSEEDITWINDOW");
       
        submitBTN = new JButton("Submit");
        submitBTN.setActionCommand("SUBMITEDIT");
        
        veryBottom.add(submitBTN);
        veryBottom.add(cancelBTN);
        
        bigPanel.add(topPanel);
        bigPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        bigPanel.add(bottomPanel);
        bigPanel.add(veryBottom);
        
        editFrame.add(bigPanel);
        editFrame.setVisible(true);
    }//End initWindow method
    
    /**
     * Populates the edit window with values from the contact.
     * 
     * @param firstName String representation of the first name
     * @param lastName String representation of the last name
     * @param orgName String representation of the organization name
     * @param phoneList ArrayList object of the phoneList
     * @param emailList ArrayList object of the emailList
     */
    public void populateEditWindow(String firstName, String lastName, String orgName,
            ArrayList<String> phoneList, ArrayList<String> emailList)
    {
        nameField.setText(firstName);
        lastNameField.setText(lastName);
        orgField.setText(orgName);
        
        //THIS IS NOT PRETTY! :(
        int phoneListSize = phoneList.size();
        if(phoneListSize > 0)
            phone1.setText(phoneList.get(0));
        if(phoneListSize > 1)
            phone2.setText(phoneList.get(1));
        if(phoneListSize > 2)
            phone3.setText(phoneList.get(2));
        if(phoneListSize > 3)
            phone4.setText(phoneList.get(3));
        if(phoneListSize > 4)
            phone5.setText(phoneList.get(4));
        if(phoneListSize > 5)
            phone6.setText(phoneList.get(5));
        
        int emailListSize = emailList.size();
        if(emailListSize > 0)
            email1.setText(emailList.get(0));
        if(emailListSize > 1)
            email2.setText(emailList.get(1));
        if(emailListSize > 2)
            email3.setText(emailList.get(2));
        if(emailListSize > 3)
            email4.setText(emailList.get(3));
        if(emailListSize > 4)
            email5.setText(emailList.get(4));
        if(emailListSize > 5)
            email6.setText(emailList.get(5));
        
    }//End populateEditWindow method
    
    /**
     * Returns the first name in the text field.
     * 
     * @return String first name
     */
    public String getFirstName()
    {
        return(nameField.getText());
    }//End getFirstName method
    
    /**
     * Returns the last name in the text field.
     * 
     * @return String last name
     */
    public String getLastName()
    {
        return(lastNameField.getText());
    }//End getLastName method
    
    /**
     * Returns the organization name in the text field.
     * 
     * @return String organization name
     */
    public String getOrgName()
    {
        return(orgField.getText());
    }//End getOrgName method
    
    /**
     * Returns the phone numbers in the fields. This method can probably be modified
     * to look nicer.
     * 
     * @return ArrayList phone numbers
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
  
    }//End getPhoneNumbers method
    
    /**
     * Returns the email addresses in the fields. This method can probably be modified
     * to look nicer.
     * 
     * @return ArrayList email addresses
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
    }//End getEmailAddresses method
    
    /**
     * Closes the edit view.
     */
    public void close()
    {
        editFrame.dispose();
    }//End close method
    
    /**
     * Shows dialog prompting user for a valid key and returns a String of that key.
     * 
     * @return String representation of the key
     */
    public String getEditKey()
    {
       String inputValue = JOptionPane.showInputDialog("Please input the key value of " +
               "the contact you want to edit.");
       
       return(inputValue);
    }//End getEditKey method

    /**
     * Sets up action listeners for the edit view objects.
     * 
     * @param al ActionListener
     */
    public void setActionListeners(ActionListener al)
    {
         //closeErrorButton.addActionListener(al);
         cancelBTN.addActionListener(al);
         submitBTN.addActionListener(al);
         
    }//End setJButtonListen
    
}//End EditView class
