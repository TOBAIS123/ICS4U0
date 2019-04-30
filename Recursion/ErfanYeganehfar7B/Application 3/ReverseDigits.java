import java.util.Scanner;
/**
 * This program uses Math.log10 and Math.pow to reverse an integer input
 * @author Erfan Yeganehfar
 * @version 1.0 April 10, 2019
 * Ms.Krasteva
 */
public class ReverseDigits {

    /**
     * This method recursively changes the order of an integer input
     * by using Math.log10 to find the aprox. length of the integer, it then raises 10 to the length.
     * Afterwards it finds the ones digit by modding it by the maximum digit place the number has (which is what was found by using log10)
     * then it is added onto the remaining integer called  divided by 10, stopping once n is just the ones place left.
     * @param n the integer passed into the method to be reversed
     * @return the reversed integer of n
     */
    public static int revDigits(int n)
    {
        return  n < 10 ? n : n % 10*(int)Math.pow(10,(int)Math.log10((double)n)) + revDigits(n / 10);
    }

    /**
     * The main method takes in an integer user input to pass onto the revDigits method
     * @param args Unsigned args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            String input = in.nextLine();
            System.out.println(revDigits(Integer.parseInt(input)));
        }
        catch (NumberFormatException e){System.err.println(e);}
    }
}
