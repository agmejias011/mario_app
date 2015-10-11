/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario_app_ConsoleOrTextFile;

import java.util.Scanner;


/**
 *
 * @author Andres
 */
public class MarioApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int height = ValidatingData(); // getting the height already validated
        promptUser(height);
    }
    
    /**
     *
     * @param height
     */
   public static void promptUser(int height)
   {
       Scanner reading = new Scanner(System.in);
       int userInput = 0;
       boolean caughtException;
       
       
       do
       {
           caughtException = false;
           System.out.println("Enter the number next to the option below to choose:\n"
               + "1. Printing Mario to Console\n"
               + "2. Printing Mario to a .txt File"); 
       
           try
            {
                userInput = Integer.parseInt(reading.nextLine()); // trying to get the input
                
                switch(userInput)
               {
                   case 1: 
                   {
                       PrintConsole console = new PrintConsole(height);
                       console.DrawPyramid();
                   }
                   break;
                   case 2:
                   {
                       PrintFile printingFile = new PrintFile(height);
                       printingFile.DrawPyramid();
                       System.out.println("The pyramid was successfully printed in the file pyramid.txt");
                   }
                   break;

                   default: 
                   {
                       System.out.println("Option not found. Type number 1 or 2 to select, and hit enter");
                       caughtException = true;
                   }
                   break;

               }
            }
            catch (NumberFormatException e) // setting TRUE the caughtException variable and prompt to enter the correct data
            {
               System.out.println("Option not found. Type number 1 or 2 to select, and hit enter\n");
               caughtException = true;
            }
       }
       while(caughtException);

    }
           
   
  
    private static int ValidatingData() // This method validates the input data and returns the validated input  
    {
        int userInput = -1; // variable to store the valid input
        boolean caughtException;
        Scanner readingInput = new Scanner(System.in); // Scanner to read the input
        
        do
        {
            caughtException = false; // variable to set true if it catches a NumberFormatException
            System.out.println("Please enter the height of the Mario Half-Pyramid (0-23): ");
            try
            {
                userInput = Integer.parseInt(readingInput.nextLine()); // trying to get the input
            }
            catch (NumberFormatException e) // setting TRUE the caughtException variable and prompt to enter the correct data
            {
                caughtException = true;
                System.out.println("Error! Please try again the input must be a number between 0 - 23");
            }
            
        }
        while(!isValid(userInput) || caughtException); // While the input is still not valid
        
        return userInput;
    }
    private static boolean isValid(int input) // Validates the range of the input 0-23
    {
        return (input>=0 && input <=23);
     
    }    
    
    
}



