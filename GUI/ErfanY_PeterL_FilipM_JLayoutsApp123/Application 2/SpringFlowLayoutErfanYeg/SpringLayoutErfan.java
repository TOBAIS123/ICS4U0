
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program creates a demonstration of a SpringLayout using a driver class
 * This program has 4 buttons that can be used to manipulate the location of the set, based off of a center JLabel
 * Each button has a direction in which it moves 10px by (down, up, left, and right)
 * and a JLabel mimicking and outputting every move on the JFrame
 * @author Erfan Yeganehfar
 * @version 1.0, March 28, 2019
 */

public class SpringLayoutErfan extends JPanel implements ActionListener{

    SpringLayout layout;
    private JLabel center;
    private int vDisplace;
    private int hDisplace;
    private JLabel outputField;

    /**
     * Adds all the buttons to the JFrame and puts constraints on all components.
     * The direction buttons are used to move the set of buttons based on a central JLabel(up, down, left, and right)
     * with a JLabel mimicking and outputting every move on the JFrame
     */
    public SpringLayoutErfan(int verticalLocation, int horizontalLocation)
    {
        super();
        JButton moveRight;
        JButton moveDown;
        JButton moveLeft;
        JButton moveUp;
        layout = new SpringLayout();
        setLayout(layout);
        vDisplace = verticalLocation;
        hDisplace = horizontalLocation;

        center = new JLabel("Center");
        moveRight = new JButton("Move Right");
        moveDown = new JButton("Move Down");
        moveLeft = new JButton("Move Left");
        moveUp = new JButton("Move Up");

        add(center);
        add(moveRight);
        add(moveDown);
        add(moveLeft);
        add(moveUp);

        moveRight.addActionListener(this);
        moveDown.addActionListener(this);
        moveLeft.addActionListener(this);
        moveUp.addActionListener(this);

        outputField = new JLabel("Directions");
        layout.putConstraint(SpringLayout.WEST, outputField, -80, SpringLayout.EAST, moveDown);
        layout.putConstraint(SpringLayout.NORTH, outputField, -20, SpringLayout.NORTH, moveDown);

        layout.addLayoutComponent("SpringLayout", moveRight);

        layout.putConstraint(SpringLayout.NORTH,center, vDisplace, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST,center,hDisplace,SpringLayout.WEST,this);

        layout.putConstraint(SpringLayout.EAST,moveRight, -10, SpringLayout.WEST, center);
        layout.putConstraint(SpringLayout.WEST,moveLeft, 10, SpringLayout.EAST, center);
        layout.putConstraint(SpringLayout.NORTH,moveUp, 10, SpringLayout.SOUTH, center);
        layout.putConstraint(SpringLayout.SOUTH,moveDown, -10, SpringLayout.NORTH, center);

        layout.putConstraint(SpringLayout.SOUTH,moveRight, 0, SpringLayout.NORTH, moveUp);
        layout.putConstraint(SpringLayout.SOUTH,moveLeft, 0, SpringLayout.NORTH, moveUp);
        layout.putConstraint(SpringLayout.NORTH,moveRight, 0, SpringLayout.SOUTH, moveDown);
        layout.putConstraint(SpringLayout.NORTH,moveLeft, 0, SpringLayout.SOUTH, moveDown);

        layout.putConstraint(SpringLayout.WEST,moveUp, -30, SpringLayout.EAST, moveRight);
        layout.putConstraint(SpringLayout.EAST,moveUp, 20, SpringLayout.WEST, moveLeft);
        layout.putConstraint(SpringLayout.WEST,moveDown, -30, SpringLayout.EAST, moveRight);
        layout.putConstraint(SpringLayout.EAST,moveDown, 20, SpringLayout.WEST, moveLeft);
        add(outputField);
        setVisible(true);
    }

    /**
     * moves the buttons right
     */
    public void pushRight(){
        outputField.setText("Moved Right");
        hDisplace+=10;
        updateDisplacementMagnet();
    }

    /**
     * moves the buttons left
     */
    public void pushLeft(){
        outputField.setText("Moved Left");

        hDisplace-=10;
        updateDisplacementMagnet();
    }

    /**
     * moves the buttons up
     */
    public void pushUp(){
        outputField.setText("Moved Up");
        vDisplace-=10;
        updateDisplacementMagnet();
    }

    /**
     * moves the buttons down
     */
    public void pushDown(){
        outputField.setText("Moved Down");
        vDisplace+=10;
        updateDisplacementMagnet();
    }

    /**
     * Makes sure that after an event is complete,
     * the JPanel revalidate the components and corrects their current position
     */
    private void update(){
        repaint();
        invalidate();
        validate();
        revalidate();
    }

    /**
     * updates the location of the buttons by repacking them a reevaluating and repainting the JFrame
     */
    public void updateDisplacementMagnet(){
        layout.putConstraint(SpringLayout.WEST,center, hDisplace, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH,center,vDisplace,SpringLayout.NORTH,this);
        update();
    }

    /**
     * Captures action data and pushes/pulls a button accordingly.
     */
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Move Right")){
            pushRight();
        }
        else if (e.getActionCommand().equals("Move Down")){
            pushDown();
        }
        else if (e.getActionCommand().equals("Move Left")){
            pushLeft();
        }
        else if (e.getActionCommand().equals("Move Up")){
            pushUp();
        }

    }
}
