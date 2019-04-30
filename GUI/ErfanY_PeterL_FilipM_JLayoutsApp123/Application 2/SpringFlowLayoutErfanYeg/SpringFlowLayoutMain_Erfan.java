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

    private JPanel sl = new SpringLayoutErfan(120,300);
    private JPanel fl = new FlowLayoutErfan();

    public SpringFlowLayoutMain_Erfan(){
        super("SpringLayout and FlowLayout");
        setContentPane(sl);

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

        setJMenuBar(mainMenu);
        quitItem.addActionListener(this);
        springLayoutItem.addActionListener(this);
        flowLayoutItem.addActionListener(this);

       setSize (700,500);
        setVisible (true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void displaySpringLayout() {
        setContentPane(sl);
    }

    public void displayFlowLayout() {
        setContentPane(fl);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Quit")) {
            dispose();
            System.exit(0);
        } else if (ae.getActionCommand().equals("SpringLayout")) {
            displaySpringLayout();
        } else if (ae.getActionCommand().equals("FlowLayout")) {
            displayFlowLayout();
        }
        update();
        setVisible(true);
    }

    public void update(){
        repaint();
        revalidate();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SpringFlowLayoutMain_Erfan();
            }
        });
    }
}
