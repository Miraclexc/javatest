package algorithm.sort;

import java.util.Arrays;

import algorithm.datastructure.Heap;
import tools.array.ArrayTools;

public class SortTest {
	public static void main(String[] args) {
		/*int[] array = new int[] {
				5,415,15,1,3,8,9,4,3
		};*/
		//sort();
		int[] array = ArrayTools.randomInts(10, -1, 10, 0);
		System.out.println(Arrays.toString(Heap.buildMaxHeap(array).getArray()));
	}
	
	public static void sort() {
		int[] array = ArrayTools.randomInts(10, -1, 10, 0);
		long curr = System.currentTimeMillis();
		System.out.println(Arrays.toString(array));
		Sort.HeapSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(System.currentTimeMillis() - curr + " ms");
	}
	
	public static void compare() {
		int[] array = ArrayTools.randomInts(500000, -1, 10000, 0);
		System.out.println(Arrays.toString(array));
		System.out.println(" ");
		
		long curr = System.currentTimeMillis();
		int[] array2 = ArrayTools.cloneIntArray(array);
		Sort.mergeSort(array2);
		//System.out.println(Arrays.toString(array2));
		System.out.println(System.currentTimeMillis() - curr + " ms");
		
		System.out.println(" ");
		
		curr = System.currentTimeMillis();
		int[] array3 = ArrayTools.cloneIntArray(array);
		Sort.quickSort(array3);
		//System.out.println(Arrays.toString(array3));
		System.out.println(System.currentTimeMillis() - curr + " ms");
	}
}
