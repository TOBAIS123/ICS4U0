/*@author Filip Milidrag, Om Patel, and Bill Bai
 *@Version 1.0 April 7th 2019
 * <h2>Ms.Krasteva</h2>
 * QuickSort
 * This class sorts an array into increasing order
 */
public class QuickSort
{

    /*This method will sort an array in increasing order
     * @param array Represents the array is being sorted
     * @param lowerIndex Represents the lowest index of the array that is currently being sorted
     * @param higherIndex Represents the higher index of the array that is being sorted
     */
    public static void quickSort (int[] array, int lowerIndex, int higherIndex)
    {
 int temp;
 int left = lowerIndex;
 int right = higherIndex;
 int pivot = array [lowerIndex + (higherIndex - lowerIndex) / 2]; //Finds pivot number
 while (left <= right)
 {
     while (array [left] < pivot)//Finds a number to the left of the pivot that should be to its right
     {
  left++;
     }
     while (array [right] > pivot)//Finds a number to the right of the pivot that should be to its left
     {
  right--;
     }
     //swaps the numbers
     temp = array [left];
     array [left] = array [right];
     array [right] = temp;
     left++;
     right--;
 }
 //checks if there is still anything that needs to be sorted
 if (lowerIndex < right)
     quickSort (array, lowerIndex, right);
 if (left < higherIndex)
     quickSort (array, left, higherIndex);
    }



    public static void main (String a[])
    {
 int[] array = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
 quickSort (array, 0, array.length - 1);
 for (int i:array)
 {
     System.out.print (i + " ");
 }
    }// main method
}// MyQuickSort class
