import java.util.Scanner;
/**
 * This program takes in a string input until a period is given, it is then passed onto a method to rverse the input
 * the string is reversed by recursively taking a substring of the string after the first newline tpo the end, then concatenating
 * the first index to the rest of the string
 * @author Erfan Yeganehfar
 * @version 1.0 April 10, 2019
 * Ms.Krasteva
 */
public class ReverseString {

    /**
     * Reverses the passed string by recursively taking the substring from the first newline to the last character
     * and adding the first index (word) to that substring
     * @param s the string passed on to be reversed
     * @return the reversed string of s
     */
    private static String revString(String s){
        if (s.equals(".") && s.length()== 1)
            return ".";
        return revString(s.substring(s.indexOf('\n') + 1)) + '\n'+ s.substring(0, s.indexOf("\n"));
    }

    /**
     * The main method keeps taking in a user input until a period is inputted,
     * it then passes the string into the revString method
     * @param args
     */
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String current = "";
    String strInput = "";
    while (!current.equals(".")){
        current = in.nextLine();
        strInput += current +"\n";
    }
    strInput+= ".";
    System.out.println(revString(strInput));

    }
}
