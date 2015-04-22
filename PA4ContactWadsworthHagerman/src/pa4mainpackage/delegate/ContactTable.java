/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import pa4mainpackage.model.Contact;
import pa4mainpackage.model.ModelHandler;
import pa4mainpackage.model.PA4TreeMapStore;

/**
 *
 * @author Ben Wadsworth
 */
public class ContactTable 
{
    
    private ModelHandler mh;
    private JTable returnTable;
    
    public ContactTable(ModelHandler mh)
    {
        this.mh = mh;
    }
    
    public JTable formattedJTable()
    {
        String[] columnNames = {"ID", "Last Name", "First Name", "Organization", "Phone Numbers", "Email Addresses"};
        Object[][] dataFinal = new Object[][]{};
        Object[][] dataTemp;
     
        Set<Integer> keys = mh.getTreeMapStorage().keySet();
        
        for(Integer key : keys)
        {
            Contact tempContact = (Contact) mh.getContact(key);
            dataTemp = new Object[][]{{tempContact.getKeyID(), 
                tempContact.getLastName(),
                tempContact.getFirstName(), 
                tempContact.getOrganization(), 
                tempContact.getContactPhoneNumber().getAllPhoneNumbers(),
                tempContact.getContactEmailAddress().getAllEmailAddresses()}};
            
            dataFinal = append(dataFinal, dataTemp);
        }
        
        returnTable = new JTable(dataFinal, columnNames);
        
//        TableColumn column = null;
//        for (int i = 0; i != 6; i++) {
//            column = returnTable.getColumnModel().getColumn(i);
//            
//            if (i == 0)
//            {
//                column.setPreferredWidth(50);
//            }
//            else if (i > 0 && i < 4) 
//            {
//                column.setPreferredWidth(600); //third column is bigger
//            } 
//            
//            else if (i > 3 || i < 6) 
//            {
//                column.setPreferredWidth(1200);
//            }
//        }
        
        return(returnTable);
    }
    
    
    private Object[][] append(Object[][] a, Object[][] b) 
    {
        
        Object[][] result = new Object[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        
        return result;
    }
}
