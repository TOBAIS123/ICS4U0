import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program reads from a file (A7-1.txt) and organizes the data into two arrays, names and marks.
 * After the data is organized, it is then passed into a method used to sort the marks based on a merge sorting algorithm.
 * The merge sort algorithm works by dividing the arrays into two parts (left and right)
 * it keeps doing this until the Array List size is 1, where after wards it starts merging the two left and right partitions
 * based on the value of the elements. this is done on both the marks and names.
 * After the sorting has finished a for loop prints the sorted data in 2 columns using printf
 *
 * @author Erfan Yeganehfar
 * @version 1 2019.04.01
 * <b> Ms Krasteva ICS4U0</b>
 * *NOTE*: This version of a merge sort is derived from an example
 * off of StackOverFlow by user "Jean-Baptiste Yunès"
 */
public class StudentMarksB {


    /**
     * Merge Sort algorithm that sorts the names alphabetically and the marks with the names
     * Explanation is provided within the code and in the top comments
     * @param nameList is the names of the students to be sorted
     * @param markList is the marks of the students to be sorted
     */
    private static void mergeSort(List<String> nameList, List<Integer> markList) {
        if (nameList.size() <= 1)
            return;
        int mid = nameList.size() / 2;

        ArrayList<String> nLeft = new ArrayList<String>();
        ArrayList<String> nRight = new ArrayList<String>();
        ArrayList<Integer> mLeft = new ArrayList<Integer>();
        ArrayList<Integer> mRight = new ArrayList<Integer>();

        for (int i = 0; i < mid; i++) //adds the left and right elements from the passed ArrayLists to the left ArrayLists
        {
            nLeft.add(nameList.remove(0));
            mLeft.add(markList.remove(0));
        }
        while (nameList.size() != 0) {
            nRight.add(nameList.remove(0));
            mRight.add(markList.remove(0));
        }

        //keeps dividing the left and right arrays until nameList.size() <= 1, where after wards it starts to merge them
        mergeSort(nLeft, mLeft);
        mergeSort(nRight, mRight);

        // compares both left and right arrays, adds the lesser element into the final array and
        // removes it from its list corresponding list
        while (nLeft.size() != 0 && nRight.size() != 0)
        {
            if (nLeft.get(0).compareTo(nRight.get(0)) < 0) {
                nameList.add(nLeft.remove(0));
                markList.add(mLeft.remove(0));
            }
            else {
                nameList.add(nRight.remove(0));
                markList.add(mRight.remove(0));
            }
        }
        // fills the final arrays with what remaining from the left or right
        while (nLeft.size() != 0)
        {
            nameList.add(nLeft.remove(0));
            markList.add(mLeft.remove(0));
        }
        while (nRight.size() != 0)
        {
            nameList.add(nRight.remove(0));
            markList.add(mRight.remove(0));
        }
    }

    /**
     * Reads the data from the A7-1 file into corresponding ArrayLists (student and marks)
     * @param sNames reads the names into the ArrayList from the file
     * @param sMarks reads the marks into the ArrayList from the file
     */
    public static void readFile( List<String> sNames, List<Integer> sMarks) {
        Scanner in = new Scanner(System.in);
        File file = new File("A7-1.txt");
        try {
            in = new Scanner(file);

            while (in.hasNextLine()) {
                sNames.add(in.nextLine());
                sMarks.add(Integer.parseInt(in.nextLine()));
            }
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid Format");
            System.exit(0);
        }
        catch (IOException e){
            System.err.println("Error with File");
            System.exit(0);
        }
    }

    /**
     * the main method of the class that invokes the readFile and mergeSort methods
     * Also formats the information on output
     * @param args Unsigned
     */
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        List<Integer> marks = new ArrayList<Integer>();

        readFile(names,marks);

        mergeSort(names, marks);
        for (int x = 0; x < names.size(); x++) {
            System.out.printf("%-11s %s\n", names.get(x), marks.get(x));
        }
    }
}