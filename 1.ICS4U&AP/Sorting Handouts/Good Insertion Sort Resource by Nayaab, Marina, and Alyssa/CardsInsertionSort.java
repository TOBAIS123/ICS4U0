/**
 * demo of insertion sort using cards
 * @author nayaab ali, marina semenova, alyssa wang
 * @version 1.0 april 7 2019
 */
public class CardsInsertionSort {
       private int[] cardsToSort = {7,2,6,5,10,4,9,6}; // the cards
     // private int[] cardsToSort = {2,4,5,6,6,7,9,10}; // the cards
     // private int[] cardsToSort = {10,9,7,6,6,5,4,2}; // the cards
    /**
     * this method prints the cards
     * @param printCards cards
     */
    public void printCards(int[] printCards, int div, int len){
        for (int x = 0; x < len; x++){ // iterates through the elements
            System.out.print(printCards[x] + " "); // print
            if (x == div && x != len - 1){ // show where sorted
                System.out.print("*" + " "); // print
            }
        }
        System.out.println(); // new line
    }

    /**
     * this is the sorting method for the cards
     * @param cards cards to sort
     */
    public void sortCards (int[] cards){
        int n = cards.length; // max index is amount of cards
        System.out.println("original array:"); // display original order of cards
        printCards(cards, -1, n); // method to print
        try // credits: https://stackoverflow.com/questions/26184409/java-console-prompt-for-enter-input-before-moving-on
        {
            System.in.read();
        }
        catch(Exception e)
        {}
        // sort
        for (int x = 1; x < n; x++) { // no matter what always runs through every card (amount - 1)
            System.out.println("run #" + x + " before:"); // output run results
            printCards(cards, x, n); // method to print
            int currentCard = cards[x]; // set current card to check
            int i = x; // sets current working index
            // shift array
            while (i > 0 && cards[i - 1] > currentCard) { // i > 0 to avoid IndexOutOfBoundsException and comparing every card to the left of currentCard to check if it's larger
                cards[i] = cards[i - 1]; // if larger than set the current index to the larger number
                i--; // decrement i
            }
            cards[i] = currentCard; // assign current value to the position it belongs based on the outcome of the previous while structure
            System.out.println("run #" + x + " after:"); // output run results
            printCards(cards, x, n); // method to print
            try // credits: https://stackoverflow.com/questions/26184409/java-console-prompt-for-enter-input-before-moving-on
            {
                System.in.read();
            }
            catch(Exception e)
            {}
        }
    }



    public static void main (String[] args){
        CardsInsertionSort c = new CardsInsertionSort(); // new object of class
        c.sortCards(c.cardsToSort); // pass instance array of cards to sort method
    }
}
