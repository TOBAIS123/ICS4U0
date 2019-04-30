// The "GraphTest" class.
// Graphs the function specified in "f" method of the TestEquation class. 

public class GraphTest
{
    public static void main (String[] args)
    {
	TestEquation poly = new TestEquation ();
	new Graph (poly, 500, 300, -5., 10., -200., 200.);
    } // main method
} /* GraphTest class */
