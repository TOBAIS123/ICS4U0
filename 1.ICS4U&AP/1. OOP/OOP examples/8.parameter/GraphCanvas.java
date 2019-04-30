// The "GraphCanvas" class.
// Draws an equation on the canvas whenever the paint method is called.

import java.awt.*;

class GraphCanvas extends Canvas
{
    Equation eq; // The equation to draw.
    double xFrom, xTo, yFrom, yTo; // The graphics limits.
    // Variables to convert real coordinates into screen coordinates.
    double mx, bx, my, by;

    // This creates the canvas. All the information to draw the graph 
    // is passed in to the constructor. Precalculates variables used
    // for conversion of real coordinates to screen coordinates.
    public GraphCanvas (Equation eq, int xSize, int ySize, double xFrom, 
	double xTo, double yFrom, double yTo)
    {
	super (); // Create the canvas.

	setSize (xSize, ySize);

	// Set instance variables.
	this.eq = eq;
	this.xFrom = xFrom;
	this.xTo = xTo;
	this.yFrom = yFrom;
	this.yTo = yTo;
   } // GraphCanvas constructor

   // Convert the real x coordinate into a screen x coordinate.
   protected int convertX (double rx)
   {
	return (int) (mx * rx + bx);
   } // convertX method

   // Convert the real y coordinate into a screen y coordinate.
   protected int convertY (double ry)
   {
	return (int) (my * ry + by);
   } // convertY method

   // The paint method. Graph the equation whenever the screen
   // needs to be redrawn.
   public void paint (Graphics g)
   {
	int xSize, ySize;
	int oldY, newY;

	// Get canvas' height and width.
	xSize = getSize ().width;
	ySize = getSize ().height;

	// Calculate transformation of real x (rx) to graphics context 
	// coordinates (gx). Use equation gx = (mx) rx + (bx).
	mx = (double) xSize / (xTo - xFrom);
	bx = -mx * xFrom;

	// Calculate transformation of real y (ry) to graphics context 
	// coordinates (gy). Use equation gy = (my) ry + (by).
	my = (double) ySize / (yFrom - yTo);
	by = -my * yTo;

	// Establish starting point.
	oldY = convertY (eq.f (xFrom));

	for (int count = 1 ; count < xSize ; count++)
	{
	    double realX = xFrom + (xTo - xFrom) * count / xSize;
	    double realY = eq.f (realX);
	    newY = convertY (realY);
	    g.drawLine (count - 1, oldY, count, newY);
	    oldY = newY;
	}

	// Draw axes.
	g.setColor (Color.red);
	int xAxis = convertY (0.0);
	g.drawLine (0, xAxis, xSize, xAxis);
	int yAxis = convertX (0.0);
	g.drawLine (yAxis, 0, yAxis, ySize);
   } // paint method
} /* GraphCanvas class */
