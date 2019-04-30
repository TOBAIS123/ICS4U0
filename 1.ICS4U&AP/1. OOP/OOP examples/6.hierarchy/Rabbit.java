// The "Rabbit" class.
// This class handles "rabbit faces" on a graphics surface. Once created, 
// they can be moved, hidden, and shown again.

import java.awt.*;

public class Rabbit extends Happy
{
    // Create a rabbit face that is to be drawn on the surface (which  
    // should be either an Applet or a Frame). 
    public Rabbit (Component surface, int x, int y, int radius)
    {
	super (surface, x, y, radius);
	color = Color.orange;
    } // Rabbit constructor

    // Create a rabbit face that is to be drawn on the surface (which 
    // should be either an Applet or a Frame). Randomly place it 
    // on the drawing surface. 
    public Rabbit (Component surface, int radius)
    {
	super (surface, radius);
	color = Color.orange;
    } // Rabbit constructor

    // Create a rabbit face that is to be drawn on the surface (which 
    // should be either an Applet or a Frame). Randomly place it
    // on the drawing surface. Randomly determine the radius of 
    // the face. 
    public Rabbit (Component surface)
    {
	super (surface);
	color = Color.orange;
    } // Rabbit constructor

    // Draw the rabbit face. We do this by drawing a happy face
    // using the super class and then drawing the ears, nose, and
    // whiskers.
    protected void drawShape (Color shapeColor, Color featureColor)
    {
	super.drawShape (shapeColor, featureColor); // Draw the happy face.

	// Draw the ears.
	g.setColor (shapeColor);
	g.fillOval (x - 2 * xRadius / 3, y - 2 * xRadius, 
	    xRadius / 3, 3 * xRadius / 2);
	g.fillOval (x + xRadius / 3, y - 2 * xRadius, 
	    xRadius / 3, 3 * xRadius / 2);

	// Draw the nose.
	g.setColor (featureColor);
	g.fillOval (x - xRadius / 10, y, xRadius / 5, yRadius / 5);

	// Draw the whiskers.
	g.drawLine (x - xRadius / 4, y, x - 3 * xRadius / 2, y - xRadius / 3);
	g.drawLine (x - xRadius / 4, y + xRadius / 10, 
	    x - 3 * xRadius / 2, y + xRadius / 10);
	g.drawLine (x - xRadius / 4, y + xRadius / 5, 
	    x - 3 * xRadius / 2, y  + xRadius / 5 + xRadius / 3);
	g.drawLine (x + xRadius / 4, y, x + 3 * xRadius / 2, y - xRadius / 3);
	g.drawLine (x + xRadius / 4, y + xRadius / 10, 
	    x + 3 * xRadius / 2, y + xRadius / 10);
	g.drawLine (x + xRadius / 4, y + xRadius / 5, 
	    x + 3 * xRadius / 2, y  + xRadius / 5 + xRadius / 3);
    } // drawShape method
} /* Rabbit class */
