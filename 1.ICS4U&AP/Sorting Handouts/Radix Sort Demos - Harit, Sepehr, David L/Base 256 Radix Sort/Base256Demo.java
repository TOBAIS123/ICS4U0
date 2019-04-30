/**
 * Harit Kapadia
 * Ms. Krasteva
 * 2019/April/08
 * This program compares the speed of base 256 radix sort and Arrays.sort using a large integer array. Be sure to use the attached "run.bat" otherwise Java will run out of memory. Alternatively, run this program with the command "java -Xmx6G Base256Demo"
 */

import java.util.*;

public class Base256Demo {
	public static void sort256(final int originalArr[]) {
		int[] arr = originalArr;
		// utility to find the current digit in base 256
		int digitGet = 0xFF;

		// a number that is up to 2^32 - 1 is represented in 4 digits (base 256). Another way of looking at it is that an int is 4 bytes large.
		for(int place = 0; place != 4; place++) {
			int[] count = new int[256];
			int[] copyArr = new int[arr.length];
			// counting the number of times each digit occurs in the array
			for(int i = 0; i != arr.length; i++) {
				int digit = (digitGet & arr[i]) >>> (8 * place);
				count[digit] += 1;
			}
			// determining the index of each element of the array based on the digit
			for(int i = 1; i != count.length; i++)
				count[i] += count[i-1];
			// reordering the array
			for(int i = arr.length - 1; i != -1; i--) {
				int digit = (digitGet & arr[i]) >>> (8 * place);
				copyArr[--count[digit]] = arr[i];
			}

			// reassigning the array
			arr = copyArr;
			digitGet <<= 8;
		}

		// copying the array into the original with negatives before positives
		int[] count = new int[2];
		for(int i = 0; i < arr.length; i++) {
			int digit = (int)(((1 << 63) & Double.doubleToLongBits(arr[i])) >>> (63));
			count[digit] += 1;
		}
		int i = 0;
		while(i != count[1])
			originalArr[i++] = arr[i + count[0] - 1];
		while(i != arr.length)
			originalArr[i++] = arr[i - count[1] - 1];
	}

	public static void main(String[] args) {
		// Creating large array and a copy of that array
		int[] radix = new int[200000000];
		int[] util = new int[radix.length];
		for(int i = 0; i < radix.length; i++) {
			radix[i] = (int)(Math.random() * Integer.MAX_VALUE - 1024);
			util[i] = radix[i];
		}
		// Printing information about the array
		System.out.printf("%d elements from -1024 to %d\n", radix.length, Integer.MAX_VALUE - 1024);
		System.out.println("Unsorted array (first 10 elements): " + Arrays.toString(Arrays.copyOf(radix, 10)));
		long start, end;

		// Timing radix sort and printing out information about the sort.
		start = System.currentTimeMillis();
		sort256(radix);
		end = System.currentTimeMillis();
		System.out.printf("Radix sort took %d milliseconds.\n", (end - start));
		System.out.println("Sorted array (first 10 elements): " + Arrays.toString(Arrays.copyOf(radix, 10)));

		// Timing Arrays.sort and printing out information about the sort.
		start = System.currentTimeMillis();
		Arrays.sort(util);
		end = System.currentTimeMillis();
		System.out.printf("Arrays.sort took %d milliseconds.\n", (end - start));

		System.out.println("Sorted array (first 10 elements): " + Arrays.toString(Arrays.copyOf(util, 10)));
	}
}
