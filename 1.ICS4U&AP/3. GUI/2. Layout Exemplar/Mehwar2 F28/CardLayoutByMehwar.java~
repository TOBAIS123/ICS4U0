import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Mehwar Raza
 * @version 1.0, Feb. 26, 2012
 * <p>
 * This program demonstrates the 4 layouts: FlowLayout, GridBagLayout, SpringLayout
 * and GroupLayout in various ways over the course of 6 cards.
 * </p>
 */
public class CardLayoutByMehwar extends JFrame
{
  /**
   * <p>
   * The constructor method builds all the cards and adds
   * them to the frame. It also creates a tabbed pane which
   * is used to cycle through demos.
   * </p>
   * <pre>
   * Variable Name    Type                 Description
   * slm              SpringLayoutMehwar   Used to Demo the variuos Spring Layouts.
   * gblm             GridBagLayoutMehwar  Used to demo GridBagLayout
   * glt              GroupLayoutTony      Used to demo GroupLayout
   * flt              FlowLayoutTony       Used to demo FlowLayout.
   * panel            JPanel               Used for the main cardlayout content.
   * tabbedPane       JTabbedPane          The tabbed pane used to cycle through demos.
   * allLayouts       JPanel               Used for borderlayout and the collection of all 4 layouts.
   * </pre>
   */
  public CardLayoutByMehwar(){
    
    super("CardLayout By Mehwar");
    JPanel panel = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();
    
    CardLayout layout = new CardLayout ();
    panel.setLayout(layout);
    
    SpringLayoutMehwar slm = new SpringLayoutMehwar (120,280,300,280);
    panel.add (slm, "SpringLayout");
    tabbedPane.addTab("SpringLayout", slm);
    
    GridBagLayoutMehwar gblm = new GridBagLayoutMehwar();
    panel.add (gblm, "GridBagLayout");
    tabbedPane.addTab("GridBagLayout",gblm);
    
    slm = new SpringLayoutMehwar(300,280,480,280);
    slm.add(new GridBagLayoutMehwar());
    panel.add(slm,"GridBagLayout within SpringLayout");
    tabbedPane.addTab("GridBagLayout within SpringLayout",slm);
    
    FlowLayoutTony flt = new FlowLayoutTony();
    panel.add(flt, "FlowLayout");
    tabbedPane.addTab("FlowLayout", flt);
    
    GroupLayoutTony glt = new GroupLayoutTony ();
    panel.add(new GroupLayoutTony (), "GroupLayout");
    tabbedPane.addTab("GroupLayout", glt);
    
    JPanel allLayouts = new JPanel (new BorderLayout());
    slm = new SpringLayoutMehwar(40,180,120,180);
    slm.setPreferredSize (new Dimension(500,300));
    allLayouts.add(slm, BorderLayout.LINE_START);
    allLayouts.add(new GridBagLayoutMehwar(), BorderLayout.LINE_END);
    allLayouts.add(new FlowLayoutTony(), BorderLayout.PAGE_END);
    allLayouts.add(new GroupLayoutTony(), BorderLayout.PAGE_START);
    panel.add (allLayouts, "BorderLayout");
    tabbedPane.addTab("BorderLayout", allLayouts);
    
    getContentPane().add(panel);
    getContentPane().add(tabbedPane);
    setSize (1000, 600);
    setVisible (true);
  }
  
  /**
   * This methods creates a new object that launches the frame
   * and the rest of the program.
   */
  public static void main (String[] args)
  {
    new CardLayoutByMehwar ();
  }
} 
