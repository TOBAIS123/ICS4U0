/**
 * @teacher Ms. Krasteva
 * @courseinfo ICS4U0
 *
 * @author Sophia & Kiran & Hannah
 * @version 04.09.19
 *
 * <p>
 * The BubbleSort class sorts the numbers in the array sort from least to greatest.
 *
 * <b>Variable:</b>
 * <p>
 * <b>sort</b> This variable stores the numbers 1 to 10 in random order.
 */
public class BubbleSort
{
    /**
     * <p>
     * This method uses bubble sort to sort the numbers in the array sort from least to greatest.
     *
     * <b>Local Variable:</b>
     * <p>
     * <b>temp</b> This variable temporarily stores a value.
     * <p>
     * <b>swapped</b> This variable is false if the array is sorted.
     */
    public void sortArray (int [] sort)
    {
        int temp = 0;
        boolean swapped;

        for (int i = 1 ; i < sort.length ; i++)
        {
            swapped = false;
            for (int x = 0 ; x < sort.length - 1 ; x++)
            {
                if (sort [x] > sort [i])
                {
                    temp = sort [i];
                    sort [i] = sort [x];
                    sort [x] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    /**
     * <p>
     * This method outputs the sorted array.
     */
    public void printArray (int [] sort)
    {
        for (int i = 0 ; i < sort.length ; i++)
            System.out.print (sort [i] + " ");
    }

    /**
     * <p>
     * The main method creates a new BubbleSort object that runs the program.
     */
    public static void main (String[] args)
    {
        int [] arr = {3, 7, 9, 4, 10, 2, 1, 5, 6, 8};
        BubbleSort b = new BubbleSort ();
        b.sortArray (arr);
        b.printArray (arr);
    }
}
