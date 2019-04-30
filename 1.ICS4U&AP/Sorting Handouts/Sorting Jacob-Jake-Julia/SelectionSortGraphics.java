import java.applet.*;
import java.awt.*;

public class SelectionSortGraphics extends Applet
{
    int[] a; //Array that we are gonna sort

    public void init ()
    {
	//Generating a array of 90 random integers between 1 and 500
	this.setSize (1000, 600);
	a = new int [90];
	for (int i = 0 ; i < a.length ; i++)
	{
	    a [i] = (int) (Math.random () * 499) + 1;
	}
    }


    public void paint (Graphics g)
    {
	//Mindex is the minimum index (of the search)
	//Temp just holds a value temporarily
	int mindex, temp;
	
	
	for (int j = 0 ; j < a.length ; j++)
	{
	    //Graphics Stuff the can be ignored
	    g.setColor (Color.WHITE);
	    g.fillRect ((j - 1) * 11, 0, 1000, 600);
	    g.setColor (new Color (200, 200, 200));

	    //This row is kindof important
	    mindex = j;


	    for (int k = j + 1 ; k < a.length ; k++)
	    {
	    
		if (a [k] < a [mindex])
		{
		    mindex = k;
		}
		
		
		//More graphics stuff that can be ignored
		for (int i = 0 ; i < a.length ; i++)
		{
		    if (i == mindex)
		    {

			g.setColor (new Color (255, 100, 100));
			g.fillOval (i * 11, 50, 10, a [i]);
			g.setColor (new Color (200, 200, 200));
		    }
		    else if (i == k)
		    {

			g.setColor (new Color (100, 200, 255));
			g.fillOval (i * 11, 50, 10, a [i]);
			g.setColor (new Color (200, 200, 200));
		    }
		    else
		    {
			g.fillOval (i * 11, 50, 10, a [i]);
		    }

		    try
		    {
			Thread.sleep (1);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    //Ignore up to here
		}
	    }

	    //This stuff is important
	    temp = a [j]; //Set the temporary value
	    a [j] = a [mindex]; //Swap the smallest value of this search with
	    a [mindex] = temp; //The first element of this search
	}
    }
} 
