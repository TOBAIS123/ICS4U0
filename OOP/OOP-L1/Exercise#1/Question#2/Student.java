import java.util.*;
// Class Student
public class Student
{
  // instance variable declaration
  public String name; // Name of student
  public int mark1; // First mark of student
  public int mark2; // Second mark of student
  public double average; // The average mark of the student
  
  /**Class constructor
    * Aids in constrcuting a Student object and giving its attributes values (literals)
    * @param n is the String name of the student
    */
  public Student (String n)
  {
    name = n;
    mark1 = 0;
    mark2 = 0;
    average = 0.0;
  }
  
  
  /**
   * This method sets the 2 marks of the student
   * @param x Is the first integer mark of the student
   * @param y Is the second integer mark of the student
   */
  public void setMarks (int x, int y)
  {
    mark1 = x;
    mark2 = y;
  }
  
  
  /**
   * Calcualtes the average of the 2 marks of the student
   */
  public void calcAverage ()
  {
    average = (mark1 + mark2) / 2; // Generally avoiding integer division is a good idea, although the sheet uses it
  }
  
  
  /**
   * Returns a message to the user
   * @return String This return a message to the user about the average the student had
   */
  public String message ()
  {
    return name + " You got an " + average;
  }
  
  
  /**
   * Main program routine where instances of the class are made and their behaviours called
   * The average of each student is displayed, and the total average is calculated
   * @param args Unsigned
   */
  public static void main (String[] args)
  {
    
    //An array of student objects is made
    Student studs[] = new Student [10];
    studs [0] = new Student ("Bob");
    studs [1] = new Student ("Jeff");
    studs [2] = new Student ("Lola");
    studs [3] = new Student ("Max");
    studs [4] = new Student ("Micheal");
    studs [7] = new Student ("Kyle"); // Student Object at index 7
    
    //each student is givin marks and their average calculated, their indivdual messages are printed
    for (int i = 0 ; i < 10 ; i++)
    {
      if (studs [i] != null) // If the array index is not null
      {
        Random r = new Random(); // A Random object is used so that all the marks are not the same
        studs[i].setMarks(r.nextInt(100), r.nextInt(100)); // Sets the marks
        studs [i].calcAverage (); // Calculates the average of eaach student
        System.out.println (studs [i].message ()); // Prints the Students messages
      }
    }
    
    //This for loop finds the total sum of the students averages and prints a more thorough message 
    double sum = 0.0;
    for (int i = 0 ; i < 10 ; i++)
    {
      if (studs [i] != null) // If the array index is not null
      {
        sum += studs [i].average; // Increases the total average by the current one
        System.out.println (studs [i].name + " has the marks " + studs [i].mark1 + " and " + studs [i].mark2 + ". Their average is: " + studs [i].average);
      }
      
    }
    double totalAverage = sum / 6; // divided by six because there are 6 students
    System.out.println ("The total average of all the students is " + totalAverage); // Prints the total avergage of all the students
    
  }
} // Student class
