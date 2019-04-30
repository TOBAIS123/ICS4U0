// The "Circle" class.
// This class handles circles on a graphics surface. Once created, they
// can be moved, hidden, and shown again.

import java.awt.*;

public class Circle extends Oval
{
    // Create a circle that is to be drawn on the surface (which should
    // be either an Applet or a Frame) by creating an oval with
    // x and y radius the same. 
    public Circle (Component surface, int x, int y, int radius)
    {
	super (surface, x, y, radius, radius);
	color = Color.yellow;
    } // Circle constructor

    // Create a circle that is to be drawn on the surface (which should
    // be either an Applet or a Frame) by creating a oval with
    // x and y radius the same. Randomly place it on the 
    // drawing surface. 
    public Circle (Component surface, int radius)
    {
	super (surface, radius, radius);
	color = Color.yellow;
    } // Circle constructor

    // Create a circle that is to be drawn on the surface (which should
    // be either an Applet or a Frame) by creating a oval with
    // x and y radius the same. Randomly place it on the
    // drawing surface. Randomly determine the radius of the circle. 
    public Circle (Component surface)
    {
	super (surface);
	xRadius = (int) (Math.random () * 10) + 10;
	yRadius = xRadius;
	color = Color.yellow;
    } // Circle constructor
} /* Circle class */
