import java.util.Scanner;

/**
 * Driver class for showcasing creation and shuffling of decks
 */
public class DeckCardsClient {
    /**
     * The method that gets run
     *
     * @param args passed arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DeckofCards deck1 = new DeckofCards();

        System.out.println("Unshuffled deck:\t" + deck1);
        deck1.shuffle();
        System.out.println("Shuffled deck:\t\t" + deck1);
    } // close main method
} // close class