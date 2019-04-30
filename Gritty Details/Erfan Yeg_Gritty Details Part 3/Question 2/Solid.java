// Erfan Yeganehfar
// Ms.Krasteva
// March 15th, 2019
// This class sets up the shape subclasses so they can inherit the methods of solid and override the abstract ones

public abstract class Solid
{
    private String name;
    //constructor
    public Solid (String name)
    {
	this.name = name;
    }


    public String getName ()
    {
	return name;
    }

    public abstract double volume ();
    public abstract double perimeter ();
    public abstract double surfaceArea ();
}
