package pa4mainpackage.model;

import java.util.PriorityQueue;

public class ContactPhoneNumber
{
    
    PriorityQueue phonePriorityQueue;
    
    public ContactPhoneNumber()
    {
        phonePriorityQueue = new PriorityQueue(1000);
    }
    
    public void addPhoneNumber(String phoneNumber)
    {
        phonePriorityQueue.add(phoneNumber);
    }
    
    public boolean contains(Object element)
    {
        return(phonePriorityQueue.contains(element));
    }
}