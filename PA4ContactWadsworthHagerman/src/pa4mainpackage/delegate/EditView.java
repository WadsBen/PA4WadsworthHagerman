/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate;

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
import pa4mainpackage.model.ModelHandler;

/**
 *
 * @author Ben Wadsworth
 */
public class EditView 
{
    
    private JFrame          editFrame;
    private JPanel          bigPanel, topPanel, bottomPanel, bottomLeftPanel,
                            bottomRightPanel, veryBottom;
    private JLabel          fNLabel, lNLabel, orgLabel, phoneLabel, emailLabel;
    private JTextField      nameField, lastNameField, orgField,
                            phone1, phone2, phone3, phone4, phone5, phone6,
                            email1, email2, email3, email4, email5, email6;
    private JButton         cancelBTN, submitBTN;
    
    public EditView(String firstName, String lastName, String orgName,
            ArrayList<String> phoneList, ArrayList<String> emailList)
    {
        showEditView(firstName, lastName, orgName, phoneList, emailList);
    }
    
    public void showEditView(String firstName, String lastName, String orgName,
            ArrayList<String> phoneList, ArrayList<String> emailList)
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
        phoneLabel = new JLabel("Phone Number(s) [xxx-xxx-xxxx]");
        phoneLabel.setHorizontalAlignment(JLabel.CENTER);
        emailLabel = new JLabel("Email Address(es)");
        emailLabel.setHorizontalAlignment(JLabel.CENTER);
        
 
        nameField = new JTextField();
        nameField.setText(firstName);
        lastNameField = new JTextField();
        lastNameField.setText(lastName);
        orgField = new JTextField();
        orgField.setText(orgName);
        
        phone1 = new JTextField();
        phone2 = new JTextField();
        phone3 = new JTextField();
        phone4 = new JTextField();
        phone5 = new JTextField();
        phone6 = new JTextField();
        
        if(phoneList != null)
        {
            if(phoneList.get(0) != null)
                phone1.setText(phoneList.get(0));
            if(phoneList.get(1) != null)
                phone2.setText(phoneList.get(1));
            
            if(phoneList.get(2) != null)
                phone3.setText(phoneList.get(2));
            
            if(phoneList.get(3) != null)
                phone4.setText(phoneList.get(3));
            
            if(phoneList.get(4) != null)
                phone5.setText(phoneList.get(4));
            
            if(phoneList.get(5) != null)
                phone6.setText(phoneList.get(5));
        }
        
        email1 = new JTextField();
        email2 = new JTextField();
        email3 = new JTextField();
        email4 = new JTextField();
        email5 = new JTextField();
        email6 = new JTextField();
        
        if(emailList != null)
        {

            if(emailList.get(0) != null)
                email1.setText(emailList.get(0));
 
            if(emailList.get(1) != null)
                email2.setText(emailList.get(1));
 
            if(emailList.get(2) != null)
                email3.setText(emailList.get(2));
 
            if(emailList.get(3) != null)
                email4.setText(emailList.get(3));
 
            if(emailList.get(4) != null)
                email5.setText(emailList.get(4));
 
            if(emailList.get(5) != null)
                email6.setText(emailList.get(5));
        }
        
        
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
        cancelBTN.setActionCommand("CLOSEADDWINDOW");
       
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
    }
    
    public String getFirstName()
    {
        return(nameField.getText());
    }
    
    public String getLastName()
    {
        return(lastNameField.getText());
    }
    
    public String getOrganizationName()
    {
        return(orgField.getText());
    }
    
    public void setActionListeners(ActionListener al)
    {
         //closeErrorButton.addActionListener(al);
         cancelBTN.addActionListener(al);
         submitBTN.addActionListener(al);

        
    }//End setJButtonListen
}
