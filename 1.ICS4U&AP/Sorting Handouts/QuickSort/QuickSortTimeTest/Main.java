/*
Chris T. Andy C. Eric S.
Mrs. Krasteva
April 9th, 2019
This class implements two different pivot choosing algorithms and compares speed of 5 different sorts
 */
import java.util.*;
public class Main {
  public static void main(String[] args) {
    double m3,r,m,c,a;
    m3 = r = m = c = a = 0;
    for (int aa = 0; aa < 3; aa++) {
    int[] ar = new int [2000001];
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int x = 0; x++<20;) {
      ar[x] = (int)(Math.random()*10);
      arr.add(ar[x]);
    }
    ArrayList<Integer> ra = new ArrayList<>(arr);
    ArrayList<Integer> arraysSort = new ArrayList<>(arr);
    ArrayList<Integer> merge = new ArrayList<>(arr);
    double time = System.currentTimeMillis();
    System.out.print ("unsorted: ");
    for (Integer i : arr) System.out.print (i + " ");
    System.out.println ();
    quickSort(arr);
    System.out.print ("sorted: ");
    for (Integer i : arr) System.out.print (i + " ");
    System.out.println ();
    m3 += (System.currentTimeMillis()-time)/1000;
     time = System.currentTimeMillis();
    quickSortR(ra);
    r += (System.currentTimeMillis()-time)/1000;
    time = System.currentTimeMillis();
    MergeSort.sort(merge,new Comparator<Integer>() {
      @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1,o2);
    }
    });
    m += (System.currentTimeMillis()-time)/1000;
    time = System.currentTimeMillis();
    Collections.sort(arraysSort);
    c += (System.currentTimeMillis()-time)/1000;
    //time = System.currentTimeMillis();
    //Arrays.sort(ar);
    //a += (System.currentTimeMillis()-time)/1000;
    //System.out.println ((aa+1) + " sort(s) done.");
    }
    //System.out.printf ("Averaged over 3 sorts of 2 million elements:\nMedian of 3 took %.3fs\nRandom Pivot took %.3fs\nMerge sort took %.3fs\nCollections.sort took %.3fs\nArrays.sort took %.3fs\n",m3/3,r/3,m/3,c/3,a/3);
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
      int partition = partition(arr, left, right, median);
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
      int partition = partition(arr, left, right, rand);
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
    int num = (int)(Math.random() * (right-left)) + left;
    swap(arr,num,right - 1);
    return arr.get(right - 1);
  }
  public static void swap(ArrayList<Integer> arr, int dex1, int dex2) {
    int temp = arr.get(dex1);
    arr.set(dex1,arr.get(dex2));
    arr.set(dex2,temp);
  }

  public static int partition(ArrayList<Integer> arr, int left, int right, double pivot) {
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