/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.model;

import java.util.ArrayList;
import pa4mainpackage.exceptions.EmptyCollectionException;

/**
 *
 * @author Ben Wadsworth
 */
public class PrimaryKeyHandler 
{
    private ArrayList<Integer> primaryKeys;
    private int nextValueToPull;
    
    public PrimaryKeyHandler()
    {
        primaryKeys = new ArrayList<>(1000);
        nextValueToPull = 0;
        populateArrayKeys();
        
        System.out.println(primaryKeys.toString());
    }
    
    public Integer getNextAvailableKey()
    {
        if(primaryKeys.isEmpty())
            return null;
        else
        {
            nextValueToPull++;
            return(primaryKeys.remove(nextValueToPull--));
        }
    }
    
    public void addAKey(Integer keyValue)
    {
        primaryKeys.add(keyValue);
    }
    
    private void populateArrayKeys()
    {
        for(int i = 0; i < 1000; i++)
        {
            primaryKeys.add(new Integer(i + 1001));
        }
    }
}
