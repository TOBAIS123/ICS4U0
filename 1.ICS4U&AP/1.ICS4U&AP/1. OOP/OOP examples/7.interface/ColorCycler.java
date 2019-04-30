// The "ColorCycler" class.
// This class is used to change the color of an object which 
// implements the Colorable interface in a smooth progression
// from red to orange then yellow, green, blue, and violet.
// The class has no non-static elements, so it should never
// be instantiated.

import java.awt.*;

public class ColorCycler
{
    // The total number of colors in the color sequence.
    protected static final int NUM_COLORS = 100;
    // The Color objects in the color sequence.
    protected static Color[] spectrum;

    // The static clause causes initialization when the class is first
    // loaded (as opposed to constructors, which cause initialization 
    // when an object is first instantiated). Only static variables
    // may be assigned values in the static clause.

    // The purpose of the initialization is to create a smooth
    // sequence of colors from red through orange, yellow, green, 
    // blue, and violet.
    static
    {
	spectrum = new Color [NUM_COLORS];
	int orangeBreak = NUM_COLORS / 5;
	int yellowBreak = NUM_COLORS * 2 / 5;
	int greenBreak = NUM_COLORS * 3 / 5;
	int blueBreak = NUM_COLORS * 4 / 5;
	for (int i = 0 ; i < NUM_COLORS ; i++)
	{
	    // The location (from 0 - 1) from the lower bound of the color
	    // range to the higher bound (0 = lower bound, 
	    // 1 = upper bound).
	    float location;
	    if (i <= orangeBreak)
	    {
		location = (float) i / orangeBreak;
		spectrum [i] = new Color (1.0f, (float) (0.6 * location), 0.0f);
	    }
	    else if (i <= yellowBreak)
	    {
		location = (float) (i - orangeBreak) / 
		    (yellowBreak - orangeBreak);
		spectrum [i] = 
		    new Color (1.0f, (float) (0.6 + 0.4 * location), 0.0f);
	    }
	    else if (i <= greenBreak)
	    {
		location = (float) (i - yellowBreak) / 
		    (greenBreak - yellowBreak);
		spectrum [i] = new Color ((float) (1.0 - location), 1.0f, 0.0f);
	    }
	    else if (i <= blueBreak)
	    {
		location = (float) (i - greenBreak) / (blueBreak - greenBreak);
		spectrum [i] = new Color (0.0f, (float) (1.0 - location), location);
	    }
	    else
	    {
		location = (float) (i - blueBreak) / 
		    ((NUM_COLORS - 1) - blueBreak);
		spectrum [i] = new Color ((float) (0.6 * location), 0.0f, 1.0f);
	    }
	}
    } // static clause

    // This method reads the current color of the Colorable object and
    // determines which color in the color sequence is closest to that
    // color. It then sets the object's color to the next color in the
    // sequence. While this may take a little time the first time that
    // cycleColor is called (getting the closest match of the object's
    // color to a color in the color sequence is time consuming), 
    // subsequent calls will be fairly quick (as the object's color 
    // will be one of the colors in the sequence).
    // Note this method is static, so a ColorCycler object does not have
    // to be instantiated in order to use it.
    public static void cycleColors (Colorable object)
    {
	Color c = object.getColor ();

	// See if the current color matches any of the colors in the
	// color sequence.
	for (int count = 0 ; count < NUM_COLORS ; count++)
	{
	    if (c == spectrum [count])
	    {
		object.setColor (spectrum [(count + 1) % NUM_COLORS]);
		return;
	    }
	}

	// If no color matched, see which color in the color sequence is the 
	// closest match and use that. (This is likely only to occur the 
	// first time this method is called for a particular Colorable 
	// object.)
	int closest = 0;
	int distance = Integer.MAX_VALUE;
	for (int count = 0 ; count < NUM_COLORS ; count++)
	{
	    int redDiff = spectrum [count].getRed () - c.getRed ();
	    int greenDiff = spectrum [count].getGreen () - c.getGreen ();
	    int blueDiff = spectrum [count].getBlue () - c.getBlue ();
	    int totalDiff = (redDiff * redDiff) + (greenDiff * greenDiff) +
		(blueDiff * blueDiff);
	
	    if (totalDiff < distance)
	    {
		distance = totalDiff;
		closest = count;
	    }
	}

	object.setColor (spectrum [(closest + 1) % NUM_COLORS]);
    } // cycleColors method
} /* ColorCycler interface */
