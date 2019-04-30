// The "Graph" class.
// This class creates a frame with a plotted equation in it. The 
// equation to be graphed must be an object that implements the 
// Equation interface.

import java.awt.*;

public class Graph extends Frame
{
    // The canvas on which the graph will be drawn.
    protected GraphCanvas canvas; 

    // The Graph constructor. The Equation object, size of the canvas
    // and the x and y limits of the graph are passed as parameters.
    public Graph (Equation eq, int xSize, int ySize, double xFrom, 
	double xTo, double yFrom, double yTo)
    {
	super ("Graph"); // Create the window labelled Graph.
	// Instantiate the canvas.
	canvas = new GraphCanvas (eq, xSize, ySize, xFrom, xTo, yFrom, yTo);
	add (canvas); // Place it in the Frame.
	pack (); // Shrink the Frame to the minimum size holding the canvas.
	setVisible (true); // Make the Frame visible.
    } // Graph constructor
} /* Graph class */
