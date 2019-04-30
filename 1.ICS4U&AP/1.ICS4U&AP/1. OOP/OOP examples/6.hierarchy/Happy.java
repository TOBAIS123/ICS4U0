// The "Happy" class.
// This class handles "happy faces" on a graphics surface. Once created, 
// they can be moved, hidden, and shown again.

import java.awt.*;

public class Happy extends Face
{
    // Create a face that is to be drawn on the surface (which should 
    // be either an Applet or a Frame). 
    public Happy (Component surface, int x, int y, int radius)
    {
	super (surface, x, y, radius);
	color = Color.magenta;
    } // Happy constructor

    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the 
    // drawing surface. 
    public Happy (Component surface, int radius)
    {
	super (surface, radius);
	color = Color.magenta;
    } // Happy constructor

    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the
    // drawing surface. Randomly determine the radius of the face. 
    public Happy (Component surface)
    {
	super (surface);
	color = Color.magenta;
    } // Happy constructor

    // Draw the happy face. We do this by drawing a face (without mouth)
    // using the super class and then drawing the mouth.
    protected void drawShape (Color shapeColor, Color featureColor)
    {
	super.drawShape (shapeColor, featureColor); // Draw a face.

	// Draw the smile.
	g.setColor (featureColor);
	for (int i = 0 ; i < 2 ; i++)
	{
	    g.drawArc (x - 2 * xRadius / 3 - i, y - 2 * xRadius / 3 - i, 
		4 * xRadius / 3 + 2 * i, 4 * xRadius / 3 + 2 * i, 180, 180);
	}
    } // drawShape method
} /* Happy class */
