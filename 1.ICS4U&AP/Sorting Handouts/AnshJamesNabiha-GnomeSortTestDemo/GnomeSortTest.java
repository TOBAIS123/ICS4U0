/**
 * Ansh Sharma, James Houle, Nabiha Islam
 * Ms. Krasteva
 * April 8th, 2019
 * The GnomeSortTest class. Created to test the capabilities of the gnome sort.
 */
public class GnomeSortTest {
  
  /**
   * The sorting method. The algorithm will run through each array element, increase by 1 if the element is the first index or
   * greater than the previous, and if it is smaller than the previous, it will swap both elements and decrease by 1.
   * @param arr[] The array to be sorted.
   * @param n The number of elements to be sorted.
   */
  public static void gnomeSort(int arr[], int n) 
  { 
    int i = 1; //the starting index variable.
    while (i < arr.length) { //iterate through each element within the array.
      if (arr[i] >= arr[i - 1]) //increase i by 1 if the element is greater than the element preceding it
        i++;
      else{ //otherwise, swap both elements then reduce i by 1
        int temp = 0; 
        temp = arr[i]; 
        arr[i] = arr[i - 1]; 
        arr[i - 1] = temp; 
        i--; 
      } 
    } 
    return;
  } 
  /**
   * The main method.
   * @param args Arguments taken by the main method.
   */
  public static void main(String [] args) {
    //initialize array
    int[] arrayTest = {1, 6, 3, 4, 2, 5};
    //print the array elements
    for (int i = 0; i < arrayTest.length; i++){
      System.out.print(arrayTest[i] + " ");
    }
    System.out.println();
    //call the gnomeSort method on the array
    GnomeSortTest.gnomeSort(arrayTest, arrayTest.length);
    //reprint the sorted array elements
    for (int i = 0; i < arrayTest.length; i++){
      System.out.print(arrayTest[i] + " ");
    }
    System.out.println();
  }
}