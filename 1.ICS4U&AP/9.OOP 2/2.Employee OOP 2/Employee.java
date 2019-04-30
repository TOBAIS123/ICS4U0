
public class Employee
{
  
   private String firstName;
   private String lastName;
   private Date birthDate;
   private Date hireDate;
   private static int count = 0; // number of Employees created
  // constructor to initialize name, birth date and hire date
   public Employee( String first, String last, Date dateOfBirth,Date dateOfHire )
   {
   firstName = first;
   lastName = last;
   birthDate = dateOfBirth;
   hireDate = dateOfHire;
   ++count;
   System.out.printf( "Employee constructor: %s %s; count = %d\n",firstName, lastName, count );
   } // end Employee constructor
    
   public static int getCount()
   {
   return count;
   } // end method getCount
// get first name
public String getFirstName()
 {
 return firstName;
 } // end method getFirstName

 // get last name
 public String getLastName()
 {
 return lastName;
 } // end method getLastName
   // convert Employee to String format
   public String toString()
   {
   return String.format( "%s, %s Hired: %s Birthday: %s",lastName, firstName, hireDate, birthDate );
   } // end method toString
   } // end class Employee
