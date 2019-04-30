/* About SpringLayout:
 * SpringLayout is a layout that orders components relative to one another according
 * to the various springs attached to the edges of components.
 * 
 * SpringLayout is a great tool to use for precise placements of components as springs
 * can be extended or retracted by the pixel. This is great for stuff like text art (with
 * the use of JLabels). Furthermore, if there is dynamic resizing of components inside a
 * panel, SpringLayout is great for keeping various components at a relative distance to
 * each other. An example of this would be a high scores list. If one name is very long, it
 * may cut into a score when using another layout, but spring layout will push the score
 * in porportion to the size of the name.
 * 
 * A very dangerous caution of SpringLayout is the manual placement of initial components.
 * Basically, SpringLayout does not actively make room for added components automatically,
 * everything has to be done by the programmer. This makes coding SpringLayout a headache
 * because everything needs to be taken accounted for using relative measures. After personal
 * use, I wouldn't recommend anyone with a low understanding of 2D spatial sense to code a
 * SpringLayout from scratch.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Mehwar Raza
 * @version 1.0, Feb. 26, 2012
 * <p>
 * This class demos the SpringLayout via many different functions executed on
 * to components on a panel.
 * </p>
 */
public class SpringLayoutMehwar extends JPanel implements ActionListener
{
  /**
   * The only layout used for all modifications.
   */
  SpringLayout layout;
  
  /**
   * This is the button that pushes the magnet right.
   */
  JButton pushRight;
  
  /**
   * This is the button that pushes the magnet down.
   */
  JButton pushDown;
  
  /**
   * This is the button that pushes the magnet left.
   */
  JButton pushLeft;
  
  /**
   * This is the button that pushes the magnet up.
   */
  JButton pushUp;
  
  /**
   * This is the button that pulls the magnet up and to the right.
   */
  JButton pullUpRight;
  
  /**
   * This is the button that pulls the magnet up and to the left.
   */
  JButton pullUpLeft;
  
  /**
   * This is the button that pulls the magnet down and to the right.
   */
  JButton pullDownRight;
  
  /**
   * This is the button that pulls the magnet down and to the left.
   */
  JButton pullDownLeft;
  
  /**
   * This is the first magnet.
   */
  JLabel magnet1;
  
  /**
   * This is the second magnet.
   */
  JLabel magnet2;
  
  /**
   * This is the vertical displacement for the first magnet.
   */
  public int verticalDisplacement1;
  
  /**
   * Horizontal displacement for magnet 1.
   */
  public int horizontalDisplacement1;
  
  /**
   * Vertical displacement for magnet 2.
   */
  public int verticalDisplacement2;
  
  /**
   * Horizontal displacement for magnet 2.
   */
  public int horizontalDisplacement2;
  
  /**
   * <p>
   * This method refreshes the panel by calling repaint() and revalidate().
   * </p>
   */
  public void refresh(){
    repaint();
    revalidate();
  }
  
  /**
   * <p>
   * Pushes the push right button.
   * </p>
   */
  public void pushRight(){
    horizontalDisplacement1+=10;
    updateDisplacementMagnet1();
  }
  
  /**
   * <p>
   * Pushes the push left button.
   * </p>
   */
  public void pushLeft(){
    horizontalDisplacement1-=10;
    updateDisplacementMagnet1();
  }
  
  /**
   * <p>
   * Pushes the push up button.
   * </p>
   */
  public void pushUp(){
    verticalDisplacement1-=10;
    updateDisplacementMagnet1();
  }
  
  /**
   * <p>
   * Pushes the push down button.
   * </p>
   */
  public void pushDown(){
    verticalDisplacement1+=10;
    updateDisplacementMagnet1();
  }
  
  /**
   * <p>
   * Pulls the pull up right button.
   * </p>
   */
  public void pullUpRight(){
    horizontalDisplacement2+=10;
    verticalDisplacement2-=10;
    updateDisplacementMagnet2();
  }
  
  /**
   * <p>
   * Pulls the pull up left button.
   * </p>
   */
  public void pullUpLeft(){
    horizontalDisplacement2-=10;
    verticalDisplacement2-=10;
    updateDisplacementMagnet2();
  }
  
  /**
   * <p>
   * Pulls the pull down right button.
   * </p>
   */
  public void pullDownRight(){
    horizontalDisplacement2+=10;
    verticalDisplacement2+=10;
    updateDisplacementMagnet2();
  }
  
  /**
   * <p>
   * Pulls the pull down left button.
   * </p>
   */
  public void pullDownLeft(){
    horizontalDisplacement2-=10;
    verticalDisplacement2+=10;
    updateDisplacementMagnet2();
  }
  
  /**
   * <p>
   * Updates the displacement for magnet 1.
   * </p>
   */
  public void updateDisplacementMagnet1(){
    layout.putConstraint(SpringLayout.WEST,magnet1, horizontalDisplacement1, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH,magnet1,verticalDisplacement1,SpringLayout.NORTH,this);
    refresh();
  }
  
  /**
   * <p>
   * Updates the displacement for magnet 2.
   * </p>
   */
  public void updateDisplacementMagnet2(){
    layout.putConstraint(SpringLayout.WEST,magnet2, horizontalDisplacement2, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH,magnet2,verticalDisplacement2,SpringLayout.NORTH,this);
    refresh();
  }
  
