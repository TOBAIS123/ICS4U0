import javax.swing.*;
import java.awt.*;

public class FlowDemo {

    public FlowDemo() {
        JFrame frame = new JFrame("Flow Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.add(new JButton("A"));
        frame.add(new JButton("B"));
        frame.add(new JButton("C"));
        frame.add(new JButton("D"));
        frame.add(new JButton("E"));
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new FlowDemo();
    }
}

