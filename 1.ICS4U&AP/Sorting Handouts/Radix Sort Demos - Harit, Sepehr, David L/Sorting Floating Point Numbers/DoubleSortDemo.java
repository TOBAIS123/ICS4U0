/**
 * Harit Kapadia
 * Ms. Krasteva
 * 2019/April/08
 * This program demonstrates sorting floating point numbers with radix sort.
 */

import java.util.*;

public class DoubleSortDemo {
	public static void sort256(final double originalArr[]) {
		double[] arr = originalArr;
		// utility to find the current "digit" in base 256
		long digitGet = 0xFF;

		// A double is 8 bytes large
		for(int place = 0; place != 8; place++) {
			int[] count = new int[256];
			double[] copyArr = new double[arr.length];
			// counting the number of times each digit occurs in the array
			for(int i = 0; i != arr.length; i++) {
				int digit = (int)((digitGet & Double.doubleToLongBits(arr[i])) >>> (8 * place));
				count[digit] += 1;
			}
			// determining the index of each element of the array based on the digit
			for(int i = 1; i != count.length; i++)
				count[i] += count[i-1];
			// reordering the array
			for(int i = arr.length - 1; i != -1; i--) {
				int digit = (int)((digitGet & Double.doubleToLongBits(arr[i])) >>> (8 * place));
				copyArr[--count[digit]] = arr[i];
			}
			// reassigning the array
			arr = copyArr;
			digitGet <<= 8;
		}

		// Rearranging numbers from negative to positive
		int[] count = new int[2];
		for(int i = 0; i < arr.length; i++) {
			int digit = (int)(((1 << 63) & Double.doubleToLongBits(arr[i])) >>> (63));
			count[digit] += 1;
		}
		int i = 0;
		while(i != count[1])
			originalArr[i++] = arr[arr.length - i];
		while(i != arr.length)
			originalArr[i++] = arr[i - count[1] - 1];
	}

	public static void main(String[] args) {
		double[] arr = new double[10];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Math.random() * 20 - 10;

		System.out.println("Original Array: " + Arrays.toString(arr));
		sort256(arr);
		System.out.println("Sorted Array:   " + Arrays.toString(arr));

	}
}
