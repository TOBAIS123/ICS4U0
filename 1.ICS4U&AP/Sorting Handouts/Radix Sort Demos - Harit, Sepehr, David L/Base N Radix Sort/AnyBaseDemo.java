/**
 * Harit Kapadia
 * Ms. Krasteva
 * 2019/April/08
 * This program demonstrates that radix sort can be performed in any base.
 */

import java.util.*;

public class AnyBaseDemo {
	// method to get log of a number in any base
	public static double log(double d, int base) {
		return Math.log(d) / Math.log(base);
	}

	// method to get a digit of a number in any base
	public static int getDigit(int n, int place, int base) {
		return (n / (int)Math.pow(base, place)) % base;
	}

	// radix sort does not handle negatives well
	public static void sortPrepare(final int[] arr, int base) {
		int[] negatives = new int[arr.length];
		int[] positives = new int[arr.length];
		int nLen = 0, pLen = 0;
		// separation of array into negatives and positives
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0)
				negatives[nLen++] = arr[i];
			else
				positives[pLen++] = arr[i];
		}

		// sorting each array individually
		System.out.println("Negatives");
		negatives = sort(negatives, base);
		System.out.println("Positives");
		positives = sort(positives, base);

		// reassembling the array to keep the negatives at the beginning and positives at the end
		for(int i = 0; i < nLen; i++)
			positives[i] = negatives[arr.length - i - 1];
		for(int i = 0; i < arr.length; i++)
			arr[i] = positives[i];
	}

	public static int[] sort(int[] arr, int base) {
		final int digits = (int)Math.floor(log(Integer.MAX_VALUE, base)) + 1;
		int[] copyArr = null;

		for(int place = 0; place < digits; place++) {
			int[] count = new int[base];
			copyArr = new int[arr.length];
			// counting the number of times each digit occurs in the array
			for(int i = 0; i < arr.length; i++) {
				int digit = Math.abs(getDigit(arr[i], place, base));
				count[digit] += 1;
			}
			// determining the index of each element of the array based on the digit
			for(int i = 1; i < count.length; i++)
				count[i] += count[i-1];
			// reordering the array
			for(int i = arr.length - 1; i >= 0; i--) {
				int digit = Math.abs(getDigit(arr[i], place, base));
				copyArr[--count[digit]] = arr[i];
			}
			// reassigning the array
			arr = copyArr;

			System.out.println("Place: 10^" + place);
			for(int i = 0; i < arr.length; i++)
				System.out.println(String.format("%04d", arr[i]));
			System.out.println();
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {1, 4, -19, 29, -28, 3, -2, 29, 961, 28};
		System.out.println("Original array: " + Arrays.toString(arr) + "\n");
		sortPrepare(arr, 10);
		System.out.println("Sorted array:   " + Arrays.toString(arr));

	}
}
