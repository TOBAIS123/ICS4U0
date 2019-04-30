// Animal Class
public class Animal {
    private String name; // Is the name of the animal
    private boolean tired; //Represents whether the animal is tired
    private boolean hungry; //Represents whether the animal is hungry
    private double weight; //Is the weight of the animal

    /** Class constructor 
    * Aids in constrcuting a Animal object and giving its attributes values (literals)
    * @param n Is the String name of the animal
    * @param w Is the weight of the animal
    */
    public Animal(String n, double w) {
	name = n;
	tired = true;
	hungry = true;
	weight = w;
    }
    /**
    * This method feeds the animal with a certain type of food, adn increases it's weight
    * @param v Is the type of food fed to the animal
    */
    public void feed(String v) {
	hungry = false;
	if (v.equals("vegetables"))
	    weight += 2;
	else if (v.equals("meat"))
	    weight += 4;
	else
	    weight += 1;
    }

    /**
    * This method sets the boolean tired to false and decreases the animals weight by 3
    */
    public void sleep() {
	tired = false;
	weight -= 3;
    }
    
    public static void main(String[] args) {
	
	Animal a1 = new Animal("BobLion", 200.0); //Animal object 1
	a1.feed("vegetables");
	a1.sleep();

	Animal a2 = new Animal("Betsy", 100.2); //Animal object 2
	a2.feed("meat");
	a2.sleep();

	Animal a3 = new Animal("King Julien", 55.9); //Animal object 3
	a3.feed("coconut");
	a3.sleep();

	Animal a4 = new Animal("Moto Moto", 1999.0); //Animal object 4
	a4.feed("big banana");
	a4.sleep();

	Animal a5 = new Animal("Kowalski", 75.0); //Animal object 5
	a5.feed("meat");
	a5.sleep();
    } 
    
} // Animal class
