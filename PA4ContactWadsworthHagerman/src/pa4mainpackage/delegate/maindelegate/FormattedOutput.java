/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate.maindelegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import pa4mainpackage.model.Contact;

/**
 *
 * @author Ben Wadsworth
 */
public class FormattedOutput 
{
    public FormattedOutput()
    {
    
    }
    
    public String ascendingContactView(TreeMap storage)
    {
         Set set = storage.entrySet();
         String returnString = "";
         Iterator i = set.iterator();
       
         while(i.hasNext()) 
         {
             Map.Entry entry = (Map.Entry)i.next();
             int x = (int) entry.getKey();
             returnString += formattedGUIContact(x, storage);
             returnString += "\n--------------------------------------------------------"
                     + "--------------------------------------------------------\n";
         }
         return(returnString);
         
    }//End of toString() method
    
        /**
     * Iterates through the TreeMap in reverse and prepares a 
     * formatted string of all the elements within the tree.
     * 
     * @return TreeMap where the contacts are stored
     */
    public String descendingContactView(TreeMap storage)
    {
         NavigableMap nmap = storage.descendingMap();
         Set set = nmap.entrySet();
         String returnString = "";
         Iterator i = set.iterator();
         
         while(i.hasNext()) 
         {
             Map.Entry entry = (Map.Entry)i.next();
             int x = (int) entry.getKey();
             returnString += formattedGUIContact(x, storage);
             returnString += "\n--------------------------------------------------------"
                     + "--------------------------------------------------------\n";
         }
        return(returnString);
        
    }//End of reverseToString() method
    
    /**
     * This method formats a contact so that is is in columns of fixed width
     * 
     * @param treeLocation      //Key
     * @return String representation of formatted Contact
     */
    private String formattedGUIContact(Integer treeLocation, TreeMap storage)
    {
        String returnString = "";
        Contact tempContact = (Contact) storage.get(treeLocation);
        
        String phoneString = tempContact.getContactPhoneNumber().getAllPhoneNumbers();
        List<String> phoneList = new ArrayList<>(Arrays.asList(phoneString.split(" ")));
        String phoneListString = "           ";
        String emailString = tempContact.getContactEmailAddress().getAllEmailAddresses();
        List<String> emailList = new ArrayList<>(Arrays.asList(emailString.split(" ")));
        String emailListString = "           ";
        
        String extraString = "";
        
        String[][] outPutArray = new String[6][2];
        
        if(emailList.isEmpty() == false)
            emailListString = emailList.get(0);
        
        if(phoneList.isEmpty() == false)
            phoneListString = phoneList.get(0);

        for (int i = 0; i < phoneList.size(); i++)
            outPutArray[i][0] = phoneList.get(i);
        
        for (int i = 0; i < emailList.size(); i++)
            outPutArray[i][1] = emailList.get(i);
        
        if((outPutArray[1][0] != null) || (outPutArray[1][1] != null))
            extraString +="\n";
       
        for(int i = 1; i < 5; i++)
        {
            if( (outPutArray[i][0] != null) && (outPutArray[i][1] != null)) 
            {
                extraString += String.format("%71s", outPutArray[i][0]) + "   "
                        + outPutArray[i][1]; 
                  
                  if(i != 5)
                      if((outPutArray[i + 1][0] != null) && (outPutArray[i + 1][1] != null));
                          extraString += "\n";                    
            }
     
            else if( (outPutArray[i][0] == null) && (outPutArray[i][1] != null)) 
            {
                extraString += String.format("%71s", "           ") + "   "
                        + outPutArray[i][1]; 
                
                if(i != 5)
                    if((outPutArray[i + 1][0] != null) && (outPutArray[i + 1][1] != null));
                        extraString += "\n";
                
            }
            else if( (outPutArray[i][0] != null) && (outPutArray[i][1] == null)) 
            {
                 extraString += String.format("%71s", outPutArray[i][0]);
                 
                 if(i != 5)
                    if((outPutArray[i + 1][0] != null) && (outPutArray[i + 1][1] != null));
                        extraString += "\n";
            }             
        }
        returnString = "  " +
                String.format("%-8s", treeLocation) + " " +
                String.format("%-16s",tempContact.getLastName()) + " " +
                String.format("%-16s",tempContact.getFirstName()) + " " +
                String.format("%-16s",tempContact.getOrganization()) +
                phoneListString + "   " + emailListString + extraString ;
                         
        return(returnString);
        
    }//End of formattedGUIContact() method
}
