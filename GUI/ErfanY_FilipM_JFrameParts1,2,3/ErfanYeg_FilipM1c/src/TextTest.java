import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author Erfan Yeg, Filip M
 * @version 1 03.22.19 
 * Ms.Krasteva 
 * The class that enables JFrameTest3 to
 * interact with the user using JTextFields. It also processes an
 * output based on the input
 */
public class TextTest extends JPanel {
	/**
	 * The constructor for TextTest which enables the main methods for inputting and
	 * outputting text to execute when the class is instantiated
	 * 
	 */
	public TextTest() {
		inputPrompt();
		outputResult();
	}

	/**
	 * The method inputPrompt() adds a JLabel to the JFrame, 
	 * prompting the user for a value
	 */
	public void inputPrompt() {
		JLabel enterValue;
		enterValue = new JLabel("Enter a value");
		enterValue.setFont(new Font("Serif", Font.PLAIN, 16));
		add(enterValue);
	}

	/**
	 * This method allows the user to calculate the square of an integer. It adds
	 * the necessary input and output JTextFields and a button to listen to an
	 * ActionEvent. On ActionPerformed the square of the inputed value is
	 * calculated. Illegal value are error trapped and an error message is given
	 */
	public void outputResult() {
		JButton calculate = new JButton("Calculate");
		JTextField inputField = new JTextField(20);
		JTextField outputField = new JTextField(20);
		add(inputField);
		add(outputField);
		add(calculate);
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int number = Integer.parseInt(inputField.getText());
					outputField.setText("The square is " + Integer.toString((number * number)));
				} catch (NumberFormatException nfe) {
					inputField.setText("");
					outputField.setText("Please enter an INTEGER");
				}
				inputField.requestFocusInWindow();
			}
		});
	}
}