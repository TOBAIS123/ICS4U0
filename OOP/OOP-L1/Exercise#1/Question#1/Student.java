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
    * @param args Unsigned
    */
    public static void main (String[] args)
    {

	Student s1 = new Student ("Jeff"); // first Student object
	s1.setMarks (10, 70);
	s1.calcAverage ();
	System.out.println (s1.message ());

	Student s2 = new Student ("Donald"); // second Student object
	s2.setMarks (55, 80);
	s2.calcAverage ();
	System.out.println (s2.message ());

	Student s3 = new Student ("Bobson"); // third Student object
	s3.setMarks (100, 91);
	s3.calcAverage ();
	System.out.println (s3.message ());

	Student s4 = new Student ("Andrey"); // fourth Student object
	s4.setMarks (60, 40);
	s4.calcAverage ();
	System.out.println (s4.message ());

	Student s5 = new Student ("William Stein"); // fifth Student object
	s5.setMarks (43, 58);
	s5.calcAverage ();
	System.out.println (s5.message ());


    }
} // Student class
