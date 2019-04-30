/*
Zach Weinstein
Cards With Different Layouts
Feb. 15/08 v1.0
This program shows that user different layouts and how they can be in the same panel as each other using cardLayout.  As well, the user
	can scroll through the different layouts using a JComboBox

Variable Dictionary:
JDialog d- a dialog box to be used to create new instances in multiple methods throughout the program
FlowLayout flow- a new instance of flowlayout for changing the hGap, vGap, and the allignment
JPanel cards-to have a panel that uses CardLayout to scroll through all the other panels
JPanel card1,card2,card3- cards to be put in cards that have to be accessed outside of the constructCards method
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardsWithDifferentLayouts extends JFrame implements ItemListener, ActionListener
{
    JDialog d;
    FlowLayout flow = new FlowLayout ();
    JButton button, button1, button2;
    JPanel cards, card3, card2 = new JPanel (flow), card1 = new JPanel (null); //making a new JPanel to be used as a card with no layout

    //constructing the class
    public CardsWithDifferentLayouts ()
    {
	super ("Cards With Different Layouts"); //creating a new JFrame window with a title
	try
	{
	    UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    //setting the buttons to look like windows buttons and not like pieces of crap
	}
	catch (Exception e)
	{
	}
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //setting the JFrame window closing procedure to exit correctly
	constructCards (); //Create and sets up the cards.

	setSize (600, 600); //setting the size of the window
	setResizable (false); //setting the window to be not resizable
	setVisible (true); //setting the window to be visible
    }


    //constructing all of the cards and adding them all to the card layout and adding the apropriate action listeners
    public void constructCards ()
    {
	final String CARD1 = "Card 1 with Absolute Positioning",  //titles for all 6 cards
	    CARD2 = "Card 2 with FlowLayout", CARD3 = "Card 3 with Absolute Positioning inside FlowLayout",
	    CARD4 = "Card 4 with GridBagLayout", CARD5 = "Card 5 with BorderLayout", CARD6 = "Card 6 with other 3 layouts inside FlowLayout";
	//Put the JComboBox in a JPanel to get a nicer look.
	JPanel comboBoxPane = new JPanel (); //using FlowLayout() for the comboBox
	String comboBoxItems[] = {CARD1, CARD2, CARD3, CARD4, CARD5, CARD6}; //adding all the titles to the comboBox
	JComboBox cb = new JComboBox (comboBoxItems); //creating a comboBox with all the correct titles
	cb.addItemListener (this); //adding an itemListener to the comboBox so that when you click an item, it does something
	comboBoxPane.add (cb); //adding the comboBox tot he panel

	JMenuBar menuBar = new JMenuBar (); //creating a menuBar
	JMenu quitMenu = new JMenu ("Quit"); //creating a menu for the menu bar
	JMenuItem quitItem = new JMenuItem ("Quit"); //creating a menu item for the menu
	quitMenu.add (quitItem); //adding the quitItem to the quitMenu
	menuBar.add (quitMenu); //adding the quitMenu to the menuBar
	quitItem.addActionListener (this); //adding an action listener to the quitItem so that when it is clicked, the program exits
	setJMenuBar (menuBar); //setting the menubar to be active

	button1 = new JButton ("Move Button 10 Pixels Right"); //creating a button to put on the absoloute positioning card
	button1.addActionListener (this); //adding an action listener for when the button is clicked
	button2 = new JButton ("Grow Button By 10 Pixels Vertically"); //creating a button to put on the absoloute positioning card
	button2.addActionListener (this); //adding an action listener for when the button is clicked
	card1.add (button1); //adding the buttons, label, and textField to the card1 panel
	card1.add (button2); //adding the buttons, label, and textField to the card1 panel
	Dimension size = button1.getPreferredSize (); //getting the prefferedSize of the item to be put on the screen
	button1.setBounds (20, 20, size.width, size.height); //setting the position and the size of the item to be put on the screen
	size = button2.getPreferredSize (); //getting the prefferedSize of the item to be put on the screen
	button2.setBounds (125, 70, size.width, size.height); //setting the position and the size of the item to be put on the screen

	JButton button1 = new JButton ("Get Alignment"); //creating new instances of buttons
	JButton button2 = new JButton ("Get Hgap"); //creating new instances of buttons
	JButton button3 = new JButton ("Get Vgap"); //creating new instances of buttons
	JButton button4 = new JButton ("Cycle Through Different Alignments"); //creating new instances of buttons
	JButton button5 = new JButton ("Set Hgap x2"); //creating new instances of buttons
	JButton button6 = new JButton ("Set Vgap x2"); //creating new instances of buttons
	card2.add (button1); //adding buttons to the JPanel
	button1.addActionListener (this); //adding an action listener for the button
	card2.add (button2); //adding buttons to the JPanel
	button2.addActionListener (this); //adding an action listener for the button
	card2.add (button3); //adding buttons to the JPanel
	button3.addActionListener (this); //adding an action listener for the button
	card2.add (button4); //adding buttons to the JPanel
	button4.addActionListener (this); //adding an action listener for the button
	card2.add (button5); //adding buttons to the JPanel
	button5.addActionListener (this); //adding an action listener for the button
	card2.add (button6); //adding buttons to the JPanel
	button6.addActionListener (this); //adding an action listener for the button

	card3 = new JPanel (new FlowLayout ()); //creating a new panel to be used as a card
	JPanel card3Absolute = new JPanel (null); //creating a new panel to be added to the card3 flowLayout panel
	button1 = new JButton ("Button 1 Absolute"); //creating a new instance of a button
	size = button1.getPreferredSize (); //getting the preferred width and height of the button
	button1.setBounds (75, 200, size.width, size.height); //setting the location and the size of the button
	card3Absolute.add (button1); //adding the button to the absolute panel
	card3Absolute.setPreferredSize (new Dimension (200, 350)); //setting the preferred size of the abslute panel so that it shows up on the screen
	button1 = new JButton ("Button One"); //creating new instances of buttons
	button2 = new JButton ("Button Two"); //creating new instances of buttons
	button3 = new JButton ("Button Three"); //creating new instances of buttons
	button4 = new JButton ("Button Four"); //creating new instances of buttons
	button5 = new JButton ("Button Five"); //creating new instances of buttons
	button6 = new JButton ("Button Six"); //creating new instances of buttons
	card3.add (button1); //adding buttons to the JPanel
	card3.add (button2); //adding buttons to the JPanel
	card3.add (button3); //adding buttons to the JPanel
	card3.add (button4); //adding buttons to the JPanel
	card3.add (button5); //adding buttons to the JPanel
	card3.add (button6); //adding buttons to the JPanel
	card3.add (card3Absolute); //adding the absolute panel to the flow panel


	JPanel card4 = new JPanel (new GridBagLayout ()); //creating a new JPanel to be used as a card with the layout GridBagLayout
	GridBagConstraints c = new GridBagConstraints (); //making a new instance of gridBagConstraintes to use for the GridBagLayout
	button1 = new JButton ("Button 1");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	card4.add (button1, c);

	button2 = new JButton ("Button 2");

	c.gridx = 1;
	c.gridy = 0;
	c.weightx = 1;
	card4.add (button2, c);

	button3 = new JButton ("Button 3");

	c.gridx = 2;
	c.gridy = 0;
	c.weightx = 1;
	card4.add (button3, c);

	button4 = new JButton ("Button 4");
	c.insets = new Insets (0, 30, 0, 0);
	c.gridx = 0;
	c.gridy = 1;
	card4.add (button4, c);

	button5 = new JButton ("Button 5");
	c.insets = new Insets (0, 0, 0, 0);
	c.gridx = 1;
	c.gridy = 2;
	c.ipady = 30;
	card4.add (button5, c);


	JPanel card5 = new JPanel (new BorderLayout ()); //creating a new card type JPanel  with BorderLayout
	JButton borderButton = new JButton ("Button 1");
	borderButton.setPreferredSize (new Dimension (60, 60));
	card5.add (borderButton, BorderLayout.PAGE_START);
	JButton borderButton2 = new JButton ("Button 2");
	borderButton2.setPreferredSize (new Dimension (90, 100));
	card5.add (borderButton2, BorderLayout.LINE_START);

	JButton borderButton3 = new JButton ("Button 3");
	borderButton3.setPreferredSize (new Dimension (130, 50));
	card5.add (borderButton3, BorderLayout.CENTER);
	JButton borderButton4 = new JButton ("Button 4");
	borderButton4.setPreferredSize (new Dimension (90, 100));
	card5.add (borderButton4, BorderLayout.LINE_END);

	JButton borderButton5 = new JButton ("Button 5");
	borderButton5.setPreferredSize (new Dimension (100, 20));
	card5.add (borderButton5, BorderLayout.PAGE_END);



	JPanel card6 = new JPanel (new FlowLayout ()),  //creating new JPanels with the layout
	    card6Absolute = new JPanel (null), card6GridBag = new JPanel (new GridBagLayout ()), card6Border = new JPanel (new BorderLayout ());

	button1 = new JButton ("Absolute 1");
	card6Absolute.add (button1); //adding the buttons, label, and textField to the card1 panel
	size = button1.getPreferredSize (); //getting the prefferedSize of the item to be put on the screen
	button1.setBounds (20, 20, size.width, size.height); //setting the position and the size of the item to be put on the screen
	card6Absolute.setPreferredSize (new Dimension (150, 100));

	button1 = new JButton ("Button One"); //creating new instances of buttons
	button2 = new JButton ("Button Two"); //creating new instances of buttons
	button3 = new JButton ("Button Three"); //creating new instances of buttons
	button4 = new JButton ("Button Four"); //creating new instances of buttons
	button5 = new JButton ("Button Five"); //creating new instances of buttons
	button6 = new JButton ("Button Six"); //creating new instances of buttons
	card6.add (button1); //adding buttons to the JPanel
	card6.add (button2); //adding buttons to the JPanel
	card6.add (button3); //adding buttons to the JPanel
	card6.add (button4); //adding buttons to the JPanel
	card6.add (button5); //adding buttons to the JPanel
	card6.add (button6); //adding buttons to the JPanel

	c = new GridBagConstraints ();
	button1 = new JButton ("GridBag 1");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	card6GridBag.add (button1, c);
	button2 = new JButton ("GridBag 2");
	c.gridx = 1;
	c.gridy = 0;
	c.weightx = 1;
	card6GridBag.add (button2, c);
	button3 = new JButton ("GridBag 3");
	c.gridx = 2;
	c.gridy = 0;
	c.weightx = 1;
	card6GridBag.add (button3, c);
	button4 = new JButton ("GridBag 4");
	c.insets = new Insets (0, 30, 0, 0);
	c.gridx = 0;
	c.gridy = 1;
	card6GridBag.add (button4, c);
	button5 = new JButton ("GridBag 5");
	c.insets = new Insets (0, 0, 0, 0);
	c.gridx = 1;
	c.gridy = 2;
	c.ipady = 30;
	card6GridBag.add (button5, c);


	borderButton = new JButton ("Border 1");
	borderButton.setPreferredSize (new Dimension (60, 60));
	card6Border.add (borderButton, BorderLayout.PAGE_START);
	borderButton2 = new JButton ("Border 2");
	borderButton2.setPreferredSize (new Dimension (90, 100));
	card6Border.add (borderButton2, BorderLayout.LINE_START);
	borderButton3 = new JButton ("Border 3");
	borderButton3.setPreferredSize (new Dimension (130, 50));
	card6Border.add (borderButton3, BorderLayout.CENTER);
	borderButton4 = new JButton ("Border 4");
	borderButton4.setPreferredSize (new Dimension (90, 100));
	card6Border.add (borderButton4, BorderLayout.LINE_END);
	borderButton5 = new JButton ("Border 5");
	borderButton5.setPreferredSize (new Dimension (100, 20));
	card6Border.add (borderButton5, BorderLayout.PAGE_END);

	card6.add (card6Absolute); //adding the absolute panel to card6
	card6.add (card6GridBag); //adding the grid bag layout panel to card6
	card6.add (card6Border); //adding the border layout panel to card6
	card6.setPreferredSize (new Dimension (300, 300));

	cards = new JPanel (new CardLayout ()); //Create the panel that contains the "cards".
	cards.add (card1, CARD1); //adding cardx as a card with the TITLE CARDx
	cards.add (card2, CARD2); //adding cardx as a card with the TITLE CARDx
	cards.add (card3, CARD3); //adding cardx as a card with the TITLE CARDx
	cards.add (card4, CARD4); //adding cardx as a card with the TITLE CARDx
	cards.add (card5, CARD5); //adding cardx as a card with the TITLE CARDx
	cards.add (card6, CARD6); //adding cardx as a card with the TITLE CARDx
	getContentPane ().add (comboBoxPane, BorderLayout.PAGE_START); //adding the comboBox to the JFrame
	getContentPane ().add (cards, BorderLayout.CENTER); //adding the cards to the JFrame
    }


    /*listen for buttons and menu buttons clicked
    takes the action that occurs as type ActionEvent*/
    public void actionPerformed (ActionEvent ae)
    {
	if (ae.getActionCommand ().equals ("Quit"))
	    //when the quit button is hit, exit the program
	    System.exit (0); //exiting the program
	if (ae.getActionCommand ().equals ("Get Alignment"))
	    //when the user chooses to get the alignment, the alignment is retrieved
	    getAlignmentA ();
	if (ae.getActionCommand ().equals ("Get Hgap"))
	    //when the user chooses to get the Hgap, the Hgap is retrieved
	    getHgapA ();
	if (ae.getActionCommand ().equals ("Get Vgap"))
	    //when the user chooses to get the Vgap, the Vgap is retrieved
	    getVgapA ();
	if (ae.getActionCommand ().equals ("Cycle Through Different Alignments"))
	    //when the user chooses to set the allignment
	    setAlignmentA ();
	if (ae.getActionCommand ().equals ("Set Hgap x2"))
	    //when the user chooses to set the HGap
	    setHgapA ();
	if (ae.getActionCommand ().equals ("Set Vgap x2"))
	    //when the user chooses to set the Vgap
	    setVgapA ();
	if (ae.getActionCommand ().equals ("Move Button 10 Pixels Right"))
	    //when the user chooses to move a button 10 pixels right
	    moveButton10PixelsRight ();
	if (ae.getActionCommand ().equals ("Grow Button By 10 Pixels Vertically"))
	    //when the user chooses to grow the button by 10 pixels vertically
	    growButton10PixelsVertically ();
    }


    //getting information of something that is on the flow layout screen
    public void getAlignmentA ()
    {
	d = new JDialog (this, "Alignment"); //making a new dialog box to display the information
	d.setSize (200, 100); //setting the size of the dialog box
	d.setResizable (false); //not allowing the dialog box to be resized

	if (flow.getAlignment () == FlowLayout.LEFT)
	    //figuring out which allignment FlowLayout is currently set to and setting that to be the text of a button
	    button = new JButton ("Left");
	else if (flow.getAlignment () == FlowLayout.RIGHT)
	    button = new JButton ("Right");
	else if (flow.getAlignment () == FlowLayout.CENTER)
	    button = new JButton ("Centre");
	else if (flow.getAlignment () == FlowLayout.LEADING)
	    button = new JButton ("Leading");
	else
	    button = new JButton ("Trailing");

	button.addActionListener (new ActionListener ()
	{ //adding an action listener for the button
	    public void actionPerformed (ActionEvent ae)
	    { //closing the dialog box when the button is clicked
		d.dispose ();
	    }
	}
	);
	d.getContentPane ().add (button); //adding the button to the JDialog box
	d.setLocationRelativeTo (this); //setting the location of the dialog box to the middle of the JFrame screen
	d.show (); //showing the dialog box
    }


    //getting information of something that is on the flow layout screen
    public void getHgapA ()
    {
	d = new JDialog (this, "Hgap"); //making a new dialog box to display the information
	d.setSize (200, 100); //setting the size of the dialog box
	d.setResizable (false); //not allowing the dialog box to be resized
	button = new JButton (String.valueOf (flow.getHgap ())); //displaying the string value of the the hgap
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
    public void getVgapA ()
    {
	d = new JDialog (this, "Vgap");
	d.setSize (200, 100);                                        //setting the size of the dialog box
	d.setResizable (false); //not allowing the dialog box to be resized
	button = new JButton (String.valueOf (flow.getVgap ())); //displaying the string value of the the vgap
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
    public void setAlignmentA ()
    {
	if (flow.getAlignment () == FlowLayout.LEFT)
	    //changing the flow layout allignment to be the next one in the list
	    flow.setAlignment (FlowLayout.RIGHT);
	else if (flow.getAlignment () == FlowLayout.RIGHT)
	    flow.setAlignment (FlowLayout.CENTER);
	else if (flow.getAlignment () == FlowLayout.CENTER)
	    flow.setAlignment (FlowLayout.LEADING);
	else if (flow.getAlignment () == FlowLayout.LEADING)
	    flow.setAlignment (FlowLayout.TRAILING);
	else
	    flow.setAlignment (FlowLayout.LEFT);
	card2.revalidate (); //refreshing the JPanel
    }


    //setting the Hgap on card2
    public void setHgapA ()
    {
	flow.setHgap (flow.getHgap () * 2);
	card2.revalidate (); //refreshing the JPanel
    }


    //setting the Vgap on card2
    public void setVgapA ()
    {
	flow.setVgap (flow.getVgap () * 2);
	card2.revalidate (); //refreshing the JPanel
    }


    //growing button2 on the absolute screen 10 pixels vertically
    /*Variable Dictionary:
    size-to store the size of the button
    */
    public void growButton10PixelsVertically ()
    {
	Dimension size = button2.getSize (); //creating a Dimension to
	button2.setSize (size.width, size.height + 10); //growing the button by 10 pixels
	card1.revalidate (); //refreshing the JPanel
    }


    //moving button1 on the absolute screen 10 pixels to the right
    /*Variable Dictionary:
    location-to store the location of the button
    */
    public void moveButton10PixelsRight ()
    {
	Point location = button1.getLocation (); //creating a Point to store the location of the button currently
	button1.setLocation (location.x + 10, location.y); //moving the button 10 pixels right
	card1.revalidate (); //refreshing the JPanel
    }


    public void itemStateChanged (ItemEvent evt)
    { //when a comboBox item is selected
	CardLayout cardLayout = (CardLayout) (cards.getLayout ()); //making a new instance of CardLayout that is equal to the CardLayout version of the JPanel cards
	cardLayout.show (cards, (String) evt.getItem ()); //showing the card of the item that was selected
    }
}
