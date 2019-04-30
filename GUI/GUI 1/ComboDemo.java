import javax.swing.*;
import java.awt.*;

public class ComboDemo {

    public ComboDemo() {
        JFrame frame = new JFrame("Combo Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setLayout(new GridLayout(2,2));
        frame.add(new JButton("A"));
        JPanel borderPane = new JPanel();
        borderPane.setLayout(new BorderLayout());
        borderPane.add(new JButton("B-North"),BorderLayout.NORTH);
        borderPane.add(new JButton("B-Center"),BorderLayout.CENTER);
        borderPane.add(new JButton("B-West"),BorderLayout.WEST);
        borderPane.add(new JButton("B-East"),BorderLayout.EAST);
        borderPane.add(new JButton("B-South"),BorderLayout.SOUTH);
        frame.add(borderPane);
        JPanel flowPane = new JPanel();
        flowPane.setLayout(new FlowLayout());
        flowPane.add(new JButton("C-1"));
        flowPane.add(new JButton("C-2"));
        flowPane.add(new JButton("C-3"));
        flowPane.add(new JButton("C-4"));
        flowPane.add(new JButton("C-5"));
        flowPane.add(new JButton("C-6"));
        flowPane.add(new JButton("C-7"));
        frame.add(flowPane);
        frame.add(new JButton("D"));
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ComboDemo();
    }
}

