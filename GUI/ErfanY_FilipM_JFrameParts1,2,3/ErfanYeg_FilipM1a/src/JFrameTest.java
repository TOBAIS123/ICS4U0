import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * @author Erfan Yeg, Filip M
 * @version 1 03.22.19  
 * Ms.Krasteva
 * The JFrameTest2 class creates the application
 * window, menu bar, File menu and Help menu + the Quit File menu item
 * and the Help Help menu item. It then adds the menu items to
 * the File + Help menu and the menus to the menubar.
 */

public class JFrameTest extends JFrame implements ActionListener{
    /**
     * The class constructor passes a String title when it creates the superclass
     * Object. It then creates the application window, menu bar, File menu,
     * the Quit File menu item, and the Help and Help menu items. It then adds
     * the menu items to the File and Help menu and the menus to the menubar. It
     * sets the size of the Frame to 400x400, and ensures it will be visible. It
     * also makes sure that the buttons are listening for an event, allowing them to
     * output text to the user. The aboutItem and the helpItem listen for their
     * event to activate so that they can display their respected JDialog
     * <p>
     * <b>Local variables: </b> 
     * <b>quitItem </b> This creates an instance of the JMenuItem class called "Quit". 
     * <p>
     * <b>helpItem </b> This creates an instance of the JMenuItem class called "Help". 
     * <p>
     * <b>helpMenu </b> This creates an instance of the JMenu class called "Help". 
     * <p>
     * <b>fileMenu </b> This creates an instance of the JMenu class called "File". 
     * <p>
     * <b>myMenus </b> This creates an instance of the JMenuBar class.
     */
    public JFrameTest() {
        super ("JFrame Test");

        JMenuItem quitItem = new JMenuItem ("Quit");
        JMenuItem helpItem = new JMenuItem ("Help");

        JMenu fileMenu = new JMenu ("File");
        JMenu helpMenu = new JMenu ("Help");

        helpMenu.add (helpItem);
        fileMenu.add (quitItem);

        JMenuBar myMenus = new JMenuBar ();

        quitItem.addActionListener(this);

        myMenus.add (fileMenu);
        myMenus.add (helpMenu);
        setJMenuBar (myMenus);
        setSize (400, 400);
        setVisible (true);

        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);  
    }

    /**
     * This method matches an Action Event with available actions to be performed.
     * "Quit" disposes of the JFrame 
     * @param ae Takes an ActionEvent from ActionListener
     */
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getActionCommand().equals("Quit"))
        {
            dispose();
        }
    }

}
