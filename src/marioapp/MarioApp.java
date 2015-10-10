/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioapp;
import java.util.Scanner;
import java.util.MissingFormatArgumentException;

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
        DrawPyramid();
    }
    
    /**
     *
     */
    public static void DrawPyramid()// Drawing the pyramid
    {
        int height = ValidatingData(); // getting the height already validated
        if(height!=0)
        {
        for (int i = 0; i < height; i++) 
        {
            int auxiliary = 2+i; // 2+i = the amount of hashes on each row
            int spaces = height+2;//The total of spaces
            
            try{
                System.out.printf("%"+spaces+"s",printHashes(auxiliary));
                    
                }
            catch (MissingFormatArgumentException e){}
 
            } 
        } 
        else System.out.println("Mario is either walking or standing, as the height is 0");
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
    private static String printHashes(int num) // Printing Hashes
    {
        String hashesPrinted = "";
        for (int j = 0; j < num; j++) // printing hashes
            {
                hashesPrinted+="#";  
            }
             return hashesPrinted+"\n";
    }
    
}



