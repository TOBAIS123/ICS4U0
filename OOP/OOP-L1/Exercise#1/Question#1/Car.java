//Class Car
public class Car {
    // Instance variable declaration
    private String brand; // The brand of the car
    private String model; // The model of the car
    private int kilometres; // The amount of kilometres traveled
    private double gas; // The amount of gas
    private double tankCapacity; //The capacity of the gas tank of the car

    /** Class constructor 
    * Aids in constrcuting a Car object and giving its attributes values (literals)
    * @param b Is the String brand of the car
    * @param m Is the String model of the car
    * @param g is the double amount of gas for the car
    * @param tCap is the double tank capacity of the car
    */
    public Car(String b, String m, double g, double tCap) {
	brand = b;
	model = m;
	kilometres = 0;
	gas = g;
	tankCapacity = tCap;
    }

    /**
    * This method increases the distance in which a car has traveled by 1
    * The gas decreases by the amount of distance divided by 5
    * @param distance Is the distance the car has traveled as a double
    */
    public void drive(double distance) {
	kilometres += distance;
	gas -= distance / 5;
    }

    /**
    * sets the gas as the amount of tank capacity
    */
    public void gasUp() {
	gas = tankCapacity;
    }

    /**
    * Main program routine where instances of the class are made and their behaviours called
    * @param args Unsigned
    */
    public static void main(String[] args) {
	
	Car c1 = new Car("Mercedes", "S class", 30.0, 50.0); // Car object 1
	c1.drive(12.1);
	c1.gasUp();

	Car c2 = new Car("Honda", "Civic", 30.0, 40.0); // Car object 2
	c2.drive(999.0);
	c2.gasUp();

	Car c3 = new Car("BMW", "Series-1", 10.0, 60.0); // Car object 3
	c3.drive(2222.22);
	c3.gasUp();

	Car c4 = new Car("Lamborgini", "Enzo", 5.0, 55.0); // Car object 4
	c4.drive(6745647.7);
	c4.gasUp();

	Car c5 = new Car("Bugatti", "Chiron", 15.0, 49.9); // Car object 5
	c5.drive(4453.0);
	c5.gasUp();
    }
    
} // Car class
