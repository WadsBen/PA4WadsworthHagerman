
package pa4mainpackage.delegate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JohnThomas
 */
public class AddView
{
    private JFrame addFrame, errorFrame;
    private JTextField lastNameField, nameField, orgField,email1,email2,email3,
            email4,email5, email6, phone1, phone2, phone3, phone4, phone5, phone6;
    private JPanel topPanel, bottomPanel, finalPane, bottomLeftPanel, 
            bigPanel, bottomRightPanel, veryBottom;
    private JLabel fNLabel, lNLabel, orgLabel, emailLabel, phoneLabel,error1, error2;
    private JButton submitBTN, cancelBTN, closeErrorButton;
    private ActionListener cancelAL, submitAL, closeAL;
    
    
    public AddView()
    {
       
    }
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
        bigPanel.add(topPanel);
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
        cancelBTN.addActionListener(cancelAL);
       
        submitBTN = new JButton("Submit");
        submitBTN.setActionCommand("SUBMITADD");
        submitBTN.addActionListener(submitAL);
        
        veryBottom.add(submitBTN);
        veryBottom.add(cancelBTN);
        
        bigPanel.add(bottomPanel);
        bigPanel.add(veryBottom);
        addFrame.add(bigPanel);
      
        addFrame.setVisible(true);
    }
    
    public String getFirstName()
    {
        return nameField.getText();
    }
    
    public String getLastName()
    {
        return lastNameField.getText();
    }
    
    public String getOrgName()
    {
        return orgField.getText();
    }
    
    public void closeAdd()
    {
        addFrame.dispose();
    }
    
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
        //error2  = new JLabel("Incorrect Input");
      //  error2.setHorizontalAlignment(JLabel.CENTER);
        
        errorFrame.add(error1);
       // errorFrame.add(error2);

        closeErrorButton = new JButton("Close");
        closeErrorButton.setActionCommand("CLOSEERRORTWINDOW");
        closeErrorButton.addActionListener(closeAL);
        errorFrame.add(closeErrorButton);
        
        
        errorFrame.setVisible(true);     
    
    }
    
    public void closeErrorFrame()
    {
        errorFrame.dispose();
    }
    
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
            
    }
    
  
    public void setActionListeners(ActionListener al)
    {
         closeAL = al;
         cancelAL = al;
         submitAL = al;

        
    }//End setJButtonListen
}
