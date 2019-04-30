// The "Text" class.
// This class places text on the screen. It also implements the
// "Colorable" interface, so the text's color can be changed.
import java.awt.*;

public class Text implements Colorable
{
    // The static variable common to all Text objects.
    protected static Graphics g; // The graphics context (drawing surface).

    protected String text; // The text to be displayed on the screen.
    protected int x, y; // The x, y location of the text.
    protected int size; // The point size of the text.
    protected Font font; // The font of the text.
    protected Color textColor; // The color of the text.
   
    // Create the Text object.
    public Text (Component surface, String text, int x, int y,
	String textFace, int style, int size, Color color)
    {
	// Set the class variable g, if necessary.
	if (g == null)
	{
	    g = surface.getGraphics ();
	}

	// Set the object variables.    
	this.text = text;
	this.x = x;
	this.y = y;
	font = new Font (textFace, style, size);
	textColor = color;

	paint (); // Make it visible.
    } // Text constructor

    // Change the color of the text.
    public void setColor (Color color)
    {
	textColor = color;
	paint ();
    } // setColor method

    // Get the current color of the text.
    public Color getColor ()
    {
	return textColor;
    } // getColor method

    // Redraw the text.
    public void paint ()
    {
	g.setColor (textColor);
	g.setFont (font);
	g.drawString (text, x, y);
    } // paint method
} /* Text class */
