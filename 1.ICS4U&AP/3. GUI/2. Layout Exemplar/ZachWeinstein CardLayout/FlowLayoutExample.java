/*Variable Dictionary:
d- a dialog box to be used in many places in the parogram through many different methods
flow- a new instance of FlowLayout to use to change the attributes of the flowLayout
button-a button to be used on the dialog boxes
panel- the panel to be used on the frame
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FlowLayoutExample extends JFrame implements ActionListener
{
    JDialog d;
    FlowLayout flow;
    JButton button;
    JPanel panel;
    //constructing the class
    public FlowLayoutExample ()
    {
	super ("FlowLayout Example"); //creating a title on the JFrame window by calling the constructor
	try
	{
	    UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    //setting the buttons to look like windows buttons and not like pieces of crap
	}
	catch (Exception e)
	{
	}
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //setting the JFrame window closing procedure to exit correctly
	flow = new FlowLayout (); //making a new instance of the FlowLayout1
	panel = new JPanel (flow); //making a new JPanel to be used as a card with FlowLayout
	JButton button1 = new JButton ("Get Allignment"); //creating new instances of buttons
	JButton button2 = new JButton ("Get Hgap"); //creating new instances of buttons
	JButton button3 = new JButton ("Get Vgap"); //creating new instances of buttons
	JButton button4 = new JButton ("Cycle Through Different Alignments"); //creating new instances of buttons
	JButton button5 = new JButton ("Set Hgap x2"); //creating new instances of buttons
	JButton button6 = new JButton ("Set Vgap x2"); //creating new instances of buttons

	panel.add (button1); //adding buttons to the JPanel
	button1.addActionListener (this); //adding an action listener for the buttons

	panel.add (button2); //adding buttons to the JPanel
	button2.addActionListener (this); //adding an action listener for the buttons

	panel.add (button3); //adding buttons to the JPanel
	button3.addActionListener (this); //adding an action listener for the buttons

	panel.add (button4); //adding buttons to the JPanel
	button4.addActionListener (this); //adding an action listener for the buttons

	panel.add (button5); //adding buttons to the JPanel
	button5.addActionListener (this); //adding an action listener for the buttons

	panel.add (button6); //adding buttons to the JPanel
	button6.addActionListener (this); //adding an action listener for the buttons

	getContentPane ().add (panel);//adding the panel to the screen
	setSize (500, 500); //setting the size of the window
	setVisible (true); //setting the window to be visible
    }


    /*listen for buttons and menu buttons clicked
    takes the action that occurs as type ActionEvent*/
    public void actionPerformed (ActionEvent ae)
    {
	if (ae.getActionCommand ().equals ("Get Alignment"))
	    //when the user chooses to get the alignment, the alignment is retrieved
	    getAlignment ();
	if (ae.getActionCommand ().equals ("Get Hgap"))
	    //when the user chooses to get the Hgap, the Hgap is retrieved
	    getHgap ();
	if (ae.getActionCommand ().equals ("Get Vgap"))
	    //when the user chooses to get the Vgap, the Vgap is retrieved
	    getVgap ();
	if (ae.getActionCommand ().equals ("Cycle Through Different Alignments"))
	    //when the user chooses to set the allignment
	    setAlignment ();
	if (ae.getActionCommand ().equals ("Set Hgap x2"))
	    //when the user chooses to set the HGap
	    setHgap ();
	if (ae.getActionCommand ().equals ("Set Vgap x2"))
	    //when the user chooses to set the Vgap
	    setVgap ();
    }


    //getting information of something that is on the flow layout screen
    public void getAlignment ()
    {
	d = new JDialog (this, "Allignment"); //making a new dialog box
	d.setSize (200, 100); //setting the size of the dialog box
	d.setResizable (false); //not allowing the dialog box to be resized

	if (flow.getAlignment () == FlowLayout.LEFT)
	    //displaying the current layout
	    button = new JButton ("FlowLayout.LEFT"); //creating a new instance of the button and giving it a title
	else if (flow.getAlignment () == FlowLayout.RIGHT)
	    button = new JButton ("FlowLayout.RIGHT"); //creating a new instance of the button and giving it a title
	else if (flow.getAlignment () == FlowLayout.CENTER)
	    button = new JButton ("FlowLayout.CENTER"); //creating a new instance of the button and giving it a title
	else if (flow.getAlignment () == FlowLayout.LEADING)
	    button = new JButton ("FlowLayout.LEADING"); //creating a new instance of the button and giving it a title
	else
	    button = new JButton ("FlowLayout.TRAILING");

	button.addActionListener (new ActionListener ()
	{ //adding an action listener for the button
	    public void actionPerformed (ActionEvent ae)
	    { //closing the dialog box when the button is clicked
		d.dispose ();
	    }
	}
	);
	d.getContentPane ().add (button); //adding the button to the dialog box
	d.setLocationRelativeTo (this); //setting the location of the dialog box to the middle of the JFrame screen
	d.show (); //showing the dialog box
    }


    //getting information of something that is on the flow layout screen
    public void getHgap ()
    {
	d = new JDialog (this, "Hgap"); //making a new dialog box
	d.setSize (200, 100); //setting the size of the dialog box
	d.setResizable (false); //not allowing the dialog box to be resized
	button = new JButton (String.valueOf (flow.getHgap ())); //creating a new instance of the button and giving it a title
	button.addActionListener (new ActionListener ()
	{ //adding an action listener for the button
	    public void actionPerformed (ActionEvent ae)
	    { //closing the dialog box when the button is clicked
		d.dispose ();
	    }
	}
	);
	d.getContentPane ().add (button); //adding the button to the dialog box
	d.setLocationRelativeTo (this); //setting the location of the dialog box to the middle of the JFrame screen
	d.show (); //showing the dialog box
    }


    //getting information of something that is on the flow layout screen
    public void getVgap ()
    {
	d = new JDialog (this, "Vgap"); //making a new dialog box
	d.setSize (200, 100); //setting the size of the dialog box
	d.setResizable (false); //not allowing the dialog box to be resized
	button = new JButton (String.valueOf (flow.getVgap ())); //creating a new instance of the button and giving it a title
	button.addActionListener (new ActionListener ()
	{ //adding an action listener for the button
	    public void actionPerformed (ActionEvent ae)
	    { //closing the dialog box when the button is clicked
		d.dispose ();
	    }
	}
	);
	d.getContentPane ().add (button); //adding the button to the dialog box
	d.setLocationRelativeTo (this); //setting the location of the dialog box to the middle of the JFrame screen
	d.show (); //showing the dialog box
    }


    //setting the flowLayout allignment on card2
    public void setAlignment ()
    {
	if (flow.getAlignment () == FlowLayout.LEFT)
	    //cycling through the layouts to be put on the screen
	    flow.setAlignment (FlowLayout.RIGHT); //setting the allignment
	else if (flow.getAlignment () == FlowLayout.RIGHT)
	    flow.setAlignment (FlowLayout.CENTER); //setting the allignment
	else if (flow.getAlignment () == FlowLayout.CENTER)
	    flow.setAlignment (FlowLayout.LEADING); //setting the allignment
	else if (flow.getAlignment () == FlowLayout.LEADING)
	    flow.setAlignment (FlowLayout.TRAILING); //setting the allignment
	else
	    flow.setAlignment (FlowLayout.LEFT); //setting the allignment
	panel.revalidate (); //refreshing the JPanel
    }


    //setting the Hgap on card2
    public void setHgap ()
    {
	flow.setHgap (flow.getHgap () * 2); //doubling the value of the Hgap
	panel.revalidate (); //refreshing the JPanel
    }


    //setting the Vgap on card2
    public void setVgap ()
    {
	flow.setVgap (flow.getVgap () * 2); //doubling the value of the Vgap
	panel.revalidate (); //refreshing the JPanel
    }


    //start of main
    public static void main (String[] args)
    { //making a new instance of the class
	new FlowLayoutExample ();
    }


    //end of main
}
