import javax.swing.*;
import java.awt.*;
public class FirstExample {
    public FirstExample(){
        JFrame frame = new JFrame("Example 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240,90);
        frame.setLayout(new GridLayout());
        frame.add(new JButton("A"));
        frame.add(new JButton("B"));
        frame.add(new JButton("C"));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FirstExample();
    }
}
