import java.util.Arrays;
/**
 * This program searches an array of Ccmparables for a target, if it is found it returns true, if not, false
 * @author Erfan Yeganehfar
 * @version 1.0 April 13, 2019
 * Ms.Krasteva
 */
public class SearchItem {

    /**
     * Compares an array of comparables with a target, the first index is checked until the array is 1 in length
     * Each time the length of the array is decreased by cutting out the first index
     * @param c the Comparable array to be checked
     * @param find the object to be found within the array
     * @return
     */
    private static boolean searchItem(Comparable[] c, Comparable find) {
        if (c.length < 2)
            return false;
        if (c[0].compareTo(find) == 0)//.equals() also works
            return true;
        return searchItem(Arrays.copyOfRange(c, 1, c.length), find);
    }

    /**
     * Checks to see if an object is within a Comparable array
     * @param args
     */
    public static void main(String[] args) {
        Comparable[] numList = new Comparable[]{1, 5, 2, 3, 13}; //Autoboxes to Integer
        Comparable[] wordList = new Comparable[]{"hi", "hello", "hola", "salut", "salam"};

        System.out.println(searchItem(numList, 2));
        System.out.println(searchItem(wordList, "byebye"));
    }
}
