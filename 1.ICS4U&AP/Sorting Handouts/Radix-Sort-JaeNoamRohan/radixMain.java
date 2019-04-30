// By: Rohan Krishna, Jae Park and Noam Silverman

public class radixMain
{
    public radixMain ()
    {
    }
    
    
    public static void main (String[] args)
    {
        leastSignificant l = new leastSignificant ();
        l.lsdRadixSort ();
        mostSignificant m = new mostSignificant ();
        m.msdRadixSort ();
    }
}