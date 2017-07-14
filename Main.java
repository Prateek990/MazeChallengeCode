package MazeChallenge;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import MazeChallenge.FormatMaze;

public class Main {

	public static void main (String args[])
	{
		String filePath = args[0];
		//int numLife = Integer.valueOf(args[1]);

        // This will reference one line at a time
       String line = null;

       try {

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(new FileReader(filePath));
            
            line = bufferedReader.readLine();
            
            FormatMaze m = new FormatMaze();
            m.formatMaze(line, 3);
          
           // Need to this for every line
           while((line = bufferedReader.readLine()) != null) {
                m.formatMaze(line, 3);
            }  

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filePath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filePath + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
		
}
