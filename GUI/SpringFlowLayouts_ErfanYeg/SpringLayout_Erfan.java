

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program creates a demonstration of a SpringLayout using the SpringFlowLayoutMain_Erfan class as a driver class
 * This program has 4 buttons that can be used to munipulate the
 * @author Erfan Yeganehfar
 * @version 1.0, March 28, 2019
 */

public class SpringLayout_Erfan extends JPanel implements ActionListener{

    JFrame mainFrame = SpringFlowLayoutMain_Erfan.mainFrame;
    Container container = mainFrame.getContentPane();
    SpringLayout layout = new SpringLayout();
    private JLabel center;
    private int vDisplace;
    private int hDisplace;
    private JLabel outputField;

    /**
     * Adds all the buttons to the JFrame and puts constraints
     * on all components.
     */
    public SpringLayout_Erfan(int verticalLocation, int horizontalLocation)
    {
        JButton moveRight;
        JButton moveDown;
        JButton moveLeft;
        JButton moveUp;
        container.setLayout(layout);
        vDisplace = verticalLocation;
        hDisplace = horizontalLocation;

        center = new JLabel("Center");
        moveRight = new JButton("Move Right");
        moveDown = new JButton("Move Down");
        moveLeft = new JButton("Move Left");
        moveUp = new JButton("Move Up");
        JButton quitBtn = new JButton("Home");
        layout.putConstraint(SpringLayout.WEST, quitBtn, 5, SpringLayout.WEST, mainFrame);
        layout.putConstraint(SpringLayout.NORTH, quitBtn, 40, SpringLayout.NORTH, mainFrame);

        mainFrame.add(center);
        mainFrame.add(moveRight);
        mainFrame.add(moveDown);
        mainFrame.add(moveLeft);
        mainFrame.add(moveUp);
        mainFrame.add(quitBtn);

        moveRight.addActionListener(this);
        moveDown.addActionListener(this);
        moveLeft.addActionListener(this);
        moveUp.addActionListener(this);
        quitBtn.addActionListener(this);

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
        mainFrame.add(outputField);

        mainFrame.pack();
        mainFrame.setSize (700,500);
        mainFrame.setVisible(true);


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
     * updates the location of the buttons by repacking them a reevaluating and repainting the JFrame
     */
    public void updateDisplacementMagnet(){
        layout.putConstraint(SpringLayout.WEST,center, hDisplace, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH,center,vDisplace,SpringLayout.NORTH,this);
        mainFrame.pack();
        mainFrame.repaint();
        mainFrame.revalidate();
        mainFrame.setSize (700,500);
    }

    /**
     * Captures action data and pushes/pulls a button accordingly.
     */
    public void actionPerformed(ActionEvent e){
        if  (e.getActionCommand ().equals ("Home")){
            container.removeAll();
            SpringFlowLayoutMain_Erfan.newFrame();
        }
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
