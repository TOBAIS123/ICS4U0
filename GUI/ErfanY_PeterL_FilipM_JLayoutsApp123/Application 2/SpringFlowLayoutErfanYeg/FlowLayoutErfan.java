import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program creates a demonstration of a FlowLayout using a driver class
 * This program allows you to change and display the alignment, horizontal gap,
 * and vertical gap of the components with buttons based on a FlowLayout
 *
 * @author Erfan Yeganehfar
 * @version 1.0, March 28, 2019
 */
public class FlowLayoutErfan extends JPanel implements ActionListener {
    private FlowLayout layout;
    private JButton incSpaceBtn, revBtn, getHGap, getVGap;
    private JDialog dial;

    /**
     * Builds the Layout and adds the components to the JFrame,
     * it also adds ActionListeners to the buttons to execute events
     * causing methods that align with the event to be executed such as changing the alignment,
     * the spacing (Hgap and Vgap), and displaying the current Hgap and Vgap values
     */
    public FlowLayoutErfan() {
        super();
        layout = new FlowLayout(FlowLayout.LEFT);
        setLayout(layout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        revBtn = new JButton("Alignment: Left to Right");
        incSpaceBtn = new JButton("Increment HGap & VGap");
        getHGap = new JButton("HGap");
        getVGap = new JButton("VGap");
        add(revBtn);
        add(incSpaceBtn);
        add(getHGap);
        add(getVGap);

        revBtn.addActionListener(this);
        incSpaceBtn.addActionListener(this);
        getHGap.addActionListener(this);
        getVGap.addActionListener(this);

        setVisible(true);
        update();

    }

    /**
     * Makes sure that after an event is complete,
     * the JPanel revalidate the components and corrects their current position
     */
    private void update() {
        repaint();
        invalidate();
        validate();
        revalidate();
    }

    /**
     * Based on the type of button pressed, an ActionEvent is triggered
     * causing methods that align with the event to be executed such as changing the alignment,
     * the spacing (Hgap and Vgap), and displaying the current Hgap and Vgap values
     *
     * @param ae
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Alignment: Center")) {
            revBtn.setText("Alignment: Right to Left");
            changeRotation();
            changeAlignment();
        } else if (ae.getActionCommand().equals("Alignment: Right to Left")) {
            revBtn.setText("Alignment: Left to Right");
            changeRotation();
            changeAlignment();
        } else if (ae.getActionCommand().equals("Alignment: Left to Right")) {
            revBtn.setText("Alignment: Trailing");
            changeRotation();
            changeAlignment();
        } else if (ae.getActionCommand().equals("Alignment: Trailing")) {
            revBtn.setText("Alignment: Leading");
            changeRotation();
            changeAlignment();
        } else if (ae.getActionCommand().equals("Alignment: Leading")) {
            revBtn.setText("Alignment: Center");
            changeRotation();
            changeAlignment();
        } else if (ae.getActionCommand().equals("HGap")) {
            getHgap();
        } else if (ae.getActionCommand().equals("VGap")) {
            getVgap();
        } else if (ae.getActionCommand().equals("Increment HGap & VGap")) {
            incSpaceBtn.setText("Decrease HGap & VGap");
            layout.setHgap(30);
            layout.setVgap(30);
        } else {
            if (ae.getActionCommand().equals("Decrease HGap & VGap")) {
                incSpaceBtn.setText("Increment HGap & VGap");
                layout.setHgap(5);
                layout.setVgap(5);
            }
        }
        revalidate();
    }

    /**
     * Creates a JDialog that displays the value of the HGap of the flow layout on a button
     * The button when pressed on, triggers an ActionEvent that closes the dialog box
     */
    public void getHgap() {
        dial = new JDialog();
        dial.setSize(200, 100);
        dial.setResizable(false);
        JButton hGap = new JButton(String.valueOf(layout.getHgap()));
        hGap.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae) { dial.dispose(); }});
        dial.add(hGap);
        dial.setLocationRelativeTo(this);
        dial.setVisible(true);
    }


    /**
     * Creates a JDialog that displays the value of the VGap of the flow layout on a button
     * The button when pressed on, triggers an ActionEvent that closes the dialog box
     */
    public void getVgap() {
        dial = new JDialog();
        dial.setSize(200, 100);
        dial.setResizable(false);
        JButton vGap = new JButton(String.valueOf(layout.getVgap()));
        vGap.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae) { dial.dispose(); }});
        dial.add(vGap);
        dial.setLocationRelativeTo(this);
        dial.setVisible(true);
    }

    /**
     * This method reverses the order of the components using setComponentOrientation and getComponentOrientation
     */
    private void changeRotation() {
        if (getComponentOrientation().equals(ComponentOrientation.LEFT_TO_RIGHT)) {
            setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);


        } else {
            setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
    }
    /**
     * This method changes the alignment of the components from left to right (explores all native FlowLayout constants)
     * using getAlignment() and setAlignment().
     */
    private void changeAlignment() {
        if (layout.getAlignment() == FlowLayout.CENTER) {
            layout.setAlignment(FlowLayout.RIGHT);
        } else if (layout.getAlignment() == FlowLayout.RIGHT) {
            layout.setAlignment(FlowLayout.LEFT);
        } else if (layout.getAlignment() == FlowLayout.LEFT) {
            layout.setAlignment(FlowLayout.TRAILING);
        } else if (layout.getAlignment() == FlowLayout.TRAILING) {
            layout.setAlignment(FlowLayout.LEADING);
        } else {
            layout.setAlignment(FlowLayout.CENTER);
        }
    }


}