  /**
   * <p>
   * Adds all magnets and buttons to the panel and puts constraints
   * on all components.
   * </p>
   */
  public SpringLayoutMehwar (int v1, int h1, int v2, int h2)
  {
    super ();
    layout = new SpringLayout();
    setLayout(layout);
    
    verticalDisplacement1 = v1;
    horizontalDisplacement1 = h1;
    verticalDisplacement2 = v2;
    horizontalDisplacement2 = h2;
    
    magnet1 = new JLabel("Center Magnet");
    add(magnet1);
    
    pushRight = new JButton("Push Right");
    pushRight.addActionListener(this);
    add(pushRight);
    
    pushDown = new JButton("Push Down");
    pushDown.addActionListener(this);
    add(pushDown);
    
    pushLeft = new JButton("Push Left");
    pushLeft.addActionListener(this);
    add(pushLeft);
    
    pushUp = new JButton("Push Up");
    pushUp.addActionListener(this);
    add(pushUp);
    
    
    
    layout.putConstraint(SpringLayout.NORTH,magnet1, verticalDisplacement1, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST,magnet1,horizontalDisplacement1,SpringLayout.WEST,this);
    
    layout.putConstraint(SpringLayout.EAST,pushRight, -10, SpringLayout.WEST, magnet1);
    layout.putConstraint(SpringLayout.WEST,pushLeft, 10, SpringLayout.EAST, magnet1);
    layout.putConstraint(SpringLayout.NORTH,pushUp, 10, SpringLayout.SOUTH, magnet1);
    layout.putConstraint(SpringLayout.SOUTH,pushDown, -10, SpringLayout.NORTH, magnet1);
    
    layout.putConstraint(SpringLayout.SOUTH,pushRight, 0, SpringLayout.NORTH, pushUp);
    layout.putConstraint(SpringLayout.SOUTH,pushLeft, 0, SpringLayout.NORTH, pushUp);
    layout.putConstraint(SpringLayout.NORTH,pushRight, 0, SpringLayout.SOUTH, pushDown);
    layout.putConstraint(SpringLayout.NORTH,pushLeft, 0, SpringLayout.SOUTH, pushDown);
    
    layout.putConstraint(SpringLayout.WEST,pushUp, 0, SpringLayout.EAST, pushRight);
    layout.putConstraint(SpringLayout.EAST,pushUp, 0, SpringLayout.WEST, pushLeft);
    layout.putConstraint(SpringLayout.WEST,pushDown, 0, SpringLayout.EAST, pushRight);
    layout.putConstraint(SpringLayout.EAST,pushDown, 0, SpringLayout.WEST, pushLeft);
    
    
    magnet2 = new JLabel("Center Magnet");
    add(magnet2);
    
    pullUpRight = new JButton("Pull Up Right");
    pullUpRight.addActionListener(this);
    add(pullUpRight);
    
    pullUpLeft = new JButton("Pull Up Left");
    pullUpLeft.addActionListener(this);
    add(pullUpLeft);
    
    pullDownRight = new JButton("Pull Down Right");
    pullDownRight.addActionListener(this);
    add(pullDownRight);
    
    pullDownLeft = new JButton("Pull Down Left");
    pullDownLeft.addActionListener(this);
    add(pullDownLeft);
    
    
    
    
    layout.putConstraint(SpringLayout.NORTH,magnet2, verticalDisplacement2, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST,magnet2,horizontalDisplacement2,SpringLayout.WEST,this);
    
    layout.putConstraint(SpringLayout.EAST,pullUpLeft, -10, SpringLayout.WEST, magnet2);
    layout.putConstraint(SpringLayout.WEST,pullUpRight, 10, SpringLayout.EAST, magnet2);
    layout.putConstraint(SpringLayout.EAST,pullDownLeft, -10, SpringLayout.WEST, magnet2);
    layout.putConstraint(SpringLayout.WEST,pullDownRight, 10, SpringLayout.EAST, magnet2);
    
    layout.putConstraint(SpringLayout.SOUTH,pullUpLeft, -10, SpringLayout.NORTH, magnet2);
    layout.putConstraint(SpringLayout.SOUTH,pullUpRight, -10, SpringLayout.NORTH, magnet2);
    layout.putConstraint(SpringLayout.NORTH,pullDownLeft, 10, SpringLayout.SOUTH, magnet2);
    layout.putConstraint(SpringLayout.NORTH,pullDownRight, 10, SpringLayout.SOUTH, magnet2);
    
  }
  
  /**
   * <p>
   * Captures action data and pushes/pulls a button accordingly.
   * </p>
   * <pre>
   * Variable Name  Type     Definition
   * e              ActionEvent  Captures action data and passes it to the method.
   */
  public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equals("Push Right")){
      pushRight();
    } 
    else if (e.getActionCommand().equals("Push Down")){
      pushDown();
    }
    else if (e.getActionCommand().equals("Push Left")){
      pushLeft();
    }
    else if (e.getActionCommand().equals("Push Up")){
      pushUp();
    }
    else if (e.getActionCommand().equals("Pull Up Right")){
      pullUpRight();
    }
    else if (e.getActionCommand().equals("Pull Up Left")){
      pullUpLeft();
    }
    else if (e.getActionCommand().equals("Pull Down Right")){
      pullDownRight();
    }
    else {
      if (e.getActionCommand().equals("Pull Down Left")){
        pullDownLeft();
      }
    }
    
  }
  
} 
