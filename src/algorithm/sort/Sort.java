package algorithm.sort;

import algorithm.datastructure.Heap;
import tools.array.ArrayTools;

public class Sort {
	//冒泡排序
	public static void bubble(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			int k = array.length - 1;
			for(int j=0;j<k;j++) {
				if(j < array.length-1 && array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				
				//k--;
			}
		}
	}
	//
	
	//快速排序
	public static void quickSort(int[] array) {
		Sort.quickSort_handle(array, 0, array.length - 1, true);
	}
	
	public static void quickSort_handle(int[] array, int low, int high, boolean isRandom) {
		int index = array[low];
		if(isRandom) {
			int random = ArrayTools.randomIndex(low, high);
			index = array[random];
			array[random] = array[low];
			array[low] = index;
		}
		int i = low + 1;
		int j = low;
		
		while(j < high) {
			j++;
			
			if(array[j] < index) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;
			}
		}
		
		array[low] = array[i - 1];
		array[i - 1] = index;
		
		if(low < i && i > low + 1) {
			Sort.quickSort_handle(array, low, i - 2, isRandom);
		}
		if(i < high) {
			Sort.quickSort_handle(array, i, high, isRandom);
		}
	}
	//
	
	//归并排序
	public static void mergeSort(int[] array) {
		Sort.mergeSort_(array, 0, array.length - 1);
	}
	
	public static void mergeSort_(int[] array, int low, int high) {
		if(low < high) {
			int r = high + low;
			if(r % 2 > 0) {
				r = r / 2 + 1;
			} else {
				r= r / 2;
			}
			
			Sort.mergeSort_(array, low, r - 1);
			Sort.mergeSort_(array, r, high);
			Sort.mergeSort_handle(array, low, high, r);
		}
	}
	
	public static void mergeSort_handle(int[] array, int low, int high, int r) {
		int[] left = new int[r - low];
		int[] right = new int[high - r + 1];
		
		int i = 0;
		int j = 0;
		for(;i<left.length;i++) {
			left[i] = array[low+i];
		}
		for(;j<right.length;j++) {
			right[j] = array[r+j];
		}
		i = 0;
		j = 0;
		
		for(int a=low;a<=high;a++) {
			if(j >= right.length || (i < left.length && left[i] <= right[j])) {
				array[a] = left[i];
				i++;
			} else {
				array[a] = right[j];
				j++;
			}
		}
	}
	//
	
	//堆排序
	public static void HeapSort(int[] array) {
		Heap.buildMaxHeap(array).heapSort();
	}
	//
}
