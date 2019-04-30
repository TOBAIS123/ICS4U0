// The "Square" class.
// This class handles squares on a graphics surface. Once created, they
// can be moved, hidden and, shown again.

import java.awt.*;

public class Square extends Rectangle
{
    // Create a square that is to be drawn on the surface (which should
    // be either an Applet or a Frame) by creating a rectangle with
    // height and width the same. 
    public Square (Component surface, int x, int y, int side)
    {
	super (surface, x, y, side, side);
	color = Color.gray;
    } // Square constructor

    // Create a square that is to be drawn on the surface (which should
    // be either an Applet or a Frame) by creating a rectangle with
    // height and width the same. Randomly place it on the 
    // drawing surface. 
    public Square (Component surface, int side)
    {
	super (surface, side, side);
	color = Color.gray;
    } // Square constructor

    // Create a square that is to be drawn on the surface (which should
    // be either an Applet or a Frame) by creating a rectangle with
    // height and width the same. Randomly place it on the
    // drawing surface. Randomly determine the length of a side  
    // of the square. 
    public Square (Component surface)
    {
	super (surface);
	color = Color.gray;
	rectWidth = (int) (Math.random () * 20) + 10;
	rectHeight = rectWidth;
    } // Square constructor
} /* Square class */
