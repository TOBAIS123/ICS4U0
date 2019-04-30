// The "FileToArray" class.
import java.awt.*;
import hsa.Console;
import java.io.*;

public class FileToArray
{
    static Console c;
    // The output console

    public static void main (String[] args)
    {

	c = new Console ();
	String line = ""; // file data var
	int numberOfLine = 0; // count lines in file var
	try
	{
  //try opening the file
	    BufferedReader reader = new BufferedReader (new FileReader ("arrtofile.txt"));

//loop for as long as there is data in  the file
	    while (line != null)
	    {
		line = reader.readLine ();  //read each line in the file

		numberOfLine++;  //count the number of lines in the file

	    }
	    reader.close ();  //close file

	}
	catch (IOException e)   //catch any file related errors
	{
	    System.out.println (e);  //print error
	}

	String[] linesFile = new String [numberOfLine];  //create array with size to match number of lines in file

	try
	{
	//open the same file again
	    BufferedReader r = new BufferedReader (new FileReader ("arrtofile.txt")); // reset the buffer
	    int x=0;
	    while (x<numberOfLine)  //loop until end of file is reached
	    {
	       
		linesFile[x] = r.readLine (); //feed each data line into an array
		 x++;
	     

	    }

	    r.close (); //close data file
	}

	catch (IOException e)  //handle file related errors
	{
	    System.out.println (e);
	}

	for (int i = (numberOfLine-1) ; i >0  ; i--)
	{    
	    c.print(i);
	    c.println (linesFile [i]);  //output data from array
	}
	 
	  

	// Place your program here.  'c' is the output console
    } // main method
} // FileToArray class
