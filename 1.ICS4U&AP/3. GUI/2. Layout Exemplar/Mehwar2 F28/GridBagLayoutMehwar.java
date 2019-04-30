/* About GridBagLayout:
 * GridBagLayout is essentially a layout that mimics a grid, but the actual
 * cells are very flexible like a bag as opposed to a box (which is more like
 * GridLayout).
 * 
 * GridBagLayout is very powerful and great as a general use layout. It can also
 * be used for things that need proper alligning (e.g. calendars). Moreover, it is
 * a great layout for moving components as components can be moved from one cell to
 * another efficiently.
 * 
 * A caution of usint this layout would be to make sure a new constraints object is
 * always used for each component. Although this may take up more memory, it is crucial
 * to make sure all values are reset to default before constraining a new component because
 * previous constraints can return abnormal behaviour later on once the program becomes
 * more complex.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Mehwar Raza
 * @version 1.0, Feb. 26, 2012
 * <p>
 * This class demos the GridBagLayout and various functions that it can
 * perform on components.
 * </p>
 */
public class GridBagLayoutMehwar extends JPanel implements ActionListener
{
  /**
   * The contrainsts variable to inherit the return of private class methods.
   */
  GridBagConstraints constraints;
  
  /**
   * The information for the information dialogue.
   */
  final String INFO = "The following is a list of buttons and how they achieve their behaviour:\n\n\tThe height and width buttons use internal padding.\n\tThe vertical and horizontal padding buttons move via external padding.\n\tThe button that moves left to right jumps from the first horizontal cell to the second.\n\tThe extend/collapse button extends to take up 2 column space and then collapses to 1 column in a certain sequence.\n\tThe information button launches this dialog.";
  
  /**
   * The button that controls height functions.
   */
  JButton height;
  
  /**
   * Width function button.
   */
  JButton width;
  
  /**
   * Vertical padding button.
   */
  JButton verticalPadding;
  
  /**
   * Horizontal padding button.
   */
  JButton horizontalPadding;
  
  /**
   * The button that moves from one cell to another
   */
  JButton moveCell;
  
  /**
   * Expanding and collapsing button.
   */
  JButton stretch;
  
  /**
   * Information button.
   */
  JButton information;
  
  /**
   * Refreshes the panel by calling repaint() and revalidate().
   */
  public void refresh(){
    repaint();
    revalidate();
  }
  
  /**
   * Increases the height of the height button and renames it to "Decrease Height".
   */
  public void increaseHeight (){
    
    remove(height);
    height.setText("Decrease Height");
    
    constraints = ConstraintsCreation.createHeightConstraints();
    constraints.ipady=40;
    
    add(height,constraints);
    refresh();
  }
  
  /**
   * Decreases the height of the height butotn and renames it to "Increase Height".
   */
  public void decreaseHeight (){
    
    remove(height);
    height.setText("Increase Height");
    
    constraints = ConstraintsCreation.createHeightConstraints();
    
    add(height,constraints);
    refresh();
  }
  
  /**
   * Increases the width of the width button and renames button accordingly.
   */
  public void increaseWidth (){
    
    remove(width);
    width.setText("Decrease Width");
    
    constraints = ConstraintsCreation.createWidthConstraints();
    constraints.ipadx=150;
    
    add(width,constraints);
    refresh();
  }
  
  /**
   * Decreases the width of the width button and renames button accordingly.
   */
  public void decreaseWidth(){
    
    remove(width);
    width.setText("Increase Width");
    
    constraints = ConstraintsCreation.createWidthConstraints();
    
    add(width,constraints);
    refresh();
  }
  
  /**
   * Increases padding to the north of the vertical padding button.
   */
  public void increaseVerticalPadding (){
    
    remove(verticalPadding);
    verticalPadding.setText("Decrease Vertical Padding");
    
    constraints = ConstraintsCreation.createVerticalPaddingConstraints();
    constraints.insets=new Insets(50,0,0,0);
    
    add(verticalPadding,constraints);
    refresh();
  }
  
  /**
   * Removes padding to the north of the vertical padding button.
   */
  public void decreaseVerticalPadding(){
    
    remove(verticalPadding);
    verticalPadding.setText("Increase Vertical Padding");
    
    constraints = ConstraintsCreation.createVerticalPaddingConstraints();
    
    add(verticalPadding,constraints);
    refresh();
  }
  
