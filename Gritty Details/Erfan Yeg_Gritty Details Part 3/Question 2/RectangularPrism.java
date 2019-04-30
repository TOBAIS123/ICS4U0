// Erfan Yeganehfar
// Ms.Krasteva
// March 15th, 2019
// This class sets up a rectangular prism defining the methods and instances of the rectangular prism by extending the solid class

public class RectangularPrism extends Solid
{
    private double length;
    private double width;
    private double height;

    //constructor
    public RectangularPrism (String pn, double l, double w, double h)
    {
	super (pn);
	length = l;
	width = w;
	height = h;
    }

    //calculates the volume of the rectangular prism
    public double volume ()
    {
	return length * width * height;
    }

    //calculates the surface area of the rectangular prism
    public double surfaceArea ()
    {
	return 2 * (length * width + length * height + width * height);
    }

    //calculates the perimeter of the rectangular prism
    public double perimeter ()
    {
	return 4 * length + 4 * width + 4 * height;
    }
}
