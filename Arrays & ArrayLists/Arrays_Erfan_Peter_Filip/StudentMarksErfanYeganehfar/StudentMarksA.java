import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program reads from a file (A7-1.txt) and organizes the data into two arrays, names and marks.
 * After the reading has finished a for loop prints the sorted data in 2 columns using printf
 *
 * @author Erfan Yeganehfar
 * @version 1 2019.04.01
 * <b> Ms Krasteva ICS4U0</b>
 */
public class StudentMarksA {

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
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        List<Integer> marks = new ArrayList<Integer>();

        readFile(names, marks);

        for (int x = 0; x < marks.size(); x++) {
            System.out.printf("%-11s %s\n", names.get(x), marks.get(x));
        }
    }
}
