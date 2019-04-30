/**
 * This Program creates a simulation of a class room that has a course and a teacher.
 * A student is allowed to enter the class room if they have a Locker,
 * dont have their jacket on them, and have the right book for the course
 * Ms Krasteva
 * @author Erfan Yeganehafar
 * @version 23.04.19
 */

public class ClassRoom {
    String name;
    String teacher;

    /**
     * Sets the course and the teacher of the class room
     * @param name the name of the class room
     * @param teacher the teacher of the class room
     */
    public ClassRoom(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    /**
     * Checks if the student can enter the classroom.
     * If the student entering the class doesn't have a locker, they are sent to the office,
     * if they have a jacket on them, they are sent away to put their Jacket inside their Locker,
     * they are not let in. If they do not have the course Books, they are sent to the office and not let in.
     * @param student the student entering the classroom
     * @return whether the student was let inside
     */
    Boolean enter(Student student) {
        System.out.println("Student " + student + " came into class " + name + " taught by " + teacher);
        if (student.myLocker == null) {
            student.sendToOffice(student +" needs a locker");
            return false;
        }
        if (student.myJacket != null) {
            student.myLocker.putJacket(student.myJacket);//puts the jacket away inside the locker
            return false;
        }
        for (Book book : student.books)
            if (book.course.equals(name))
                return true;
        student.sendToOffice("Class " + name + " needs course books");
        return false;
    }
}