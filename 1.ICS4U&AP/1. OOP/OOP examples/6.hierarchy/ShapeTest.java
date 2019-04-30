// The "ShapeTest" class.
// This applet randomly places 20 shapes on the drawing surface
// and then moves the shapes around the screen, bouncing them
// off the edges.

import java.applet.*;
import java.awt.*;

public class ShapeTest extends Applet
{
    protected final static int NUM_SHAPES = 20;

    // The array containing the Shape objects.
    protected Shape[] shapes = new Shape [NUM_SHAPES];

    // This method is called when the Applet object is created.
    public void init ()
    {
	// Get the width and height of the drawing surface.
	int surfaceWidth = getSize ().width;
	int surfaceHeight = getSize ().height;

	// Create the shapes and place them randomly on the drawing surface.
	for (int count = 0 ; count < NUM_SHAPES ; count++)
	{
	    int shapeKind = (int) (Math.random () * 9);

	    if (shapeKind == 0)
	    {
		// The following two lines place the upper-left corner
		// of the rectangle in the upper-left quadrant.
		int x = (int) (Math.random () * surfaceWidth / 2);
		int y = (int) (Math.random () * surfaceHeight / 2);
		int rectWidth = (int) (Math.random () * 20) + 10;
		int rectHeight = (int) (Math.random () * 20) + 10;
		shapes [count] = new Rectangle (this, x, y, rectWidth, 
		    rectHeight);
	    }
	    else if (shapeKind == 1)
	    {
		int xRadius = (int) (Math.random () * 30) + 10;
		int yRadius = (int) (Math.random () * 10) + 10;
		shapes [count] = new Oval (this, xRadius, yRadius);
	    }
	    else if (shapeKind == 2)
	    {
		shapes [count] = new Triangle (this);
	    }
	    else if (shapeKind == 3)
	    {
		shapes [count] = new Circle (this);
	    }
	    else if (shapeKind == 4)
	    {
		shapes [count] = new Square (this);
	    }
	    else if (shapeKind == 5)
	    {
		int radius = (int) (Math.random () * 30) + 20;
		shapes [count] = new Face (this, radius);
	    }
	    else if (shapeKind == 6)
	    {
		int radius = (int) (Math.random () * 30) + 20;
		shapes [count] = new Happy (this, radius);
	    }
	    else if (shapeKind == 7)
	    {
		int radius = (int) (Math.random () * 30) + 20;
		shapes [count] = new Sad (this, radius);
	    }
	    else if (shapeKind == 8)
	    {
		int radius = (int) (Math.random () * 20) + 10;
		shapes [count] = new Rabbit (this, radius);
	    }
	}
    } // init method

    // This method is called when the Applet object is activated. Slide the
    // shapes around the drawing surface.
    public void start ()
    {
	setVisible (true); // Make the applet surface visible.

	// An infinite loop. In each iteration, every shape has its
	// slide method called.
	while (true)
	    for (int count = 0 ; count < NUM_SHAPES ; count++)
		shapes [count].slide ();
    } // start method

    // This method is called whenever the applet's drawing surface is
    // obscured and then revealed. We call the paint method for each
    // shape to redraw that shape (if the shape is currently visible).
    public void paint (Graphics g)
    {
	for (int count = 0 ; count < NUM_SHAPES ; count++)
	{
	    shapes [count].paint ();
	}
    } // paint method
} /* ShapeTest class */
