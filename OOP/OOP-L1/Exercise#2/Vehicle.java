
public class Vehicle {

  private String type;
  private String manufacturer;
  private String model;
  private short year;
  private String colour;
  private byte numOfDoors;
  private float gasTankSize;
  private float gas;
  private int km;

  public Vehicle(String typ, String manu, String mod, short yea, String col, byte nDoors, float tankS) {
    type = typ;
    manufacturer = manu;
    model = mod;
    year = yea;
    colour = col;
    numOfDoors = nDoors;
    gasTankSize = tankS;
    gas = 0.0f;
    km = 0;
  }

  public void paint(String colour) {
    this.colour = colour;
  }

  public void gasUp(int litres) {
    gas += litres;
    if (gas > gasTankSize)
      gas = gasTankSize;
  }

  public boolean drive(int distance) {
    km += distance;
    gas -= distance / 5;
    if (gas < 0) {
      gas = 0;
      return false;
    }
    return true;
  }

  public String getType() {
    return type;
  }

  public String getManufact() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public short getYear() {
    return year;
  }

  public String getColour() {
    return colour;
  }

  public byte getDoors() {
    return numOfDoors;
  }

  public float getTankSize() {
    return gasTankSize;
  }
}
