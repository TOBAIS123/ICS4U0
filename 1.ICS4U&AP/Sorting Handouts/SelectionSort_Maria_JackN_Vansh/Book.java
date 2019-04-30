public class Book {
  private double height;
  private String name;
  
  public Book() {
    height = 0;
    name = "undefined";
  }
  
  public Book(String name, double height) {
    this.height = height;
    this.name = name;
  }
  
  public boolean setHeight(double height) {
    if (height > 0) {
      this.height = height;
      return true;
    }
    return false;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public double getHeight () {
    return height;
  }
  
  public String getName () {
    return name;
  }
  
  public String toString () {
    return name+"-"+height;
  }
}