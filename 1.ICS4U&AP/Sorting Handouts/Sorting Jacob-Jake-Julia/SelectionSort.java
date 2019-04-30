import java.util.*;
public class SelectionSort {
    public static void main (String [] args) {
        Scanner in = new Scanner (System.in);
        int arr [] = {6, 3, 7, 4, 1, 2, 0, 8, 9, 5}; // the unsorted array
        // displays the original array
        // since it is all unsorted it is all in square brackets
        System.out.print ("[");
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            System.out.print (arr [i] + " ");
        }
        System.out.print (arr[arr.length - 1]);
        System.out.println ("]");
        in.nextLine ();
  
        // moves how much of the array is unsorted
        for (int i = 0; i < arr.length-1; i++) 
        { 
            // finds the minimum element in unsorted portion of the array 
            int min = i; 
            for (int j = i+1; j < arr.length ; j++){
                if (arr[j] < arr[min]){
                    min = j; 
                }
            }
  
            // swaps the minimum element with the first element of the unsorted portion
            int temp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = temp; 

            //prints the array
            for (int j = 0 ; j <= i ; j++) {
                System.out.print (arr[j] + " ");
            }
            // unsorted portion is displayed in square brackets
            System.out.print ("[");
            for (int j = i + 1 ; j < arr.length - 1 ; j++) {
                    System.out.print (arr[j] + " ");
            }
            System.out.print (arr[arr.length - 1]);
            System.out.println ("]");
            in.nextLine ();
        } 
    }
}
        
