package pa4mainpackage.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class provides the storage and access to valid primary keys ranging from
 * 1001 - MAX_AMOUNT_OF_KEYS. Its use is to separate primary key assignment from
 * the user into an automated process.
 * 
 * @author Ben Wadsworth
 * @version 4-28-2015
 */
public class PrimaryKeyHandler implements Serializable
{
    private final int MAX_AMOUNT_OF_KEYS = 1000;
    
    private ArrayList<Integer> primaryKeys;
    private int nextValueToPull;
    
    /**
     * PrimaryKeyHandler no-arg constructor
     */
    public PrimaryKeyHandler()
    {
        
        primaryKeys = new ArrayList<>();
        nextValueToPull = 0;
        populateArrayKeys();
        
    }//End PrimaryKeyHandler no-arg constructor
    
    /**
     * Returns the next Integer to be used as a key for the TreeMap storage in
     * the ModelHandler.
     * 
     * @return Integer to be used as a key for the TreeMap storage in the ModelHandler
     */
    public Integer getNextAvailableKey()
    {
        
        if(primaryKeys.isEmpty()) //If no keys available return null.
            return null;
        else
        {
            Integer returnValue = primaryKeys.remove(nextValueToPull);
            return(returnValue);
        }
        
    }//End getNextAvailableKey method
    
    /**
     * Adds a key value to the primaryKeys ArrayList. This should only be used
     * when a contact is deleted in the ModelHandler and passed the deleted 
     * contacts key to reintroduce it as a valid, available key.
     * 
     * @param keyValue the value to add back into the ArrayList
     */
    public void addAKey(Integer keyValue)
    {
        primaryKeys.add(keyValue);
    }//End addAKey method
    
    /**
     * Returns true if empty, false if at least one element is present
     * 
     * @return true if empty, false if at least one element is present
     */
    public boolean isEmpty()
    {
        return(primaryKeys.isEmpty());
    }//End isEmpty method
    
    /**
     * Populates the primaryKeys ArrayList with MAX_AMOUNT_OF_KEYS
     */
    private void populateArrayKeys()
    {
        
        for(int i = 0; i < MAX_AMOUNT_OF_KEYS; i++)
        {
            primaryKeys.add(new Integer(i + 1001));
        }
        
    }//End populateArrayKeys private method
    
}//End PrimaryKeyHandler class
