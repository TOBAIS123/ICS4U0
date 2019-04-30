import java.util.Arrays;
import java.io.*;
public class Bogosort{
	public static void shuffle(int[] arr){
		//loop from the end to the beginning of the array
		for (int i = arr.length - 1; i >= 0; i --){
			//generate a random number from 0 to i
			int random = (int)(Math.random() * (i + 1));
			//swap the number and i
			int temp = arr[i];
			arr[i] = arr[random];
			arr[random] = temp;
		}
	}
	public static boolean isSorted(int[] arr){
		for (int i = 0; i < arr.length - 1; i ++){
			if (arr[i] > arr[i + 1])
				//if the previous element is greater than the next, the array is not sorted
				return false;
		}
		return true;
	}
	public static void bogoSort(int[] arr){
		//prints the initial array
		System.out.println(Arrays.toString(arr));
		//continue as long as the array is not sorted
		while (!isSorted(arr)){
		
			//shuffle the array
			shuffle(arr);
			//prints the shuffled array
			System.out.println(Arrays.toString(arr));
		}
	}
	public static void main(String[] args)throws IOException{
		System.out.println("Enter the length of the array:");
		//get length of the array
		int length = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] arr = new int[length];
		//initialize array
		while (--length >= 0){
		    arr[length] = length;
		}
		//sort array
		bogoSort(arr);
	}
}
