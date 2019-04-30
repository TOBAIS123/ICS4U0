import java.util.*;
public class Main {
  public static void main(String[] args) {
    int[] ar = new int [2000001];
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int x = 0; x++<2000000;) {
      ar[x] = (int)(Math.random()*Integer.MAX_VALUE);
      arr.add(ar[x]);
    }
    ArrayList<Integer> ra = new ArrayList<Integer>(arr);
    ArrayList<Integer> arraysSort = new ArrayList<Integer>(arr);
    double time = System.currentTimeMillis();
    //for (Integer i : arr) System.out.print (i + " ");
    quickSort(arr);
    //System.out.println ();
    //for (Integer i : arr) System.out.print (i + " ");
    System.out.printf ("\nMedian of 3 took %.2fs\n",(System.currentTimeMillis()-time)/1000);
     time = System.currentTimeMillis();
    quickSortR(ra);
    System.out.printf ("Random pivot took %.2fs\n",(System.currentTimeMillis()-time)/1000);
    time = System.currentTimeMillis();
    Collections.sort(arraysSort);
    System.out.printf ("Collections.sort took %.2fs\n",(System.currentTimeMillis()-time)/1000);
    time = System.currentTimeMillis();
    Arrays.sort(ar);
    System.out.printf ("Arrays.sort took %.2fs\n",(System.currentTimeMillis()-time)/1000);
  }

  public static void quickSort(ArrayList<Integer> arr) {
    quickSortHelper(arr, 0, arr.size() - 1);
  }
   public static void quickSortR(ArrayList<Integer> arr) {
    quickSortHelperR(arr, 0, arr.size() - 1);
  }

  public static void quickSortHelper(ArrayList<Integer> arr, int left, int right) {
    int size = right - left + 1;
    if (size <= 3)
      manualSort(arr, left, right);
    else {
      double median = medianOf3(arr, left, right);
      int partition = partitionIt(arr, left, right, median);
      quickSortHelper(arr, left, partition - 1);
      quickSortHelper(arr, partition + 1, right);
    }
  }
  public static void quickSortHelperR(ArrayList<Integer> arr, int left, int right) {
    int size = right - left + 1;
    if (size <= 3)
      manualSort(arr, left, right);
    else {
      double rand = random(arr, left, right);
      int partition = partitionIt(arr, left, right, rand);
      quickSortHelper(arr, left, partition - 1);
      quickSortHelper(arr, partition + 1, right);
    }
  }
  public static int medianOf3(ArrayList<Integer> arr, int left, int right) {
    int center = (left + right) / 2;

    if (arr.get(left) > arr.get(center))
      swap(arr, left, center);

    if (arr.get(left) > arr.get(right))
      swap(arr, left, right);

    if (arr.get(center) > arr.get(right))
      swap(arr, center, right);

    swap(arr, center, right - 1);
    return arr.get(right - 1);
  }
  public static int random (ArrayList<Integer> arr, int left, int right) {
    int num = (int)(Math.random() * (right-1-left)) + left;
    swap(arr,num,right - 1);
    return arr.get(right - 1);
  }
  public static void swap(ArrayList<Integer> arr, int dex1, int dex2) {
    int temp = arr.get(dex1);
    arr.set(dex1,arr.get(dex2));
    arr.set(dex2,temp);
  }

  public static int partitionIt(ArrayList<Integer> arr, int left, int right, double pivot) {
    int leftPtr = left;
    int rightPtr = right - 1;

    while (true) {
      while (arr.get(++leftPtr) < pivot)
        ;
      while (arr.get(--rightPtr) > pivot)
        ;
      if (leftPtr >= rightPtr)
        break;
      else
        swap(arr, leftPtr, rightPtr);
    }
    swap(arr, leftPtr, right - 1);
    return leftPtr;
  }

  public static void manualSort(ArrayList<Integer> arr, int left, int right) {
    int size = right - left + 1;
    if (size <= 1)
      return;
    if (size == 2) {
      if (arr.get(left) > arr.get(right))
        swap(arr, left, right);
      return;
    } else {
      if (arr.get(left) > arr.get(right - 1))
        swap(arr, left, right - 1);
      if (arr.get(left) > arr.get(right))
        swap(arr, left, right);
      if (arr.get(right - 1) > arr.get(right))
        swap(arr, right - 1, right);
    }
  }

}