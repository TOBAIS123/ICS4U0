/**
 * Creates a Student that has all the attributes of a Student.
 * Such as the student number, Locker, Jackets and uninitiated Books.
 * The student can also be sent to the Office with a reason
 * Ms Krasteva
 * @author Erfan Yeganehafar
 * @version 23.04.19
 */
public class Student {
    String name;
    String number;
    Locker myLocker;
    Jacket myJacket;
    Book[] books;

    /**
     * The Constructor for Student which instantiates the student number (a random long number), Locker, and Jacket.
     * The Student can hold 4 books for their courses, the books are not instantiated
     * @param name the name of the student
     */
    public Student(String name) {
        this.name = name;
        number = Long.toString((long)Math.random() * 400000000L);
        myLocker = new Locker(this);
        myJacket = new Jacket(this);
        books = new Book[4];
    }

    /**
     * The Student is sent to the office with a reason
     * @param reason the reason for why the Student was sent to the office
     */
    public void sendToOffice(String reason) {
        System.out.println(name + " got sent to the office for: " + reason);
    }

    @Override
    public String toString() {
        return name;
    }
}