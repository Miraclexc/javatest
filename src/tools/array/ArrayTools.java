package tools.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayTools {
	/*public <T> String toString(T[] array) {
		StringBuffer string = new StringBuffer();
		string.append("[");
		for(T str : array) {
			string.append(str.toString());
		}
		string.append("]");
	}*/
	
	public static int[] randomInts(int size, int seed, int max, int min) {
		int[] array = new int[size];
		Random random;
		if(seed == -1) {
			random = new Random();
		} else {
			random = new Random(seed);
		}
		
		for(int i=0;i<size;i++) {
			array[i] = random.nextInt(max) + min;
		}
		return array;
	}
	
	public static int index(int[] array, int value) {
		for(int i=0;i<array.length;i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static String[] toStringArray(Object[] array) {
		String[] string = new String[array.length];
		for(int i=0;i<array.length;i++) {
			string[i] = array[i].toString();
		}
		
		return string;
	}
	
	public static String doubleDimensionalDoubleToString(double[][] array) {
		String[] string = new String[array.length];
		IntStream.range(0, array.length).forEach(i -> string[i] = Arrays.toString(array[i]));
		return Arrays.toString(string);
	}
	
	public static int randomIndex(int low, int high) {
		return low + (int) Math.floor(Math.random() * (high - low));
	}
	
	public static int[] cloneIntArray(int[] array) {
		int[] newarray = new int[array.length];
		for(int i=0;i<array.length;i++) {
			newarray[i] = array[i];
		}
		
		return newarray;
	}
	
	public static String[] cloneStringArray(String[] array, int start, int end) {
		if(start < 0 || start >= end || start >= array.length) {
			return new String[0];
		}
		if(end > array.length) {
			end = array.length;
		}
		
		String[] newArray = new String[end - start];
		IntStream.range(start, end).forEach(i -> newArray[i - start] = array[i]);
		return newArray;
	}
}
