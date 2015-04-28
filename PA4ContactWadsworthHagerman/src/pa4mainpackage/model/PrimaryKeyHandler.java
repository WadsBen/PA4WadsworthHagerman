/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;
import pa4mainpackage.exceptions.EmptyCollectionException;

/**
 *
 * @author Ben Wadsworth
 */
public class PrimaryKeyHandler implements Serializable
{
    private ArrayList<Integer> primaryKeys;
    private int nextValueToPull;
    private final int MAX_AMOUNT_OF_KEYS = 1000;
    
    public PrimaryKeyHandler()
    {
        primaryKeys = new ArrayList<>();
        nextValueToPull = 0;
        populateArrayKeys();
    }
    
    public Integer getNextAvailableKey()
    {
        if(primaryKeys.isEmpty())
            return null;
        else
        {
            Integer returnValue = primaryKeys.remove(nextValueToPull);
            return(returnValue);
        }
    }
    
    public void addAKey(Integer keyValue)
    {
        primaryKeys.add(keyValue);
    }
    
    public boolean isEmpty()
    {
        return(primaryKeys.isEmpty());
    }
    
    private void populateArrayKeys()
    {
        for(int i = 0; i < MAX_AMOUNT_OF_KEYS; i++)
        {
            primaryKeys.add(new Integer(i + 1001));
        }
    }
}
