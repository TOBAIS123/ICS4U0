/*
    Steven Wang
    BorderLayout Test Program
    Feb 17/06, v. 1.01.002
    This program tests out using the BorderLayout class
    Var Dictionary:
	- myPanel   : JPanel        - container for components
	- cLabel    : JLabel        - a label component in center
	- wGap      : int           - width of space between buttons
	- vGap      : int           - height of space between buttons
	- bLayout   : BorderLayout  - the layout for myPanel
	- nButton   : JButton       - top button
	- sButton   : JButton       - bottom button
	- eButton   : JButton       - right button
	- wButton   : JButton       - left button
	- a         : String        - output var #1
	- b         : String        - output var #2
*/

// importing library files
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// BorderLayoutTest class
public class BorderLayoutTest2 extends JFrame implements ActionListener
{

    // Global Variables
    JPanel myPanel;
    JLabel cLabel;
    int wGap = 0, vGap = 0; // declare and initialize
    BorderLayout bLayout;

    // constructor method
    public BorderLayoutTest2 ()
    {
	// constructs JFrame w/ a title
	super ("BorderLayout Example");

	// creates the panel
	myPanel = new JPanel ();
	// adds myPanel to JFrame's content pane
	getContentPane ().add (myPanel);

	// creates the layout with the predefined size between gaps
	bLayout = new BorderLayout (wGap, vGap);
	// sets the layout to myPanel
	myPanel.setLayout (bLayout);

	// creates 4 buttons and labels them
	JButton nButton = new JButton ("North");
	JButton sButton = new JButton ("South");
	JButton eButton = new JButton ("East");
	JButton wButton = new JButton ("West");
	// creates label, sets the text, and sets alignment
	cLabel = new JLabel ("THIS IS THE CENTRAL DISPLAY", JLabel.CENTER);

	// adds the actionlisteners to the 4 buttons
	nButton.addActionListener (this);
	sButton.addActionListener (this);
	eButton.addActionListener (this);
	wButton.addActionListener (this);

	// adds the components onto myPanel
	myPanel.add (cLabel, BorderLayout.CENTER);
	myPanel.add (nButton, BorderLayout.NORTH);
	myPanel.add (sButton, BorderLayout.SOUTH);
	myPanel.add (eButton, BorderLayout.EAST);
	myPanel.add (wButton, BorderLayout.WEST);
	setVisible (true);

	setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

    }


    // the actionlistener method to decide what to do when button is clicked
    public void actionPerformed (ActionEvent e)
    {
	// declares output var
	String a, b;

	// checks which button was pressed

	// if user wants to increase space between buttons
	if (e.getActionCommand ().equals ("Increase Space Between Buttons") && wGap < 146)
	{
	    wGap += 5; // increase width of gap
	    vGap += 5; // increase height of gap
	    bLayout.setHgap (wGap); // sets the new layout
	    bLayout.setVgap (vGap);
	    // updates myPanel with changed layout
	    myPanel.updateUI ();
	}
	// if user wants to increase space between buttons
	if (e.getActionCommand ().equals ("Decrease Space Between Buttons") && wGap > 4)
	{
	    wGap -= 5; // increase width of gap
	    vGap -= 5; // increase height of gap
	    bLayout.setHgap (wGap); // sets the new layout
	    bLayout.setVgap (vGap);
	    // updates myPanel with changed layout
	    myPanel.updateUI ();
	}
	// if user wants to know alignment of the component
	if (e.getActionCommand ().equals ("Alignment"))
	{
	    a = Float.toString (bLayout.getLayoutAlignmentX (myPanel)); // obtains the 2 output var
	    b = Float.toString (bLayout.getLayoutAlignmentY (myPanel));

	    // outputs by resetting text on the center label
	    cLabel.setText ("Alignment along x-axis is " + a + " and alignment along y-axis is " + b);
	    // updates myPanel with changed layout
	    myPanel.updateUI ();

	}
	// if user wants to know the space between the buttons
	if (e.getActionCommand ().equals ("Gap Sizes"))
	{
	    a = Integer.toString (bLayout.getHgap ());  // obtains the 2 output var
	    b = Integer.toString (bLayout.getVgap ());

	    // outputs by resetting text on the center label
	    cLabel.setText ("Horizontal gap is " + a + " and vertical gap is " + b);
	    // updates myPanel with changed layout
	    myPanel.updateUI ();
	}

    }


    // main method
    public static void main (String[] args)
    {
	// constructs class
	new BorderLayoutTest2 ();

    }
} // BorderLayoutTest class
