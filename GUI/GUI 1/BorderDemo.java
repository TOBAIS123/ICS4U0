import javax.swing.*;
import java.awt.*;

public class BorderDemo {

    public BorderDemo() {
        JFrame frame = new JFrame("Border Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());
        frame.add(new JButton("Center"),BorderLayout.CENTER);
        frame.add(new JButton("West"),BorderLayout.WEST);
        frame.add(new JButton("East"),BorderLayout.EAST);
        frame.add(new JButton("North"),BorderLayout.NORTH);
        frame.add(new JButton("South"),BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new BorderDemo();
    }
}

