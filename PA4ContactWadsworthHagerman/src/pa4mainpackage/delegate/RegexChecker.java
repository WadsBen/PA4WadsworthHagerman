package pa4mainpackage.delegate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides static methods to check for valid input.
 * 
 * @author Ben Wadsworth
 * @version 4-30-2015
 */
public class RegexChecker 
{
    /**
     * Possible variable names to use.
     */
    public enum RegexMethod{
        SIXTEEN_ALPHABET, EMAIL_ADDRESS, PHONE_NUMBER
    }
    
    /**
     * Checks passed string against pattern.
     * 
     * @param methodToUse Which regular expression to use
     * @param stringToCheck String to compare to pattern
     * @return true if valid input
     */
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
                String p = "[a-zA-Z0-9-+._]{1,}[@]{1}[a-zA-Z0-9-+._]{1,}[//.]{1}[a-zA-Z]{2,3}";
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
    }//End regexCheck method
    
}//End RegexChecker class
