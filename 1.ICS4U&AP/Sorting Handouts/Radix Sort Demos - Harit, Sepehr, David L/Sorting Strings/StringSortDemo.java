/**
 * Harit Kapadia
 * Ms. Krasteva
 * 2019/April/08
 * This program demonstrates sorting strings with radix sort.
 */

import java.util.*;

public class StringSortDemo {
	public static void sortString(final String originalArr[]) {
		String[] arr = originalArr;

		// finding the longest string
		int longest = arr[0].length();
		for(int i = 1; i < arr.length; i++)
			longest = Math.max(arr[i].length(), longest);

		// Going from the "ones" place to the most significant digit
		for(int place = longest - 1; place >= 0; place--) {
			// There are 2^16 possible characters, and each character is treated as a digit
			int[] count = new int[(int)Math.pow(2, 16)];
			String[] copyArr = new String[arr.length];
			// counting the number of times each character occurs in the array
			for(int i = 0; i < arr.length; i++) {
				char digit = 0;
				if(place < arr[i].length())
					digit = arr[i].charAt(place);
				count[digit] += 1;
			}
			// determining the index of each element of the array based on the digit
			for(int i = 1; i < count.length; i++)
				count[i] += count[i-1];
			// reordering the array
			for(int i = arr.length - 1; i >= 0; i--) {
				char digit = 0;
				if(place < arr[i].length())
					digit = arr[i].charAt(place);
				copyArr[--count[digit]] = arr[i];
			}
			// reassigning the array
			arr = copyArr;
		}

		// copying the array into the original
		for(int i = 0; i < arr.length; i++)
			originalArr[i] = arr[i];
	}

	public static void main(String[] args) {
		String[] arr = {"joke", "dome", "goalkeeper", "rage", "project", "resolution", "base", "coat", "uncertainty", "toll"};

		System.out.println("Original array: " + Arrays.toString(arr));
		sortString(arr);
		System.out.println("Sorted array  : " + Arrays.toString(arr));
	}
}
