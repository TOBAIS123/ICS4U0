//By Stephen H. and Jiping L.
public class SelectionSortExample
{
  public static void selectionSort (int[] arr)
  {
    //The first loop of the nested for loop is used to go through every element in the array
    for (int x = 0; x < arr.length; x++)
    {
      //A variable is used to keep track of the index of the current minumum value
      int minimum = x; 
      //The second loop is used to find the smallest element in the unsorted section of the array
      for (int y = x + 1; y < arr.length; y++)
      {
        if (arr[y] < arr[minimum])
          minimum = y;
      }
      //A temporary variable allows the minimum element and the element after the sorted sectino to be swapped
      int temp = arr [minimum];
      arr [minimum] = arr [x];
      arr [x] = temp;
    }
  }
  
  public static void main (String[] args)
  {
    int[] test = {9, 13, 6 ,15, 2, 1, 20};
    selectionSort (test);
    for (int x = 0; x < test.length; x++)
      System.out.println (test[x]);
  }
}