import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Filip Milidrag
 * @version 1.0, March 29 2019
 * This program demonstrates the 4 layouts: FlowLayout, GridBagLayout, SpringLayout
 * and GroupLayout inside a CardLayout
 */
public class CardLayoutTest extends JFrame
{
  /**
   * The constructor method builds all the cards and adds
   * them to the frame. It also creates a tabbed pane which
   * is used to cycle through demos.
   * Variable Name    Type                 Description
   * spl              SpringLayoutMehwar   Used to run the Spring Layouts
   * gbl              GridBagLayoutMehwar  Used to run GridBagLayout
   * grl              GroupLayoutTony      Used to run GroupLayout
   * fll2             FlowLayoutTony       Used to run FlowLayout
   * panel            JPanel               Used for the cardlayout 
   * tabbedPane       JTabbedPane          Tabbed pane used to cycle through demos
   * everything       JPanel               Used for borderlayout 
   */
  public CardLayoutTest(){
    
    super("A CardLayout By: Filip, Peter, and Erfan");
 JPanel panel = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();
    
    CardLayout layout = new CardLayout ();
    panel.setLayout(layout);
    
    SpringLayoutErfan spl = new SpringLayoutErfan(150,300);
    panel.add (spl, "SpringLayout");
    tabbedPane.addTab("SpringLayout", spl);
    
    GridBagLayoutPeterLin gbl = new GridBagLayoutPeterLin();
    panel.add (gbl, "GridBagLayout");
    tabbedPane.addTab("GridBagLayout",gbl);
    
    FlowLayoutErfan fll2 = new FlowLayoutErfan();
    fll2.add(new GroupLayoutPeterLin());
    panel.add(fll2,"GroupLayout in a FlowLayout");
    tabbedPane.addTab("GroupLayout in a FlowLayout",fll2);
    
    GroupLayoutPeterLin grl=new GroupLayoutPeterLin();
    panel.add(grl, "GroupLayout");
    tabbedPane.addTab("GroupLayout", grl);
    
    FlowLayoutErfan fll =new FlowLayoutErfan();
    panel.add(fll, "FlowLayout");
    tabbedPane.addTab("FlowLayout", fll);
    
    JPanel everything = new JPanel (new BorderLayout(100,100));
    spl = new SpringLayoutErfan(200,400);
    spl.setPreferredSize (new Dimension (500,500));
    everything.add(spl, BorderLayout.LINE_START);
    everything.add(new GridBagLayoutPeterLin(), BorderLayout.LINE_END);
    everything.add(new FlowLayoutErfan(), BorderLayout.SOUTH);
    everything.add(new GroupLayoutPeterLin(), BorderLayout.PAGE_START);
 JPanel jpanel = new JPanel();
 JLabel jlabel = new JLabel("SpringLayout - Erfan");
 JLabel jlabel2 = new JLabel("FlowLayout - Erfan");
 JLabel jlabel3 = new JLabel("GroupLayout - Peter");
 JLabel jlabel4 = new JLabel("GridBagLayout - Peter");
 JLabel jlabel5 = new JLabel("CardLayout - Filip");
 jpanel.add(jlabel);
 jpanel.add(jlabel2);
 jpanel.add(jlabel3);
 jpanel.add(jlabel4);
 jpanel.add(jlabel5);
 everything.add(jpanel,BorderLayout.CENTER);
    panel.add (everything, "BorderLayout");
    tabbedPane.addTab("BorderLayout", everything);
    
    getContentPane().add(panel);
    getContentPane().add(tabbedPane);
    setSize (1200, 1000);
    setVisible (true);
  }
  
  /**
   * This methods creates a new object that launches the frame
   * and the rest of the program.
   */
  public static void main (String[] args)
  {
    new CardLayoutTest ();
  }
} 
