/**
 * Cards have a face and suit, and are used in decks
 */
public class Card {
    String myFace;
    String mySuit;

    /**
     * Constructor to set the face and suit
     *
     * @param theFace the face
     * @param theSuit the suit
     */
    public Card(String theFace, String theSuit) {
        myFace = theFace;
        mySuit = theSuit;
    }

    public String toString() {

        return myFace + " of " + mySuit;
    }
} // close class