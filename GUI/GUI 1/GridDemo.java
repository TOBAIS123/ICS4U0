import javax.swing.*;
import java.awt.*;

public class GridDemo {

    public GridDemo() {
        JFrame frame = new JFrame("Flow Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,100);
        frame.setLayout(new GridLayout(3,2));
        frame.add(new JButton("A"));
        frame.add(new JButton("B"));
        frame.add(new JButton("C"));
        frame.add(new JButton("D"));
        frame.add(new JButton("E"));
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GridDemo();
    }
}

