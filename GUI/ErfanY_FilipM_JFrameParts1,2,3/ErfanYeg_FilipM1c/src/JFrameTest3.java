import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author Erfan Yeg, Filip M
 * @version 1 03.22.19  
 * Ms.Krasteva
 * The JFrameTest3 class creates the application
 * window, menu bar, File menu and Help menu + the Quit File menu item
 * and the About + Help Help menu item. It then adds the menu items to
 * the File + Help menu and the menus to the menubar.
 */
public class JFrameTest3 extends JFrame implements ActionListener {
	/**
	 * The class constructor passes a String title when it creates the superclass
	 * Object. It then creates the application window, menu bar, File + Help menu,
	 * the Quit File menu item, and the Help and About Help menu items. It then adds
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
	 * <b>aboutItem </b> This creates an instance of the JMenuItem class called "About".
	 * <p>
	 * <b>fileMenu </b> This creates an instance of the JMenu class called "File". 
	 * <p>
	 * <b>myMenus </b> This creates an instance of the JMenuBar class.
	 */
	public JFrameTest3() {
		super("JFrame Test");
		JMenuItem quitItem = new JMenuItem("Quit");
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem aboutItem = new JMenuItem("About");

		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");

		helpMenu.add(helpItem);
		helpMenu.add(aboutItem);
		fileMenu.add(quitItem);

		JMenuBar myMenus = new JMenuBar();

		quitItem.addActionListener(this);
		helpItem.addActionListener(this);
		aboutItem.addActionListener(this);

		myMenus.add(fileMenu);
		myMenus.add(helpMenu);
		setJMenuBar(myMenus);
		TextTest t = new TextTest();
		add(t);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * This method matches an Action Event with available actions to be preformed.
	 * "Quit" disposes of the JFrame "Help" Executes the Help JDialog "About"
	 * Executes the About JDialog
	 * 
	 * @param ae Takes an ActionEvent from ActionListener
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Quit")) {
			dispose();
		} else if (ae.getActionCommand().equals("Help")) {
			helpDialog();
		} else if (ae.getActionCommand().equals("About")) {
			aboutDialog();
		}
	}

	/**
	 * This method creates a JDialog for the menu item "Help" It sets the size to
	 * 100x100 and has a flowlayout with a button that Listens for an Action. On
	 * Action performed, it disposes of the JDialog. There is also a JLabel which
	 * displays the words "HELP" to the user. Location is set to relative (movable)
	 * and visible
	 */
	private void helpDialog() {
		JDialog myDialog = new JDialog(this, "Help Me");
		myDialog.setSize(100, 100);
		myDialog.setResizable(false);
		myDialog.setLayout(new FlowLayout());
		JButton helpButton = new JButton("Close");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDialog.dispose();
			}
		});
		myDialog.add(new JLabel("<html> <b> HELP </b>"));
		myDialog.add(helpButton);
		myDialog.setLocationRelativeTo(this);
		myDialog.setVisible(true);
	}

	/**
	 * This method creates a JDialog for the menu item "About" It sets the size to
	 * 600x300 and has a flowlayout with a button that Listens for an Action. On
	 * Action performed, it disposes of the JDialog. There is also a JLabel which
	 * displays some interesting details about the programmers. Location is set to
	 * relative (movable) and visible
	 */
	private void aboutDialog() {
		JDialog abDialog = new JDialog(this, "About Me");
		abDialog.setSize(600, 300);
		abDialog.setResizable(false);
		abDialog.setLayout(new FlowLayout());
		JButton helpButton = new JButton("Close");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abDialog.dispose();
			}
		});
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new FlowLayout());
		abDialog.add(new JLabel("<html> <p> Filip and Erfan are considered to be very not awesome people <br>"
				+ "by their friends and even strangers <br> Both Filip and Erfan like listening to music on their free time </p> </html>"));
		buttonP.add(helpButton);
		abDialog.add(buttonP);
		abDialog.setLocationRelativeTo(this);
		abDialog.setVisible(true);
	}

}
