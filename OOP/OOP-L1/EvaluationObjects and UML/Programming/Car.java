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
    * sets the gas as the amount of tank capacity, filling it up
    */
    public void gasUp() {
        gas = tankCapacity;
    }

    /**
    * @return the brand and model of the car as a String     
    */
    public String getInfo(){
        return brand + " " + model;
    }
} // Car class
