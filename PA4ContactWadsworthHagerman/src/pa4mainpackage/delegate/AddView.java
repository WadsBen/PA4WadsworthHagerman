
package pa4mainpackage.delegate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
    private JFrame addFrame;
    private JTextField lastNameField, nameField, orgField,email1,email2,email3,
            email4,email5, email6, phone1, phone2, phone3, phone4, phone5, phone6;
    private JPanel topPanel, bottomPanel, finalPane, bottomLeftPanel, 
            bigPanel, bottomRightPanel, veryBottom;
    private JLabel fNLabel, lNLabel, orgLabel, emailLabel, phoneLabel,l1,l2,l3,l4,l5,l6;
    private JButton submitBTN, cancelBTN;
    
    
    public AddView()
    {
        createAddEntry();
    }
    private void createAddEntry()
    {
        
        addFrame = new JFrame();
        addFrame.setTitle("Add Entry");
        addFrame.setLocationRelativeTo(null);
        addFrame.setSize(500,400);
        addFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        addFrame.setResizable(false);
        
        
        //JPanel finalPanej = new JPanel(new GridLayout(2,1,5,5));
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
      //bottomPanel.setPreferredSize(new Dimension(400,600));
        
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
        submitBTN = new JButton("Submit");
        //closeAboutButton.addActionListener(new AllWidgetListener() );
        
        veryBottom.add(submitBTN);
        veryBottom.add(cancelBTN);

        //finalPanej.add(toptopPanel);
        bigPanel.add(bottomPanel);
       // finalPanej.add(bottomPanel);
         bigPanel.add(veryBottom);
        //addFrame.add(finalPanej);
         addFrame.add(bigPanel);
      
        
        addFrame.setVisible(true);
    }
    
}
