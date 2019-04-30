import javax.swing.*;
import java.awt.*;
/**
 * @author Erfan Yeganehfar
 * Date: Feb 7,2019
 * Ms.Krasteva
 * This program displays buttons in a certain layout 3 buttons occupying the entire JFrame
 */
public class ErfanYeg_LayoutEx2 {
    /**
     * public constructor that sets up the JFrame, its buttons and events
     */
    public ErfanYeg_LayoutEx2(){
        JFrame frame = new JFrame("Example 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240,90);
        frame.setLayout(new GridLayout());
        frame.add(new JButton("A"));
        frame.add(new JButton("B"));
        frame.add(new JButton("C"));
        frame.setVisible(true);
    }
    /**
     * The main program that controls the main program
     * @param args Unsigned
     */
    public static void main(String[] args) {
        new ErfanYeg_LayoutEx2();
    }
}
