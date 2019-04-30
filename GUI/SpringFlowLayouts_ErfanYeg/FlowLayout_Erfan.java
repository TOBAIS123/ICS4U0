import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program creates a demonstration of a FlowLayout using the driver class SpringFlowLayoutMain_Erfan
 * This program allows you to change the alignment, horizontal gap, and vertical gap of the components with buttons
 * @author Erfan Yeganehfar
 * @version 1.0, March 28, 2019
 */
public class FlowLayout_Erfan implements ActionListener {
    JFrame mainFrame = SpringFlowLayoutMain_Erfan.mainFrame;
    Container container = mainFrame.getContentPane();
    private FlowLayout layout;
    private JButton quitBtn = new JButton("Home");
    private JButton incSpaceBtn, revBtn;

    /**
     * Builds the Layout and adds the components to the JFrame, it also adds ActionListeners to the buttons to execute events
     */
    public FlowLayout_Erfan ()
    {
        layout = new FlowLayout (FlowLayout.LEFT);
        mainFrame.setLayout (layout);
        mainFrame.setComponentOrientation (ComponentOrientation.LEFT_TO_RIGHT);

        revBtn = new JButton ("Alignment: Left to Right");
        incSpaceBtn = new JButton ("Increment HGap & VGap");
        mainFrame.add (revBtn);
        mainFrame.add (incSpaceBtn);
        mainFrame.add (quitBtn);

        revBtn.addActionListener (this);
        incSpaceBtn.addActionListener (this);
        quitBtn.addActionListener(this);
        mainFrame.pack();
        mainFrame.setSize (700,500);
        mainFrame.setVisible(true);

    }

    /**
     * Based on the type of button pressed, an ActionEvent is triggered
     * causing methods that align with the event to be executed
     * @param ae
     */
    public void actionPerformed (ActionEvent ae)
    {
        if  (ae.getActionCommand ().equals ("Home")){
        container.removeAll();
        SpringFlowLayoutMain_Erfan.newFrame();
        }
        if (ae.getActionCommand ().equals ("Alignment: Center"))
        {
            revBtn.setText ("Alignment: Right to Left");
            changeRotation ();
            changeAlignment ();
        }
        if (ae.getActionCommand ().equals ("Alignment: Right to Left"))
        {
            revBtn.setText ("Alignment: Left to Right");
            changeRotation ();
            changeAlignment ();
        }
        if (ae.getActionCommand ().equals ("Alignment: Left to Right"))
        {
            revBtn.setText ("Alignment: Trailing");
            changeRotation ();
            changeAlignment ();
        }
        if (ae.getActionCommand ().equals ("Alignment: Trailing"))
        {
            revBtn.setText ("Alignment: Leading");
            changeRotation ();
            changeAlignment ();
        }
        if (ae.getActionCommand ().equals ("Alignment: Leading"))
        {
            revBtn.setText ("Alignment: Center");
            changeRotation ();
            changeAlignment ();
        }
        else if (ae.getActionCommand ().equals ("Increment HGap & VGap"))
        {
            incSpaceBtn.setText ("Decrease HGap & VGap");
            layout.setHgap (25);
            layout.setVgap (25);
        }
        else
        {
            if (ae.getActionCommand ().equals ("Decrease HGap & VGap"))
            {
                incSpaceBtn.setText ("Increment HGap & VGap");
                layout.setHgap (10);
                layout.setVgap (10);
            }
        }
        mainFrame.revalidate ();
    }

    /**
     * This method changes the alignment of the components from left to right (explores all native FlowLayout constants)
     * using getAlignment() and setAlignment().
     */
    private void changeAlignment ()
    {
        if (layout.getAlignment () == FlowLayout.CENTER)
        {
            layout.setAlignment (FlowLayout.RIGHT);
        }
        else if (layout.getAlignment () == FlowLayout.RIGHT)
        {
            layout.setAlignment (FlowLayout.LEFT);
        }
        else if (layout.getAlignment () == FlowLayout.LEFT)
        {
            layout.setAlignment (FlowLayout.TRAILING);
        }
        else if (layout.getAlignment () == FlowLayout.TRAILING)
        {
            layout.setAlignment (FlowLayout.LEADING);
        }
        else
        {
            layout.setAlignment (FlowLayout.CENTER);
        }
    }

    /**
     * This method reverses the order of the components using setComponentOrientation and getComponentOrientation
     */
    private void changeRotation ()
    {
        mainFrame.pack();
        mainFrame.setSize (700,500);
        if (mainFrame.getComponentOrientation ().equals (ComponentOrientation.LEFT_TO_RIGHT))
        {
            mainFrame.setComponentOrientation (ComponentOrientation.RIGHT_TO_LEFT);


        }
        else
        {
            mainFrame.setComponentOrientation (ComponentOrientation.LEFT_TO_RIGHT);
        }
    }

}
