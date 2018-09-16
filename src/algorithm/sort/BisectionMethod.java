package algorithm.sort;

import java.util.Arrays;

import tools.array.ArrayTools;

public class BisectionMethod {
	public static int index_ordered(int[] array, int value) {
		int first = (int) Math.floor((array.length - 1) / 2);
		int end = first;
		for(int i=0;i<array.length;i++) {
			if(array[end - 1] == value) {
				return end - 1;
			} else if(array[end - 1] > value) {
				if(first > 1) {
					first = (int) Math.floor(first / 2);
				}
				end = end - first;
			} else if(array[end - 1] < value) {
				if(first > 1) {
					first = (int) Math.floor(first / 2);
				}
				end = end + first;
			}
		}
		return -1;
	}
	
	public static void compare() {
		int[] array = ArrayTools.randomInts(10000, -1, 10000, 0);
		System.out.println(Arrays.toString(array));
		System.out.println(" ");
		
		long curr = System.currentTimeMillis();
		int index = ArrayTools.index(array, 65);
		System.out.println(index + "-" + array[index]);
		System.out.println(System.currentTimeMillis() - curr + " ms");
		
		System.out.println(" ");
		
		curr = System.currentTimeMillis();
		Sort.quickSort(array);
		System.out.println(Arrays.toString(array));
		index = BisectionMethod.index_ordered(array, 65);
		System.out.println(index + "-" + array[index]);
		System.out.println(System.currentTimeMillis() - curr + " ms");
	}
}
