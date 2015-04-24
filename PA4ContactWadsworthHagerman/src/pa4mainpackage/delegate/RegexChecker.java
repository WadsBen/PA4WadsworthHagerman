/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4mainpackage.delegate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ben Wadsworth
 */
public class RegexChecker 
{
    public enum RegexMethod{
        SIXTEEN_ALPHABET, EMAIL_ADDRESS, PHONE_NUMBER
    }
    
    public static boolean regexCheck(RegexMethod methodToUse, String stringToCheck)
    {
        switch(methodToUse)
        {
            case SIXTEEN_ALPHABET:
            {
                String p = "[A-Za-z]{1,16}";
                Pattern pattern = Pattern.compile(p);
                Matcher matcher = pattern.matcher(stringToCheck);
                
                return(matcher.matches());
            }
            case EMAIL_ADDRESS:
            {
                String p = "[a-zA-Z0-9]+@[a-z]";
                Pattern pattern = Pattern.compile(p);
                Matcher matcher = pattern.matcher(stringToCheck);
                
                return(matcher.matches());
            }
            case PHONE_NUMBER:
            {
                String p = "[0-9]{10,11}";
                Pattern pattern = Pattern.compile(p);
                Matcher matcher = pattern.matcher(stringToCheck);
                
                return(matcher.matches());
            }
        }
        
        return(true);
    }
}
