// The "Sad" class.
// This class handles "sad faces" on a graphics surface. Once created, they
// can be moved, hidden, and shown again.

import java.awt.*;

public class Sad extends Face
{
    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). 
    public Sad (Component surface, int x, int y, int radius)
    {
	super (surface, x, y, radius);
	color = Color.cyan;
    } // Sad constructor

    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the 
    // drawing surface. 
    public Sad (Component surface, int radius)
    {
	super (surface, radius);
	color = Color.cyan;
    } // Sad constructor

    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the
    // drawing surface. Randomly determine the radius of the face. 
    public Sad (Component surface)
    {
	super (surface);
	color = Color.cyan;
    } // Sad constructor

    // Draw the sad face. We do this by drawing a face (without mouth)
    // using the super class and then drawing the mouth.
    protected void drawShape (Color shapeColor, Color featureColor)
    {
	super.drawShape (shapeColor, featureColor); // Draw the face.

	// Draw the frown.
	g.setColor (featureColor);
	for (int i = 0 ; i < 2 ; i++)
	{
	    g.drawArc (x - 2 * xRadius / 3 - i, y + xRadius / 6 - i, 
		4 * xRadius / 3 + 2 * i, 4 * xRadius / 3 + 2 * i, 45, 90);
	}
    } // drawShape method
} /* Sad class */
