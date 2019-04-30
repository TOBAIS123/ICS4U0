import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This class demonstrates the different ways that GridBagLayout and GroupLayout
 * can be used by switching the two layouts within a JMenu.
 * 
 * @author Peter Lin
 * @version 1.0, 03/28/19
 * @see GridBagLayoutPeterLin
 * @see GroupLayoutPeterLin
 */

public class LayoutTestApp extends JFrame implements ActionListener{
	private JPanel gridBagLayout = new GridBagLayoutPeterLin();
	private JPanel groupLayout = new GroupLayoutPeterLin();
	public LayoutTestApp(){
		super("Layout Test");
		setContentPane(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		JMenu layoutMenu = new JMenu("Layout");

		JMenuItem gridBagLayoutItem = new JMenuItem("GridBag");
		JMenuItem groupLayoutItem = new JMenuItem("Group");
		JMenuItem quitItem = new JMenuItem("Quit");

		gridBagLayoutItem.addActionListener(this);
		groupLayoutItem.addActionListener(this);
		quitItem.addActionListener(this);

		layoutMenu.add(gridBagLayoutItem);
		layoutMenu.add(groupLayoutItem);
		layoutMenu.add(quitItem);

		menuBar.add(layoutMenu);
		setJMenuBar(menuBar);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new LayoutTestApp();
			}
		});
	}
	public void update(){
		repaint();
		revalidate();
	}

	public void actionPerformed (ActionEvent ae){
		switch (ae.getActionCommand()){
			case "GridBag":
				setContentPane(gridBagLayout);
				break;
			case "Group":
				setContentPane(groupLayout);
				break;
			case "Quit":
				dispose();
				System.exit(0);
		}
		update();
		setVisible(true);
	}
}
				