  /**
   * Adds padding to the west of the horizontal padding button.
   */
  public void increaseHorizontalPadding (){
    
    remove(horizontalPadding);
    horizontalPadding.setText("Decrease Horizontal Padding");
    
    constraints = ConstraintsCreation.createHorizontalPaddingConstraints();
    constraints.insets=new Insets(0,50,0,0);
    
    add(horizontalPadding,constraints);
    refresh();
  }
  
  /**
   * Removes padding to the west of the horizontal padding button.
   */
  public void decreaseHorizontalPadding(){
    
    remove(horizontalPadding);
    horizontalPadding.setText("Increase Horizontal Padding");
    
    constraints = ConstraintsCreation.createHorizontalPaddingConstraints();
    
    add(horizontalPadding,constraints);
    refresh();
  }
  
  /**
   * Moves the moving button to the right.
   */
  public void moveRight (){
    
    remove(moveCell);
    moveCell.setText("Move Left");
    
    constraints = ConstraintsCreation.createMoveCellConstraints();
    constraints.gridx = 1;
    
    add(moveCell,constraints);
    refresh();
  }
  
  /**
   * Moves the moving button to the left.
   */
  public void moveLeft(){
    
    remove(moveCell);
    moveCell.setText("Move Right");
    
    constraints = ConstraintsCreation.createMoveCellConstraints();
    
    add(moveCell,constraints);
    refresh();
  }
  
  /**
   * Extends the stretch button to the right.
   */
  public void extendRight (){
    
    remove(stretch);
    stretch.setText("Collapse Left");
    
    constraints = ConstraintsCreation.createStretchConstraints();
    constraints.gridwidth = 2;
    
    add(stretch,constraints);
    refresh();
  }
  
  /**
   * Extends the stretch button to the left.
   */
  public void extendLeft(){
    
    remove(stretch);
    stretch.setText("Collapse Right");
    
    constraints = ConstraintsCreation.createStretchConstraints();
    constraints.gridwidth = 2;
    add(stretch,constraints);
    refresh();
  }
  
  /**
   * Collapses the right of the stretch button.
   */
  public void collapseRight (){
    
    remove(stretch);
    stretch.setText("Extend Right");
    
    constraints = ConstraintsCreation.createStretchConstraints();
    constraints.gridwidth = 1;
    
    add(stretch,constraints);
    refresh();
  }
  
  /**
   * Collapses the left of the stretch button.
   */
  public void collapseLeft(){
    
    remove(stretch);
    stretch.setText("Extend Left");
    
    constraints = ConstraintsCreation.createStretchConstraints();
    constraints.gridwidth = 2;
    constraints.gridx = 1;
    
    add(stretch,constraints);
    refresh();
  }
  
  /**
   * This is the contructor. It adds all the buttons to the panel along
   * with the appropriate initial constraints. It also adds action listeners
   * to all buttons.
   */
  public GridBagLayoutMehwar ()
  {
    super (new GridBagLayout());
    
    
    height = new JButton("Increase Height");
    height.addActionListener(this);
    constraints = ConstraintsCreation.createHeightConstraints();
    add(height, constraints);
    
    width = new JButton ("Increase Width");
    width.addActionListener(this);
    constraints = ConstraintsCreation.createWidthConstraints();
    add(width, constraints);
    
    verticalPadding = new JButton ("Increase Vertical Padding");
    verticalPadding.addActionListener(this);
    constraints = ConstraintsCreation.createVerticalPaddingConstraints();
    add(verticalPadding, constraints);
    
    horizontalPadding = new JButton ("Increase Horizontal Padding");
    horizontalPadding.addActionListener(this);
    constraints = ConstraintsCreation.createHorizontalPaddingConstraints();
    add(horizontalPadding, constraints);
    
    moveCell = new JButton ("Move Right");
    moveCell.addActionListener(this);
    constraints = ConstraintsCreation.createMoveCellConstraints();
    add(moveCell, constraints);
    
    stretch = new JButton ("Extend Right");
    stretch.addActionListener(this);
    constraints = ConstraintsCreation.createStretchConstraints();
    add(stretch, constraints);
    
    information = new JButton ("Component Information");
    information.addActionListener(this);
    constraints = ConstraintsCreation.createInformationConstraints();
    add(information, constraints);
    
  }
  
