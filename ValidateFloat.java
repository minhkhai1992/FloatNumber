
/**
 * This class holds a data and check all condition floating number qualify
 * The class will hold to check Decimal Point, Negative/Positive sign, E character
 * The class should be meet all condition to become floating point
 * The program will store the error if it stucks
 *
 * @author Khai Lim
 * @version 10/14/2017
 */

public class ValidateFloat
{
    private String validateString = ""; //Declare and use the float number in driver class
    private String error = ""; // store all error each method
    
    public ValidateFloat(String str)
    {
        //local variable
        validateString = str; // default a float number in validateString
        error = ""; // default a error
    }
    
    // The method will check all condition qualify for floating point 
    public boolean Validate()
    {
        //local variable
        if (oneDecimalCheck(validateString) && signCheck(validateString) &&
            charECheck(validateString) && conditionCheck(validateString))
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }  
    
    //The method only check a decimal point(Dots) in a floating number 
    public boolean oneDecimalCheck(String str)
    {
        //local variable
        int count = 0;
        for ( int k = 0 ; k < str.length(); k++)
        {
            if (str.charAt(k) == '.')
            {
                count++;
            }
        
        }
        //The Dots only 1 available in floating number
        if (count >= 2)
        {
            error = "Contain more than 1 decimal point";
            return false;
        }
        else 
        {
            return true;
        }
    }

    //The signCheck will check all negative and positive sign avaiable in Floating number
    public boolean signCheck(String sign)
    {
      //local variable
      int count = 0; // default count as zero to start check later on
      for (int k = 0; k < sign.length() ; k++)
      {
          if(sign.charAt(k) == '+' || sign.charAt(k) == '-')
          {
              count++;
          }
      }
      // the sign only have 0, 1 or 2 signs.
      if (count > 2)
      {
          error = "Contain more than 2 signs";
          return false;
      }
      else
      {
          return true;
      }
    }
    
    // The method check E/e character available in Floating number 
    public boolean charECheck(String ch)
    {
        //local variable
        int count = 0; //default the count as a zero for check E available in floating number
        for (int k = 0; k < ch.length(); k++)
        {
            if (ch.charAt(k) == 'E' || ch.charAt(k) == 'e')
            {
                count++;
            }
        }
        // e character only have 1 in floating number
        if (count >= 2)
        {
            error = "Contain more than 1 E character";
            return false;
        }
        else
        {
            return true;
        }
    }

    
    //The method will check all condition make floating number qualify to check floating number
    public boolean conditionCheck(String cdt)
    {
        //local variables
        int sign1 = -1, sign2 = -1, e=-1, d=-1; // all variable declare to check all qualify condition
        boolean condition = false; // default condition as a fault for use later on
        
        for (int k = 0; k < cdt.length(); k++)
        {
            if (cdt.charAt(k) == '+' || cdt.charAt(k) == '-')
            {
                if (k == 0)
                    sign1 = k;
                else
                    sign2 = k;
            }
            if (cdt.charAt(k) == 'E' || cdt.charAt(k) == 'e')
            {
                e = k;
            }
            if (cdt.charAt(k) == '.')
            {
                d = k;
            }
        }
        
        if (sign1 == -1 && sign2 == -1)
        {
            if ((e - d >= 2) && (e != cdt.length()-1))
                condition = true;
            if (e == -1 && d != -1 && d != cdt.length()-1)
                condition = true;
        }
        else if (sign1 == -1)
        {
            if ((sign2 == e+1) && (sign2 != cdt.length()-1))
                condition = true;
        }
        else if (sign2 == -1 && sign1 == 0)
        {
            if ((e - d >= 2) && (e != cdt.length()-1))
                condition = true;
            if (e == -1 && d != -1 && d != cdt.length()-1)
                condition = true;
        }
        else
        {
            if ((sign1 == 0) && (e-d >= 2) && (sign2 == e+1) && (sign2 != cdt.length()-1))
                condition = true;
        }
        if (!condition)
            error = "Fail the condition check";
        return condition;
    }
    
    public String getError()
    {
        return error;
    }


}





