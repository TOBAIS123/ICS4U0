/*Variable Dictionary:
d- a dialog box to be used in many places in the parogram through many different methods
button-a button to be used on the dialog boxes
button1, button2-buttons to be used on the panel
panel- the panel to be used on the frame
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AbsolutePositioningExample extends JFrame implements ActionListener
{
    JDialog d;
    JButton button;
    JButton button1, button2;
    JPanel panel = new JPanel (null);
    public AbsolutePositioningExample ()
    {
	super ("Absolute Positioning Example"); //creating a new JFrame window with a title
	try
	{
	    UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    //setting the buttons to look like windows buttons 
	}
	catch (Exception e)
	{
	}
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //setting the JFrame window closing procedure to exit correctly
	button1 = new JButton ("Move Button 10 Pixels Right"); //creating a new instance of the button with a title
	button1.addActionListener (this); //adding an action listener for the button
	button2 = new JButton ("Grow Button By 10 Pixels Vertically"); //creating a new instance of the button with a title
	button2.addActionListener (this); //adding an action listener for the button
	panel.add (button1); //adding the buttons, label, and textField to the card1 panel
	panel.add (button2); //adding the buttons, label, and textField to the card1 panel
	Dimension size = button1.getPreferredSize (); //getting the prefferedSize of the item to be put on the screen
	button1.setBounds (20, 20, size.width, size.height); //setting the position and the size of the item to be put on the screen
	size = button2.getPreferredSize (); //getting the prefferedSize of the item to be put on the screen
	button2.setBounds (125, 70, size.width, size.height); //setting the position and the size of the item to be put on the screen
	getContentPane ().add (panel); //adding the panel to the screen
	setSize (400, 400); //setting the size of the window
	setVisible (true); //setting the window to be visible
    }


    public void actionPerformed (ActionEvent ae)
    {
	if (ae.getActionCommand ().equals ("Move Button 10 Pixels Right"))
	    //when the user chooses to move a button 10 pixels right
	    moveButton10PixelsRight ();
	if (ae.getActionCommand ().equals ("Grow Button By 10 Pixels Vertically"))
	    //when the user chooses to grow the button by 10 pixels vertically
	    growButton10PixelsVertically ();
    }


    //growing button2 on the absolute screen 10 pixels vertically
    /*Variable Dictionary:
    size-to store the size of the button
    */
    public void growButton10PixelsVertically ()
    {
	Dimension size = button2.getSize (); //creating a Dimension to
	button2.setSize (size.width, size.height + 10); //growing the button by 10 pixels
	panel.revalidate (); //refreshing the JPanel
    }


    //moving button1 on the absolute screen 10 pixels to the right
    /*Variable Dictionary:
    location-to store the location of the button
    */
    public void moveButton10PixelsRight ()
    {
	Point location = button1.getLocation (); //creating a Point to store the location of the button currently
	button1.setLocation (location.x + 10, location.y); //moving the button 10 pixels right
	panel.revalidate (); //refreshing the JPanel
    }


    //start of main
    public static void main (String[] args)
    { //new instance of this class
	new AbsolutePositioningExample ();
    }


    //end of main
}
