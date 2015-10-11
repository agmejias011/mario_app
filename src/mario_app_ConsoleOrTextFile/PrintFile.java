/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario_app_ConsoleOrTextFile;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;


/**
 *
 * @author Andres
 */
public class PrintFile implements PrintStrategy
{
     private int height;
     private File file;
     private PrintWriter output;
    
     public PrintFile(int height) 
    {
        this.height = height;
        this.file = new File("pyramid.txt");
        this.output = null;
         try
        {output = new PrintWriter(file);}
         catch (FileNotFoundException e){}
    }   
   
    public int getHeight() 
    {
        return height;
    }

    public File getFile() throws IOException
    {
        File copyFile = new File("thisIs_a_Copy.txt");
        try{
             Files.copy(file.toPath(), copyFile.toPath());
           }
        catch (FileNotFoundException e){}
        
        return copyFile;
    }
    
    /**
     *
     */
    @Override
    public void DrawPyramid()// Drawing the pyramid in the file
    {
        
        if(height==0)
        {
            output.println("Mario is either walking or standing, as the height is 0");
        }
        else 
        {
            for (int i = 0; i < height; i++)
            {
                int auxiliary = 2+i; // 2+i = the amount of hashes on each row
                int spaces = height+2;//The total of spaces
                
                try
                {
                    output.printf("%"+spaces+"s",printHashes(auxiliary));
                    output.println();
                }
                catch (StringIndexOutOfBoundsException e){}
                
            }
            
         }
        if(output != null){output.close();}// always close the output stream
    }
     
     private static String printHashes(int num) // Printing Hashes
    {
        String hashesPrinted = "";
        for (int j = 0; j < num; j++) // printing hashes
            {
                hashesPrinted+="#";  
            }
             return hashesPrinted;
    }
}
    

