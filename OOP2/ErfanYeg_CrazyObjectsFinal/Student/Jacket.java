/**
 * Creates a Jacket that has an owner, the overridden toString returns the owner
 * Ms Krasteva
 * @author Erfan Yeganehafar
 * @version 23.04.19
 */
public class Jacket {
    Student owner;

    /**
     * Jacket constructor that assigns the owner
     * @param me the student that the jacket belongs to
     */
    public Jacket(Student me) {
        this.owner = me;
    }

    @Override
    public String toString() {
        return owner + " own's this jacket";
    }
}