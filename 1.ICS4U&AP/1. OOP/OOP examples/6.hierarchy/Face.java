// The "Face" class.
// This class handles Faces on a graphics surface. Once created, they
// can be moved, hidden, and shown again.

import java.awt.*;

public class Face extends Circle
{
    // The color the features (such as mouth and eyes) should be drawn in.
    protected static Color FEATURE_COLOR = Color.black;

    // Create a face that is to be drawn on the surface (which should 
    // be either an Applet or a Frame). 
    public Face (Component surface, int x, int y, int radius)
    {
	super (surface, x, y, radius);
	color = Color.pink;
    } // Face constructor

    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the 
    // drawing surface. 
    public Face (Component surface, int radius)
    {
	super (surface, radius);
	color = Color.pink;
    } // Face constructor

    // Create a face that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the
    // drawing surface. Randomly determine the radius of the face. 
    public Face (Component surface)
    {
	super (surface);
	color = Color.pink;
    } // Face constructor

    // The new form of drawShape requires two parameters. The color of
    // the base image and the color of the features to be placed on
    // the image.
    public void draw ()
    {
	drawShape (color, FEATURE_COLOR);
    } // draw method

    // Note that in terms of drawing, we are slightly inefficient
    // because we draw the features in the background color when
    // they have already been erased. Doing this however, it makes 
    // the program easier to understand.
    public void erase ()
    {
	drawShape (backgroundColor, backgroundColor);
    } // erase method

    // Draw the face. We do this by drawing a circle using the super
    // class and then drawing the eyes.
    protected void drawShape (Color shapeColor, Color featureColor)
    {
	super.drawShape (shapeColor); // Draw the circle.

	// Draw the eyes.
	g.setColor (featureColor);
	g.fillOval (x - xRadius / 3 - xRadius / 6, y - xRadius / 3 - xRadius / 6,
		xRadius / 3, xRadius / 3);
	g.fillOval (x + xRadius / 3 - xRadius / 6, y - xRadius / 3 - xRadius / 6,
		xRadius / 3, xRadius / 3);
    } // drawShape method
} /* Face class */
