/**
 * Lockers has a number and an owner. It has a Jacket, which can be put in or taken out,
 * as well as up to 5 Books, which can be put in or removed.
 * each Books have a title and course name.
 * The Jackets and Books can be transferred to and from the Student
 * Ms Krasteva
 * @author Erfan Yeganehafar
 * @version 23.04.19
 *
 */
public class Locker {
    int number;
    Student owner;
    private Jacket studentJacket;
    private Book[] books;

    /**
     * Locker constructor. Randomly generates a number up to 1400 for the locker number
     * Constructs 4 books for each course with a capacity of 5
     * @param me the owner of the locker
     */
    public Locker(Student me) {
       assignOwner(me);
       number = (int) (Math.random() * 1400);
       books = new Book[]{new Book(), new Book(), new Book(), new Book(), null};
       books[0].setCourse("ICS4U0");
       books[0].setTitle("ICS Textbook");

       books[1].setCourse("Math");
       books[1].setTitle("Math Grade 10 Book");

       books[2].setCourse("Science");
       books[2].setTitle("Science Grade 10 Book");

       books[3].setCourse("Physics");
       books[3].setTitle("Physics TextBook");
    }

    /**
     * Finds a course book from the book array in the Locker, if found it is "taken" out (nulled)
     * and the student is given the book, all exceptions are supported
     * @param course the course to be matched
     * @return the first book in the list for that course
     */
    public Book getABook(String course) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b.course.equals(course)) {
                for (int j = 0; j < owner.books.length; j++) {
                    if(owner.books[j] == null) {
                        owner.books[j] = b;
                        books[i] = null;
                        return b;
                    }
                }
                throw new IllegalArgumentException("The Student cant carry anymore Books");
            }
        }
        throw new IllegalArgumentException("The course was not found");
    }

    /**
     * Puts a book inside the locker,
     * takes the book out of the students Books if the Student has it
     * @param book the Book to be put in
     */
    public void putABook(Book book) {
        for (int i = 0; i < books.length; i++)
            if (books[i] == null) {
                books[i] = book;
                for (int j = 0; j < owner.books.length; j++) {
                    if (owner.books[j].equals(book) && owner.books[j] != null)
                        owner.books[j] = null;
                }
                break;
            }
        throw new IllegalArgumentException("Locker is full");
    }

    /**
     * Takes the Jacket out of the Locker.
     * Gives it to the Student (owner)
     * @return the Jacket
     */
    public Jacket getJacket() {
        Jacket takeJacket = studentJacket;
        if (takeJacket != null) {
            owner.myJacket = studentJacket;
            studentJacket = null;
            return takeJacket;
        }
        else
            throw new IllegalArgumentException("There isn't a Jacket in the Locker");
    }

    /**
     * returns the Jacket, checks if it is inside the Locker
     * @return the Jacket in the locker
     */
    public Jacket checkJacket() {
        return studentJacket;
    }

    /**
     * Puts the Jacket into the Locker.
     * Takes the Jacket away from the owner
     * @param studentJacket the Jacket to be put into the Locker
     */
    public void putJacket(Jacket studentJacket) {
        studentJacket.owner.myJacket = null;
            if (this.studentJacket == null)
            this.studentJacket = studentJacket;
        else
            throw new IllegalArgumentException("There is already a Jacket inside the Locker");
    }

    /**
     * Assigns ownership of the Locker
     * @param me the Student that is to be the owner of the Locker
     */
    public void assignOwner(Student me)
    {
        owner = me;
    }

    @Override
    public String toString() {
        return "Locker number: "+ number + " belongs to " + owner;
    }
}