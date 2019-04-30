/** Evan Zhang, Max Li, Jack Farley
 *  Ms Krasteva
 *  April 5, 2019
 *  Merge Sort Implementation
 */
public class MergeSort
{
    /**
     * Merge helper method
     * @param arr The array to be sorted
     * @param l   The current left-bound, inclusive.
     * @param m   The current middle.
     * @param r   The current right-bound, inclusive.
     */
    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r)
    {
        Object[] temp = new Object[r-l+1];
        int i = l, j = m+1, t = 0;
        while (i <= m || j <= r)
        {
            if (i > m)
                temp[t++] = arr[j++];
            else if (j > r)
                temp[t++] = arr[i++];
            else if (arr[i].compareTo(arr[j]) <= 0)
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }
        for (int x = l; x <= r; x++)
            arr[x] = (T)temp[x-l];
    }

    /**
     * Main merge sort algorithm.
     * @param  arr The array to be sorted.
     * @param  l   The current left-bound, inclusive.
     * @param  r   The current right-bound, inclusive.
     */
    private <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r)
    {
        if (l == r)
            return;
        int m = (l+r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    /**
     * The Merge Sort interface.
     * @param  arr The array to be sorted.
     */
    public <T extends Comparable<T>> void mergeSort(T[] arr)
    {
        mergeSort(arr, 0, arr.length-1);
    }

    /**
     * The main method to demonstrate Merge Sort.
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        Integer[] a = {1, 4, 22, 3, 25, 2, 4, 5, 21, 2};
        new MergeSort().mergeSort(a);
        for (Integer i : a)
            System.out.println(i + " ");
    }
}
