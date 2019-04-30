// The "Dict" class.
import java.awt.*;
import java.util.*;
import hsa.*;

public class HashLookupEx
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	String dictWord;    // Current word from the dictionary.
	String testString;  // Hold the string we are looking up in HashSet.

	Set words = new HashSet (); // Makes a new HashSet to hold all the words in the dictionary.

	// Opens the input dictionary file.
	TextInputFile f;
	f = new TextInputFile ("dict.txt");

	// Reads
	while (!f.eof ())
	{
	    // Read next word from the file and add it to the HashSet.
	    dictWord = f.readString ();
	    words.add (dictWord.toUpperCase ());
	}

	// Close the dictionary file.
	f.close ();

	// Gets a word to lookup in the dictionary and prints a message if the word was found or not.
	c.print ("Enter a word to lookup (enter \"quit\" to exit):");
	testString = c.readString();
	while (!testString.equals ("quit"))
	{
	    if (words.contains (testString.toUpperCase ()))
	    {
		c.println ("The word: " + testString + " was found.");
	    }
	    else
	    {
		c.println ("The word: " + testString + " was not found.");
	    }
	    c.print ("Enter a word to lookup:");
	    testString = c.readString();
	}

    } // main method
} // Dict class
