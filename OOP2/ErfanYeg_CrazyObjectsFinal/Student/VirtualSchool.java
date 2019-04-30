/**
 * Creates a Student that has a Locker, no books, a Jacket,
 * and a student number. They are then tested to see if they can enter the ClassRoom
 * Ms Krasteva
 * @author Erfan Yeganehafar
 * @version 23.04.19
 */
public class VirtualSchool {
    /**
     * Main method that tests to see if the Student is allowed inside the Class Room
     * @param args passed arguments
     */
    public static void main(String[] args) {
        Student student = new Student("Erfan Yeg");
        ClassRoom classRoom = new ClassRoom("ICS4U0", "Ms.Krasteva");

        student.myLocker.getABook("ICS4U0"); //gets ICS TextBook
        System.out.println(student + " now has the " + student.books[0]); //displays the Book
        student.myLocker.putJacket(student.myJacket); //Puts away their Jacket

        if (student.myJacket == null)//Displays whether they have their jacket or not
            System.out.println(student + " doesn't have his/her jacket");
        else
            System.out.println(student + " has their jacket");

        if (classRoom.enter(student))//checks if they can enter the Class Room
            System.out.println(student + " was allowed into class");
        else
            System.out.println(student + " was not allowed into class");

        System.out.println(student + " takes his/her jacket from their locker");
        student.myJacket = student.myLocker.getJacket();//They take out their jacket from their Locker

        if (classRoom.enter(student))//Checks again if they are allowed into the Class Room
            System.out.println(student + " was allowed into class");
        else
            System.out.println(student + " was not allowed into class");
    }
}