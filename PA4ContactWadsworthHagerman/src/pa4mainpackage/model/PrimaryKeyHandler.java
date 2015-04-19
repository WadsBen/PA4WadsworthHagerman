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
    Integer[] primaryKeys;
    int minValue;
    
    public PrimaryKeyHandler()
    {
        primaryKeys = new Integer[1000];
        populateArrayKeys();
        minValue = 0;
    }
    
    public Integer getNextAvailableKey()
    {
        int returnIndex = minValue;
        minValue++;
        return(primaryKeys[returnIndex]);
    }
    
    private void populateArrayKeys()
    {
        for(int i = 0; i < primaryKeys.length; i++)
        {
            primaryKeys[i] = i;
        }
    }
}
