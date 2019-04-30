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
    Book[] books = {new Book("Plays on a Human Theme", 16), new Book ("Science Textbook", 30), new Book("Les Miserables", 16), new Book("Othello", 14), new Book ("The Lord of the Flies", 18.5), new Book ("Alchemist", 20)};
    System.out.println("Unsorted Array: " + Arrays.toString(books));
    selectionSortName(books);
    System.out.println (" ");
    System.out.println("Sorted Array: " + Arrays.toString(books));
  }
  
  public void swap(Object[] arr, int a, int b)
  { 
    System.out.println ("Swap elements at indices at "+ a + " and " + b + ".");
    Object tmp = arr[b];
    arr[b] = arr[a];
    arr[a] = tmp;
  }
  
  public void selectionSortHeight(Book[] arr) 
  {
    for (int i = 0; i < arr.length - 1; i++) //move starting point of the unsorted array from the first index to the the second last index
    {
      System.out.println ();
      System.out.println ("Step "+ (i+1));
      int highest = i; // set current lowest number index to first index in passed range (minimum to end)
      for (int x = i+1; x < arr.length; x++) // loop through the unsorted array
      { 
        if (arr[x].getHeight() > arr[highest].getHeight()) // if current element is lower than previous lowest, set lowest to its index
          highest = x;
      }
      // swap lowest with first index in range
      swap(arr, highest, i);
      printInfo (arr, i);
    }
  }
  
  public void selectionSortName(Book[] arr) {
    for (int i = 0; i < arr.length - 1; i++) //move starting point of the unsorted array from the first index to the the second last index
    {
      System.out.println ();
      System.out.println ("Step "+ (i+1));
      int lowest = i; // set current lowest numebr index to first index in passed range (minimum to end)
      for (int x = i+1; x < arr.length; x++) // loop through arr array from range minimum+1 to end
      {
        if (arr[x].compareTo(arr[lowest]) < 0) // if current element is lower than previous lowest, set lowest to its index
          lowest = x;
      }
      // swap lowest with first index in range
      swap(arr, lowest, i);
      printInfo (arr, i);
    }
  }
  
  public void printInfo (Book[] arr, int i)
  {
    System.out.print ("Sorted Portion: ");
    for (int z = 0; z <= i; z++)
      System.out.print (arr[z]+ " ");
    System.out.print ("\nUnsorted Portion: ");
    for (int z = i+1; z < arr.length; z++)
      System.out.print (arr[z]+ " ");
    System.out.println (" ");
  }
  
  public static void main(String[] args) { 
    new SelectionSort();
  }
}
