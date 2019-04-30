import javax.swing.*;
import java.awt.*;
/**
 * @author Erfan Yeganehfar
 * Date: Feb 7,2019
 * Ms.Krasteva
 * This program displays an envelope formatted JFrame where the text is centered
 */
public class ErfanYeg_Envelope {
        /**
        * public constructor that sets up the JFrame events
        */
        public ErfanYeg_Envelope() {
            JFrame frame = new JFrame("Erfan's Envelope");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550,200);
            frame.add(new Drawing());
            frame.setVisible(true);
        }
        /**
        * The main program that controls the main program
        * @param args Unsigned
        */
        public static void main(String[] args) {
            new ErfanYeg_Envelope();
        }

    /**
     * a class that is used to draw (output) the text onto the JFrame, extends JComponent
     */
    class Drawing extends JComponent{
        /**
         * Outputs the text onto the console using the coordinates
         * @param g overrides the paint method in JComponent (the graphics object is used to draw)
         */
            public void paint (Graphics g) {
                Font Serif = new Font("Serif", Font.BOLD,20);
                g.setFont(Serif);
                g.drawString("Erfan, Yeganehfar", 175, 50);
                g.drawString("20, Tillplain Road", 175, 75);
                g.drawString("M3H 5R2", 210, 100);

            }
        }
    }

