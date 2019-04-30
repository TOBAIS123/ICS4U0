import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

/**
 * This class demonstrates the different ways that a GroupLayout
 * can be laid out using the <code>setHorizontalGroup</code> and
 * <code>setVerticalGroup</code> methods, and the <code>replace</code> method.
 * 
 * @author Peter Lin
 * @version 1.0, 03/28/19
 * @see LayoutTestApp
 * @see GridBagLayoutPeterLin
 */

public class GroupLayoutPeterLin extends JPanel implements ActionListener{
	boolean isSwapped = false, verticalFlag = false, horizontalFlag = false;
	JLabel swapper = new JLabel();
	GroupLayout layout;
	JLabel replaceMe;
	JButton replaceButton, verticalButton, horizontalButton;
	public GroupLayoutPeterLin(){
		super();
		layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		replaceMe = new JLabel("Replace Me!");
		verticalButton = new JButton("Vertical");
		horizontalButton = new JButton("Horizontal");
		replaceButton = new JButton("Click Me!");

		layout.linkSize(replaceMe, verticalButton, horizontalButton, replaceButton);

		replaceMe.setVisible(true);
		verticalButton.setVisible(true);
		horizontalButton.setVisible(true);
		replaceButton.setVisible(true);

		verticalButton.addActionListener(this);
		horizontalButton.addActionListener(this);
		replaceButton.addActionListener(this);
		
		layout.setHorizontalGroup(createSequentialGroup());
		layout.setVerticalGroup(createSequentialGroup());
		setVisible(true);
		update();
	}
	private void update(){
		repaint();
		invalidate();
		validate();
		revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent ae){
		switch (ae.getActionCommand()){
			case "Vertical":
				layout.setVerticalGroup(verticalFlag ? createParallelGroup() : createSequentialGroup());
				verticalFlag ^= true;
				break;
			case "Horizontal":
				layout.setHorizontalGroup(horizontalFlag ? createParallelGroup() : createSequentialGroup());
				horizontalFlag ^= true;
				break;
			case "Click Me!":
				layout.replace (replaceButton, swapper);
				layout.replace(replaceMe, replaceButton);
				layout.replace(swapper, replaceMe);
				isSwapped ^= true;
				break;
		}
	}
	public GroupLayout.Group createSequentialGroup(){
		return isSwapped ? layout.createSequentialGroup().addComponent(replaceButton).addComponent(verticalButton).addComponent(horizontalButton).addComponent(replaceMe) : layout.createSequentialGroup().addComponent(replaceMe).addComponent(verticalButton).addComponent(horizontalButton).addComponent(replaceButton);
	}
	public GroupLayout.Group createParallelGroup(){
		return isSwapped ? layout.createParallelGroup().addComponent(replaceButton).addComponent(verticalButton).addComponent(horizontalButton).addComponent(replaceMe) : layout.createParallelGroup().addComponent(replaceMe).addComponent(verticalButton).addComponent(horizontalButton).addComponent(replaceButton);
	}
	@Override
	public Dimension getPreferredSize(){
		Dimension size = super.getPreferredSize();
		size.height += 20;
		size.width += 20;
		return size;
	}
}