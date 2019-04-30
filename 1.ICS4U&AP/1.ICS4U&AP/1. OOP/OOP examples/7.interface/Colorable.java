// The "Colorable" interface. 
// This interface is implemented by classes that have a color that 
// can be set and read. How this is implemented is up to the 
// class. Any Object of a class that implements Colorable can be 
// passed as parameter of type Colorable.

import java.awt.*;

public interface Colorable
{
    public abstract void setColor (Color color);
    public abstract Color getColor ();
} /* Colorable interface */
