/*
Fred Ting
Feb 17, 2006 v.10.2
Ms. Dyke
This program will make buttons on a GridBag Layout and display some functions of it.

Variablr Library:
newPanel: Variable for the JPanel
gridbag: Variable for gridbag layout
d: Variable for dialog box
s: varible for information
info: Title for dialog
button, button2, button3, button4, button5: varibles for buttons
info: Parameter pass for string to be displayed
title: Parameter pass for dialog title
dim: gets layout dimensions
inf: Varible for dim in a string
*/

//Library files
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridBag1 extends JFrame implements ActionListener
{
    JPanel newPanel;
    GridBagLayout gridbag;
    JDialog d;

    public GridBag1 ()
    {
	//constructs window
	super ("JFrame Test");

	//creates new JPanel and adds to window
	newPanel = new JPanel ();
	getContentPane ().add (newPanel);

	//creates gridbag layout and sets to window
	gridbag = new GridBagLayout ();
	newPanel.setLayout (gridbag);

	//creates constraints for buttons
	GridBagConstraints c = new GridBagConstraints ();

	//set button to maximum size
	c.fill = GridBagConstraints.BOTH;

	//creates buttons, adds constraints and adds actionlisteners
	Button button = new Button ("Layout Dimensions");
	c.weightx = 1.0;
	c.weightx = 2.0;
	gridbag.setConstraints (button, c);
	newPanel.add (button);
	button.addActionListener (this);

	Button button1 = new Button ("Horizontal Alignment");
	c.weightx = 1.0;
	c.gridwidth = GridBagConstraints.REMAINDER;
	gridbag.setConstraints (button1, c);
	newPanel.add (button1);
	button1.addActionListener (this);

	Button button3 = new Button ("Close");
	c.gridheight = 3;
	c.weighty = 1.0;
	c.weightx = 1.0;
	c.gridwidth = GridBagConstraints.RELATIVE;
	gridbag.setConstraints (button3, c);
	newPanel.add (button3);
	button3.addActionListener (this);

	Button button4 = new Button ("Layout Values");
	c.weightx = 1.0;
	c.gridheight = 1;
	c.gridwidth = GridBagConstraints.REMAINDER;
	gridbag.setConstraints (button4, c);
	newPanel.add (button4);
	button4.addActionListener (this);

	Button button5 = new Button ("Vertical Alignment");
	c.gridheight = 2;
	c.gridwidth = GridBagConstraints.REMAINDER;
	gridbag.setConstraints (button5, c);
	newPanel.add (button5);
	button5.addActionListener (this);

	//sets window attributes
	setSize (600, 400);
	setVisible (true);
	setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    }


    //Creates dialog box for "About"
    public void aboutDialog (String info, String title)
    {
	//creates dialog
	d = new JDialog (this, title);
	d.setSize (500, 100);
	d.setResizable (false);
	d.getContentPane ().setLayout (gridbag);
	//displays information
	JLabel infoText = new JLabel (info);
	//creates button
	JButton closeButton = new JButton ("Close");
	//listens for button click
	closeButton.addActionListener (new ActionListener ()
	{
	    public void actionPerformed (ActionEvent e)
	    {
		d.dispose ();
	    }
	}
	);
	//adds objects to dialog
	d.getContentPane ().add (infoText);
	d.getContentPane ().add (closeButton);
	d.setLocationRelativeTo (this);
	d.show ();
    }


    //actions to be performed on button click
    public void actionPerformed (ActionEvent ae)
    {
	//variables for info
	String s, info;
	if (ae.getActionCommand ().equals ("Close"))
	{
	    System.exit (0);
	}
	//gets layout values
	if (ae.getActionCommand ().equals ("Layout Values"))
	{
	    s = (gridbag.toString ());
	    aboutDialog (s, "Grid Bag Layout Values");
	}
	//gets button dimensions
	if (ae.getActionCommand ().equals ("Layout Dimensions"))
	{
	    int[] [] dim = gridbag.getLayoutDimensions ();
	    String inf = "The dimensions of the layout (button sizes) are ";
	    for (int i = 0 ; i < dim.length ; i++)
	    {
		for (int j = 0 ; j < dim [i].length ; j++)
		{
		    inf += (dim [i] [j] + ", ");
		}
	    }
	    aboutDialog (inf, "Grid Bag Layout Values");
	}
	//gets vertical alignment
	if (ae.getActionCommand ().equals ("Vertical Alignment"))
	{
	    s = Float.toString (gridbag.getLayoutAlignmentY (newPanel));
	    aboutDialog (s + " If value is 0.5 the panel is centered vertically!~", "Alignment Info");
	}
	//gets horizontal alignment
	if (ae.getActionCommand ().equals ("Horizontal Alignment"))
	{
	    s = Float.toString (gridbag.getLayoutAlignmentX (newPanel));
	    aboutDialog (s + " If value is 0.5 the panel is centered horizontally!~", "Alignment Info");

	}
    }


    //main program
    public static void main (String[] args)
    {
	new GridBag1 ();



	// Place your program here.  'c' is the output console
    } // main method
} // GridBag1 class





