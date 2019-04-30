/* Pseudo Code:
 * 
 * make the starting index of the unsorted array 0, and shift it over by 1 each iteration
 *        set the maximum value to the first value of the unsorted array
 *        loop through the unsorted array
 *               if the current value is larger than the maximum value, set the maximum to the current value
 *        swap the maximum value and the first value of the unsorted array
 *        next iteration
 */



import java.util.*;

public class SelectionSort 
{
  public SelectionSort() 
  { 
    Book[] books = {new Book("Plays on a Human Theme", 16), new Book ("The Lord of the Flies", 18.5), new Book("Othello", 14), new Book("Les Miserables", 16), new Book ("Science Textbook", 30), new Book ("The Alchemist", 20)};
    System.out.println("Unsorted List: " + Arrays.toString(books));
    selectionSortHeight(books);
    System.out.println("Sorted List: " + Arrays.toString(books));
  }
  
  public void swap(Object[] arr, int a, int b)
  {                
    Object tmp = arr[b];
    arr[b] = arr[a];
    arr[a] = tmp;
  }
  
  public void selectionSortHeight(Book[] arr) 
  {
    for (int i = 0; i < arr.length - 1; i++) //move starting point of the unsorted array from the first index to the the second last index
    {
      int highest = i; // set current lowest number index to first index in passed range (minimum to end)
      for (int x = i+1; x < arr.length; x++) // loop through the unsorted array
      { 
	if (arr[x].getHeight() > arr[highest].getHeight()) // if current element is lower than previous lowest, set lowest to its index
	  highest = x;
      }
      // swap lowest with first index in range
      swap(arr, highest, i);
    }
  }
  
  
  public static void main(String[] args) { 
    new SelectionSort();
  }
}
