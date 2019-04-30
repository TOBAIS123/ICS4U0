import javax.swing.*;
import java.awt.*;
/**
 * @author Erfan Yeganehfar
 * Date: Feb 7,2019
 * Ms.Krasteva
 * This program displays buttons in a certain layout (one at the center top, and threee centered at the bottom)
 */
public class ErfanYeg_LayoutEx3 {
    /**
     * public constructor that sets up the JFrame, its buttons and events
     */
    public ErfanYeg_LayoutEx3() {
        JFrame frame = new JFrame("Ex3 Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new GridLayout(5,1));
        JPanel flowPane1 = new JPanel();
        flowPane1.setLayout(new FlowLayout());
        flowPane1.add(new JButton("top"));
        frame.add(flowPane1);
        frame.add(new JPanel());
        frame.add(new JPanel());
        frame.add(new JPanel());
        JPanel flowPane2 = new JPanel();
        flowPane2.add(new JButton("Yes"));
        flowPane2.add(new JButton("No"));
        flowPane2.add(new JButton("??"));
        frame.add(flowPane2);

        frame.setVisible(true);

    }
    /**
     * The main program that controls the main program
     * @param args Unsigned
     */
    public static void main(String[] args) {
        new ErfanYeg_LayoutEx3();
    }
}

