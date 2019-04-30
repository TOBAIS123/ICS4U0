import java.util.ArrayList;

  public class EmployeeTest
  {
  public static void main( String[] args )
  {
  ArrayList<Employee> employee=new ArrayList<Employee>();
  Date birth = new Date( 7, 24, 1998 );
  Date hire = new Date( 3, 12, 2016 );
  employee.add(new Employee("Bob","Blue",birth,hire));
  employee.add(new Employee("Tina","Bell",birth,hire));
 //Employee employee = new Employee( "Bob", "Blue", birth, hire );
 System.out.println( employee );

  } // end main
  } // end class EmployeeTest

