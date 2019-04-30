import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Erfan,Peter,Filip
 * @version 1.0, March 28, 2019
 * This program demonstrates the 2 layouts: FlowLayout and SpringLayout
 * This Program uses a JMenuBar and JMenu Items to access the layouts
 * There are buttons that demonstrate the utilities of each layout
 */
public class SpringFlowLayoutMain_Erfan extends JFrame implements ActionListener{

    static JFrame mainFrame = new JFrame("SpringLayout and FlowLayout");
    JLabel welcomeMessage;

    public SpringFlowLayoutMain_Erfan(){

        mainFrame.setLayout(new BorderLayout()); //This just resets the frame layout

        JMenu exitMenu = new JMenu("Exit");
        JMenu layoutMenu = new JMenu("Layouts");
        JMenuItem quitItem = new JMenuItem("Quit");
        JMenuItem springLayoutItem = new JMenuItem("SpringLayout");
        JMenuItem flowLayoutItem = new JMenuItem("FlowLayout");

        exitMenu.add(quitItem);
        layoutMenu.add(springLayoutItem);
        layoutMenu.add(flowLayoutItem);
        JMenuBar mainMenu = new JMenuBar();
        mainMenu.add(exitMenu);
        mainMenu.add(layoutMenu);

        welcomeMessage = new JLabel("<html><p><center> This Program was made by Erfan Yeganehfar" +
                "Please navigate the menu above to try out the Spring and Flow Layouts</center></p></html>");
        mainFrame.add(welcomeMessage);

        mainFrame.setJMenuBar(mainMenu);
        quitItem.addActionListener(this);
        springLayoutItem.addActionListener(this);
        flowLayoutItem.addActionListener(this);

        mainFrame.setSize (700,500);
        mainFrame.setVisible (true);
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);
    }

    public void displaySpringLayout() {
        mainFrame.remove(welcomeMessage);
        new SpringLayout_Erfan(120,280);
    }

    public void displayFlowLayout() {
        new FlowLayout_Erfan();
    }

    public static void newFrame(){
        mainFrame.getContentPane().removeAll();
        new SpringFlowLayoutMain_Erfan();
    }

    public void actionPerformed(ActionEvent ae) {
        mainFrame.getContentPane().removeAll();
        if (ae.getActionCommand().equals("Quit")) {
            mainFrame.dispose();
        } else if (ae.getActionCommand().equals("SpringLayout")) {
            mainFrame.remove(welcomeMessage);
            displaySpringLayout();
        } else if (ae.getActionCommand().equals("FlowLayout")) {
            mainFrame.remove(welcomeMessage);
            displayFlowLayout();
        }
    }

    public static void main(String[] args) {

        new SpringFlowLayoutMain_Erfan().displaySpringLayout();
    }
}
