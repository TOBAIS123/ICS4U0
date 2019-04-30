// The "TestEquation" class.
// This implements the Equation interface to provide a method for use 
// in the Graph class.
public class TestEquation implements Equation
{
    // Represents the function x * x * x - 8 * x * x + 3 * x - 12
    public double f (double x)
    {
	return x * x * x - 8 * x * x + 3 * x - 12;
    } // f method
} /* TestEquation class */
