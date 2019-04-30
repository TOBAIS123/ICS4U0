/**
 * This class defines a Book with the attributes of a title and a course that its attributed to
 * Ms Krasteva
 * @author Erfan Yeganehafar
 * @version 23.04.19
 */
public class Book {
    String title;
    String course;

    /**
     * Sets the title of the book
     * @param title the title that is to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the course for the book
     * @param course is the course of the book
     */
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return title + " of course: " + course;
    }
}