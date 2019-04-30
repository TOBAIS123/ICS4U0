import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Erfan Yeganehfar
 * Date: Feb 7,2019
 * Ms.Krasteva
 * This program changes the background colour of a JFame window when the On and Off buttons are pressed
 */
class ErfanYeg_OnOFF implements ActionListener {
    JButton onButton = new JButton("On");//the on button
    JButton offButton = new JButton("Off");//the off button
    JFrame frame = new JFrame("On And Off"); //the main JFrame

    /**
     * public constructor that sets up the JFrame events and ActionListeners
     */
    public ErfanYeg_OnOFF() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        onButton.addActionListener(this);
        offButton.addActionListener(this);
        frame.setLayout(new FlowLayout());
        frame.add(onButton);
        frame.add(offButton);
        frame.setSize(200,100);
        frame.setVisible(true);
    }

    /**
     * Turns the background either white or black, based off of the button
     * @param e the ActionListener even that happens for each individual button
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == onButton){
            frame.getContentPane().setBackground(Color.white);
        }else if (e.getSource() == offButton){
            frame.getContentPane().setBackground(Color.black);
        }else{
            frame.getContentPane().setBackground(Color.white);
        }
    }

    /**
     * The main program that controls the main program
     * @param args Unsigned
     */
    public static void main(String[] args) {
        new ErfanYeg_OnOFF();
    }
}
