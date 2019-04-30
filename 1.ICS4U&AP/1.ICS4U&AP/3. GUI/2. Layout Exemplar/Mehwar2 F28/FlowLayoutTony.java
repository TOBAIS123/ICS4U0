/**
 * Description of FlowLayout: This is arguably the most simple LayoutManager available in the default Java set.
 * This LayoutManager places components in a sequential fashion in a straight line. 
 * When there is not enough space, the remaining components are wrapped around to the next line.
 * FlowLayout allows the programmer to reverse the component order (putting the last added component on the top left corner).
 * FlowLayout also lets the programmer define the spacing between the components. Horizontal and vertical spacing can be defined separately.
 * 
 * Uses of FlowLayout: Being a simple, easy to learn LayoutManager, FlowLayout can be used for things such as popup/dialog boxes, menus and similar things with few components that don't need a lot of style.
 * 
 * Limits to FlowLayout: FlowLayout does not give the programmer the ability to manually(force) place components on the next row.
 * FlowLayout tends to make components smaller than their PreferredSize, meaning sometimes the programmer can even have components disappearing because they were set to minimum size 0.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * @author Tony Ngo
 * @version 1.0 Feb 03, 2012
 * This demonstrates the uses of the LayoutManager FlowLayout in java such as changing component spacing and order. It extends JPanel and implements the ActionListener interface.
 * <p>
 * <pre>
 * Variable Name            Variable Type        Description
 * layout                   FlowLayout           The LayoutManager for this object
 * button2                  JButton              The button used for spacing, its name changes from "Increase spacing" to "Decrease spacing" and back
 * </pre>
 */
public class FlowLayoutTony extends JPanel implements ActionListener
{
  FlowLayout layout;
  JButton button2;
  /**
   * This method is the constructor, it builds the JPanel and components and adds them to the JPanel. It also adds ActionListeners to some of the components.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * button1                  JButton              The button used to reverse the order of the components.
   * button3                  JButton              A button with no function, for demonstration purposes.
   * </pre>
   */
  public FlowLayoutTony ()
  {
    layout = new FlowLayout (FlowLayout.LEFT);
    setLayout (layout);
    setComponentOrientation (ComponentOrientation.LEFT_TO_RIGHT);
    
    JButton button1 = new JButton ("Reverse button order & location");
    button2 = new JButton ("Increase spacing");
    JButton button3 = new JButton ("button");
    
    add (button1);
    add (button2);
    add (button3);
    
    button1.addActionListener (this);
    button2.addActionListener (this);
  }
  
  /**
   * @Override
   * This is the override of the actionPerformed method from the ActionListener interface.
   * This method is used here to modify the panel (tell panel to increase/decrease spacing and reverse component order) when the specific button is pressed.
   * @param ae ActionEvent, stores the recently performed ActionEvent object
   */
  public void actionPerformed (ActionEvent ae)
  {
    if (ae.getActionCommand ().equals ("Reverse button order & location"))
    {
      changeOrientation ();
      changeAlignment ();
    }
    else if (ae.getActionCommand ().equals ("Increase spacing"))
    {
      button2.setText ("Decrease spacing");
      layout.setHgap (50);
      layout.setVgap (50);
    }
    else
    {
      if (ae.getActionCommand ().equals ("Decrease spacing"))
      {
        button2.setText ("Increase spacing");
        layout.setHgap (5);
        layout.setVgap (5);
      }
    }
    revalidate ();
  }
  
  /**
   * This method puts the components on the other side of the panel (left or right) using getAlignment() and setAlignment().
   */
  private void changeAlignment ()
  {
    
    if (layout.getAlignment () == FlowLayout.LEFT)
    {
      layout.setAlignment (FlowLayout.RIGHT);
    }
    else
    {
      layout.setAlignment (FlowLayout.LEFT);
    }
  }
  
  /**
   * This method reverses the components' order using setComponentOrientation and getComponentOrientation
   */
  private void changeOrientation ()
  {
    if (getComponentOrientation ().equals (ComponentOrientation.LEFT_TO_RIGHT))
    {
      setComponentOrientation (ComponentOrientation.RIGHT_TO_LEFT);
    }
    else
    {
      setComponentOrientation (ComponentOrientation.LEFT_TO_RIGHT);
    }
  }
  
  
  // main method
} // FlowLayoutDemo class


