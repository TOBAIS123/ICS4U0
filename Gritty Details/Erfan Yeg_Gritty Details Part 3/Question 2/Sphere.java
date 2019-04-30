// Erfan Yeganehfar
// Ms.Krasteva
// March 15th, 2019
// This class sets up a Sphere defining the methods and instances of the Sphere by extending the solid class

public class Sphere extends Solid
{
    private double radius;
    //constructor
    public Sphere (String sn, double r)
    {
	super (sn);
	radius = r;
    }


    //calculates the surface area of the sphere
    public double volume ()
    {
	return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }


    //calculates the surface area of the sphere
    public double surfaceArea ()
    {
	return 4 * Math.PI * Math.pow (radius, 2);
    }


    //calculates the perimeter of the 2D circle of the sphere
    public double perimeter ()
    {
	return 2 * Math.PI * radius;
    }
}
