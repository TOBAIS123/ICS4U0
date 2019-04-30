import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
Chris T.
Mrs. Krasteva
April 3rd, 2019
This class sorts a list of type T with a given comparator using merge sort
 */
public class MergeSort {
    public static <T> void sort (List<T> list, Comparator<T> comp) {
        mergeSort(0,list.size()-1,list,comp); //public static method to be accessed by main class, initiates mergesort over entire list with given comparator
    }
    private static <T> void mergeSort(int l, int r, List<T> list, Comparator<T> comp) {
        if (l < r) { //recursion stops when the size of the list is < 1
            int m = (l + r) / 2; //finds midpoint of current list
            mergeSort(l,m,list,comp); //recursively sorts two half lists
            mergeSort(m+1,r,list,comp); //basically the recursion goes all the way down until there is one element which is already sorted, then they merge all the way up to the whole array
            merge(l,r,m,list,comp); //merges two sorted half lists
        }
    }
    private static <T> void merge(int l, int r, int m, List<T> list, Comparator<T> comp) {
        List<T> newl = new ArrayList<>(); //makes new list to store merged elements in the current range
        int leastl = l, leastr = m+1; //minimum index in the left and right subarrays
        while (leastl <= m || leastr <= r) { //while there are still elements to merge (while either subarray still has elements)
            if (leastr > r || (leastl <= m && comp.compare(list.get(leastl),list.get(leastr)) < 0)) newl.add(list.get(leastl++)); //if there are only elements left in the right subarray, or there are elements in both and the left one is lesser, add the left one and increase the current index for the left subarray
            else newl.add(list.get(leastr++)); //otherwise add the right one
        }
        for (int x = l; x <= r; x++) list.set(x,newl.get(x-l)); //set the current range in the original list to the new list
    }
}
