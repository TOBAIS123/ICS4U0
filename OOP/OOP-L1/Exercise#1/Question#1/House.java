// House Class
public class House { 

    // Instance variable declaration
    private int street_num; // Is the Street number as an integer of the house
    private String street; // Is the street of the house as a String
    private String city; // Is the city of the house
    private String province; // Is the province of the house
    private String postal_code; // Is the postal code of the house
    private double size; // Is the size of the house
    private boolean detached; // Is a boolean of whether the house is detached
    private int stories; // Is an integer value of the stories of the house

    /** Class constructor 
    * Aids in constrcuting a House object and giving its attributes values (literals)
    * @param n Is the Street number as an integer of the house
    * @param s Is the street of the house as a String
    * @param c Is the city of the house
    * @param pv Is the province of the house
    * @param p Is the postal code of the house
    * @param si Is the size of the house
    * @param d Is a boolean of whether the house is detached
    * @param l Is an integer value of the stories of the house
    */
    public House(int n, String s, String c, String pv, String p, double si, boolean d, int l) {
	street_num = n;
	street = s;
	city = c;
	province = pv;
	postal_code = p;
	size = si;
	detached = d;
	stories = l;
    }

    /**
    * This method displays the House objects location
    */
    public void displayAddress() {
	System.out.println(street_num + " " + street);
	System.out.println(city + ", " + province);
	System.out.println(postal_code);
    }

    /**
    * Main program routine where instances of the class are made and their behaviours called
    * (*Objects do not reflect real life locations*)
    * @param args Unsigned
    */
    public static void main(String[] args) {

	House h1 = new House (12, "Abeldain Ave.", "Windsor", "Ontario","M3N 1O9", 100.0, false, 2);
	h1.displayAddress();

	House h2 = new House (1467, "Winslow", "Iqaluit", "Nunavut","K2L 8U0", 55.5, true, 1);
	h2.displayAddress();

	House h3 = new House (1222, "Cool Dr.", "Drunslow", "Chechnya","H1E 3T9", 300.3, true, 3);
	h3.displayAddress();

	House h4 = new House (560, "Larry Dr.", "Toronto", "Ontario","M2R 1G6", 1000.66, true, 5);
	h4.displayAddress();

	House h5 = new House (1231, "Yale Loop", "Whitehorse", "Yukon","U8H 1OK", 200.00, true, 4);
	h5.displayAddress();
    }
    
} // House class
