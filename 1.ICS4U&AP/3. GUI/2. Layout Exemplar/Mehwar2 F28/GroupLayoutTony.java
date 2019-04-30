/**
 * Description of GroupLayout: GroupLayout separates the layout into a vertical group and a horizontal group. Each group can either be sequential or parallel.
 * Sequential means that the components of the group can't be at the same location, they are by default placed in sequence, one after the other.
 * Parallel means that the components can be at the same location. You can have a parallel group inside a sequential group and vice versa.
 *
 * Uses of GroupLayout: GroupLayout was created for GUI builders but manual coders can use it too.
 * With different combinations of parallel and sequential groups, the programmer can create some advanced layouts.
 *
 * Limits/Cautions to GroupLayout: Be sure at least one of the groups (Horizontal, Vertical) is a sequential group or the components will stack on each other and only one component will be visible.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * @author Tony Ngo
 * @version 1.0 Feb 03, 2012
 * This demonstrates the uses of the LayoutManager GroupLayout in java such as rearranging components in horizontal/vertical groups. It extends JPanel and implements the ActionListener interface.
 * <p>
 * <pre>
 * Variable Name            Variable Type        Description
 * gLayout                  GroupLayout          The LayoutManager for this object
 * button4                  JButton              Button for changing the horizontal group from sequential to parallel and back. Its name changes as well.
 * button5                  JButton              Button for changing the vertical group from parallel to sequential and back. Its name changes as well.
 * button6                  JButton              Button that will be replaced by a JTextField when you click on it.
 * button7                  JButton              Allows you to turn the JTextField back into a button
 * textField1               JTextField           Textfield that replaces a button when the button is clicked, says "Hello"
 * componentReplaceable     JComponent           Stores the current shown object (between the button and textfield)
 * </pre>
 */
public class GroupLayoutTony extends JPanel implements ActionListener
{
    JComponent componentReplaceable;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JTextField textField1;
    GroupLayout gLayout;

    /**
     * This method is the constructor, it builds the JPanel, components, and groups and adds them to the JPanel. It also adds ActionListeners to some of the components.
     */
    public GroupLayoutTony ()
    {
 gLayout = new GroupLayout (this);
 setLayout (gLayout);
 gLayout.setAutoCreateGaps (true);

 button4 = new JButton ("Make Parallel Horizontal");
 button5 = new JButton ("Make Sequential Vertical");
 button6 = new JButton ("Replace me");
 button7 = new JButton ("Undo textfield");
 textField1 = new JTextField ("Hello");
 
 componentReplaceable = button6;
 
 gLayout.setHorizontalGroup (gLayout.createSequentialGroup ().addComponent (button4)
                               .addComponent (button5).addComponent (componentReplaceable).addComponent (button7));
 gLayout.setVerticalGroup (gLayout.createParallelGroup ().addComponent (button4)
                             .addComponent (button5).addComponent (componentReplaceable).addComponent (button7));
 
 button4.addActionListener (this);
 button5.addActionListener (this);
 button6.addActionListener (this);
 button7.addActionListener (this);
 button7.setVisible (false);
    }


    /**
     * @Override
     * This is the override of the actionPerformed method from the ActionListener interface.
     * This method is used here to modify the panel (change the scheme of the groups (parallel/sequential)) when the specific button is pressed.
     * It also renames the buttons.
     * @param e ActionEvent, stores the recently performed ActionEvent object
     */
    public void actionPerformed (ActionEvent e)
    {
 if (e.getActionCommand ().equals ("Make Parallel Horizontal"))
 {
     gLayout.setHorizontalGroup (gLayout.createParallelGroup ().addComponent (button4)
      .addComponent (button5).addComponent (componentReplaceable).addComponent (button7));
     button4.setText ("Make Sequential Horizontal");
 }
 else if (e.getActionCommand ().equals ("Make Sequential Horizontal"))
 {
     gLayout.setHorizontalGroup (gLayout.createSequentialGroup ().addComponent (button4)
      .addComponent (button5).addComponent (componentReplaceable).addComponent (button7));
     button4.setText ("Make Parallel Horizontal");
 }
 else if (e.getActionCommand ().equals ("Make Sequential Vertical"))
 {
     gLayout.setVerticalGroup (gLayout.createSequentialGroup ().addComponent (button4)
      .addComponent (button5).addComponent (componentReplaceable).addComponent (button7));
     button5.setText ("Make Parallel Vertical");
 }
 else if (e.getActionCommand ().equals ("Make Parallel Vertical"))
 {
     gLayout.setVerticalGroup (gLayout.createParallelGroup ().addComponent (button4)
      .addComponent (button5).addComponent (componentReplaceable).addComponent (button7));
     button5.setText ("Make Sequential Vertical");
 }
 else if (e.getActionCommand ().equals ("Replace me"))
 {
     gLayout.replace (button6, textField1);
     componentReplaceable = textField1;
     button7.setVisible (true);
 }
 else
 {
     if (e.getActionCommand ().equals ("Undo textfield"))
     {
  gLayout.replace (textField1, button6);
  componentReplaceable = button6;
  button7.setVisible (false);
     }
 }
 revalidate ();
    }
      /**
   * This methods creates a new object that launches the frame
   * and the rest of the program.
   */
  public static void main (String[] args)
  {
    new GroupLayoutTony ();
  }

} // GroupLayoutDemo class
