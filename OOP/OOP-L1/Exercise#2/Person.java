
public class Person {
  private String fname;
  private String lname;
  private String DOB;
  private double height;
  private double weight;

  public Person(String first, String last, String dob, double h, double w) {
    fname = first;
    lname = last;
    DOB = dob;
    height = h;
    weight = w;
  }

  public void setName(String first, String last) {
    fname = first;
    lname = last;
  }

  public boolean setWeight(double w) {
    if (w >= 0) {
      weight = w;
      return true;
    }
    return false;
  }

  public boolean setHeight(double h) {
    if (h >= 0) {
      height = h;
      return true;
    }
    return false;
  }

  public String getName() {
    return fname + " " + lname;
  }

  public String getDOB() {
    return DOB;
  }

  public int getDOB_year() {
    return Integer.parseInt(DOB.substring(6));
  }

  public int getDOB_month() {
    return Integer.parseInt(DOB.substring(0, 2));
  }

  public int getDOB_day() {
    return Integer.parseInt(DOB.substring(3, 5));
  }

  public double getHeight() {
    return height;
  }

  public double getWeight() {
    return weight;
  }
}
