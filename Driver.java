
/**
 * This class is driver class will get user input of float number
 * The Driver create a new object to check all qualify of floating number
 * The Driver will shows all errors if user get number input unqualify 
 *
 * @author Khai Lim
 * @version 10/14/2017
 */
import java.util.*;
public class Driver
{
    public static void main(String args[])
    {
        while (true) //While loop keep ask user input for check all qualify
        {
                //local variable
                String s; // store user input by String
                Scanner scan=new Scanner(System.in); //create Scanner function to get user input
                                
                System.out.println("Enter the literal:"); //display on the screen 
                s=scan.nextLine(); // get user input and store in s
                  
                ValidateFloat v = new ValidateFloat(s); //create a object in other class
                
                
                if(v.Validate()) // check condition of user input to another class
                {
                    System.out.println("The number is a float number !!!");
                }
                else
                {
                    System.out.println("The number is not a float number !!!");
                    System.out.println("The Error: " + v.getError());
                }
            }
        
  
}
}