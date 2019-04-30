import javax.swing.*;
import java.awt.*;

public class GUIgreet {
        public GUIgreet() {
            JFrame frame = new JFrame("Graphical Greeting");
            frame.setSize(400,100);
            frame.add(new Drawing());
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            new GUIgreet();
        }
        class Drawing extends JComponent{

            public void paint (Graphics g) {
                g.drawString("Hello World", 150, 50);
            }
        }
    }

