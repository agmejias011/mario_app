/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario_app_ConsoleOrTextFile;

import java.util.MissingFormatArgumentException;



/**
 *
 * @author Andres
 */
public class PrintConsole implements PrintStrategy
{
    private int height;

    public PrintConsole(int height)
    {
        this.height = height;
        
    }

    public int getHeight() 
    {
        return height;
    }

    @Override
     public void DrawPyramid()// Drawing the pyramid
    {
        
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
