// The "Oval" class.

// This class handles ovals on a graphics surface. Once created, they
// can be moved, hidden, and shown again.

import java.awt.*;

public class Oval extends Shape
{
    protected int xRadius, yRadius; // The x and y radius of the oval.

    // Create an oval that is to be drawn on the surface (which should
    // be either an Applet or a Frame). 
    public Oval (Component surface, int x, int y, int xRadius, int yRadius)
    {
	super (surface, x, y, Color.blue);
	this.xRadius = xRadius;
	this.yRadius = yRadius;
	show ();
    } // Oval constructor

    // Draw the shape.
    protected void draw ()
    {
	Graphics g = surface.getGraphics ();
	g.setColor (color);
	g.fillOval (x - xRadius, y - yRadius, 2 * xRadius, 2 * yRadius);
    } // draw method

    // Erase the shape.
    protected void erase ()
    {
	Graphics g = surface.getGraphics ();
	g.setColor (surface.getBackground ());
	g.fillOval (x - xRadius, y - yRadius, 2 * xRadius, 2 * yRadius);
    } // erase method
} /* Oval class */
