import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This class demonstrates the different ways that a GridBagLayout
 * can be laid out using the <code>GridBagConstraints</code> class.
 * 
 * @author Peter Lin
 * @version 1.0, 03/28/19
 * @see LayoutTestApp
 * @see GridBagLayoutPeterLin
 */

public class GridBagLayoutPeterLin extends JPanel implements ActionListener{
	private JButton moveMe = new JButton("Move Me");
	private JButton anchor, inset, padding;
	private GridBagConstraints constraints = new GridBagConstraints();
	private JFrame customizer = new JFrame("Customizer");
	private JPanel customizerPanel = new JPanel();
	static final Insets noGap = new Insets(0, 0, 0, 0);
	static final Insets gap = new Insets(20, 20, 20, 20);
	public GridBagLayoutPeterLin(){
		super(new GridBagLayout());

		JButton moveLeft = new JButton("Move Left");
		JButton moveRight = new JButton("Move Right");
		JButton customize = new JButton("Customize");
		
		JLabel dialogLabel = new JLabel("Customize Settings Here");
		JButton applyButton = new JButton("Apply");
		anchor = new JButton("Remove Anchor");
		inset = new JButton("Increase Inset");
		padding = new JButton("Increase Padding");

		GroupLayout groupLayout = new GroupLayout(customizerPanel);
		customizerPanel.setLayout(groupLayout);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.linkSize(dialogLabel, anchor, inset, padding);

groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(dialogLabel).addGroup(groupLayout.createSequentialGroup().addComponent(inset).addComponent(anchor).addComponent(padding)).addComponent(applyButton));
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(dialogLabel).addGroup(groupLayout.createParallelGroup().addComponent(inset).addComponent(anchor).addComponent(padding)).addComponent(applyButton));
		customizer.setContentPane(customizerPanel);
		customizer.pack();
		customizer.setResizable(false);

		moveLeft.addActionListener(this);
		moveRight.addActionListener(this);
		customize.addActionListener(this);
		applyButton.addActionListener(this);
		anchor.addActionListener(this);
		inset.addActionListener(this);
		padding.addActionListener(this);

		constraints.weighty = 1;
		constraints.gridwidth = 1;
		constraints.gridy = 0;
		constraints.gridx = 0;
		add(moveLeft, constraints);

		constraints.gridx = 1;
		add(customize, constraints);

		constraints.gridx = 2;
		add(moveRight, constraints);

		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weighty = 1;
		constraints.gridy = 4;
		constraints.gridx = 1;
		add(moveMe, constraints);
		setVisible(true);
	}
	@Override
	public void actionPerformed (ActionEvent ae){
		switch (ae.getActionCommand()){
			case "Move Left": goLeft(); break;
			case "Move Right": goRight(); break;
			case "Customize": customize(); break;
			case "Apply": apply(); break;
			case "Add Anchor":
				constraints.anchor = GridBagConstraints.CENTER;
				anchor.setText("Remove Anchor");
				break;
			case "Remove Anchor":
				constraints.anchor = GridBagConstraints.PAGE_START;
				anchor.setText("Add Anchor");
				break;
			case "Increase Inset":
				constraints.insets = gap;
				inset.setText("Decrease Inset");
				break;
			case "Decrease Inset":
				constraints.insets = noGap;
				inset.setText("Increase Inset");
				break;
			case "Increase Padding":
				constraints.ipadx = constraints.ipady = 20;
				padding.setText("Decrease Padding");
				break;
			case "Decrease Padding":
				constraints.ipadx = constraints.ipady = 0;
				padding.setText("Increase Padding");
				break;
		}
		update();
	}
	private void goLeft(){
		if (constraints.gridx > 0){
			remove(moveMe);
			constraints.gridx--;
			add(moveMe, constraints);
		}
	}
	private void goRight(){
		if (constraints.gridx < 2){
			remove(moveMe);
			constraints.gridx++;
			add(moveMe, constraints);
		}
	}
	private void customize(){
		customizer.setVisible(true);
		customizer.requestFocus();
	}
	private void apply(){
		add(moveMe, constraints);
		customizer.setVisible(false);
	}
	private void update(){
		repaint();
		revalidate();
	}
}