  /**
   * Overrides the method in the ActionListener Interface.
   * It calls various methods in response to different button
   * clicks.
   * <pre>
   * Variable Name    Type             Description
   * e                ActionEvent      Captures event data and passes it to the method.
   * </pre>
   */
  public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equals("Increase Height")){
      increaseHeight();
    } 
    else if (e.getActionCommand().equals("Decrease Height")){
      decreaseHeight();
    }
    else if(e.getActionCommand().equals("Increase Width")){
      increaseWidth();
    } 
    else if (e.getActionCommand().equals("Decrease Width")){
      decreaseWidth();
    }
    else if(e.getActionCommand().equals("Increase Vertical Padding")){
      increaseVerticalPadding();
    } 
    else if (e.getActionCommand().equals("Decrease Vertical Padding")){
      decreaseVerticalPadding();
    }
    else if(e.getActionCommand().equals("Increase Horizontal Padding")){
      increaseHorizontalPadding();
    } 
    else if (e.getActionCommand().equals("Decrease Horizontal Padding")){
      decreaseHorizontalPadding();
    }
    else if(e.getActionCommand().equals("Move Right")){
      moveRight();
    } 
    else if (e.getActionCommand().equals("Move Left")){
      moveLeft();
    }
    else if(e.getActionCommand().equals("Extend Right")){
      extendRight();
    } 
    else if (e.getActionCommand().equals("Extend Left")){
      extendLeft();
    }
    else if(e.getActionCommand().equals("Collapse Right")){
      collapseRight();
    } 
    else if (e.getActionCommand().equals("Collapse Left")){
      collapseLeft();
    }
    else{
      if (e.getActionCommand().equals("Component Information")){
        JOptionPane.showMessageDialog(this, INFO , "Component Information", JOptionPane.INFORMATION_MESSAGE );
      }
    }
  }
  
  /**
   * @author Mehwar Raza
   * @version 1.0, Feb. 26, 2012
   * <p>
   * This is a static class used to instantiate the bare minimum of
   * every constraints object within the use of this program. Its 
   * core purpose serves simplicity.
   * </p>
   */
  private static class ConstraintsCreation
  {
    /**
     * Constraints creation for the height button.
     */
    public static GridBagConstraints createHeightConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.ipady=0;
      c.ipadx=0;
      c.weighty = 1.0;   
      c.anchor = GridBagConstraints.PAGE_START; 
      c.gridx = 0;       
      c.gridwidth = 2;   
      c.gridy = 0;       
      return c;
      
    }
    
    /**
     * Constraints creation for the width button.
     */
    public static GridBagConstraints createWidthConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.ipady=0;
      c.ipadx=0;
      c.weighty = 1.0;   
      c.gridx = 0;       
      c.gridwidth = 2;   
      c.gridy = 1;       
      return c;
      
    }
    
    /**
     * Constraints creation for the vertical padding button.
     */
    public static GridBagConstraints createVerticalPaddingConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.ipady=0;
      c.ipadx=0;
      c.insets = new Insets(0,0,0,0);  
      c.gridx = 0;      
      c.gridwidth = 1;   
      c.gridy = 2;     
      return c;
      
    }
    
    /**
     * Constraints creation for the horizontal padding button.
     */
    public static GridBagConstraints createHorizontalPaddingConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.ipady=0;
      c.ipadx=0;
      c.weighty = 1.0;   
      c.insets = new Insets(0,0,0,0);  
      c.gridx = 1;       
      c.gridwidth = 1;   
      c.gridy = 2;       
      return c;
      
    }
    
    /**
     * Constraints creation for the move cell button.
     */
    public static GridBagConstraints createMoveCellConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.ipady=0;
      c.ipadx=0;
      c.insets = new Insets(0,0,0,0);  
      c.gridx = 0;       
      c.gridwidth = 1;   
      c.gridy = 3;       
      return c;
    }
    
    /**
     * Constraints creation for the expand/collapse button.
     */
    public static GridBagConstraints createStretchConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;
      c.ipady=0;
      c.ipadx=0;
      c.insets = new Insets(0,0,0,0);  
      c.gridx = 0;       
      c.gridwidth = 1;   
      c.gridy = 4;       
      return c;
      
    }
    
    /**
     * Constraints creation for the information button.
     */
    public static GridBagConstraints createInformationConstraints(){
      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.BOTH;
      c.ipady=0;
      c.ipadx=0;
      c.weighty = 1.0;   
      c.anchor = GridBagConstraints.PAGE_END;
      c.gridx = 0;       
      c.gridwidth = 2;   
      c.gridy = 5;       
      return c;
    }
    
  }
  
} 
