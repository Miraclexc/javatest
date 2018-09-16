package algorithm.datastructure;

public class Heap {
	private int[] array;
	private int size;
	
	public Heap(int[] array) {
		this.size = array.length;
		this.array = array;
	}
	
	public int left(int parent) {
		return parent * 2 + 1;
	}
	
	public int right(int parent) {
		return parent * 2 + 2;
	}
	
	public int parent(int child) {
		int index = child;
		if(child % 2 == 0) {
			index = child / 2 - 1;
		} else {
			index = (child + 1) / 2 - 1;
		}
		
		return index;
	}
	
	public void maxHeapify(int index) {
		int left = this.left(index);
		int right = this.left(index);
		
		int largest = index;
		if(left < this.size && this.array[left] > this.array[largest]) {
			largest = left;
		}
		if(right < this.size && this.array[right] > this.array[largest]) {
			largest = right;
		}
		
		if(largest != index) {
			int temp = this.array[largest];
			this.array[largest] = this.array[index];
			this.array[index] = temp;
			
			this.maxHeapify(largest);
		}
	}
	
	public void buildMaxHeap() {
		int i = this.getSize();
		if(i % 2 == 0) {
			i = i / 2 - 1;
		} else {
			i = (i - 1) / 2 - 1;
		}
		
		while(i >= 0) {
			this.maxHeapify(i);
			i--;
		}
	}
	
	public static Heap buildMaxHeap(int[] array) {
		Heap heap = new Heap(array);
		int i = heap.getSize();
		if(i % 2 == 0) {
			i = i / 2 - 1;
		} else {
			i = (i - 1) / 2 - 1;
		}
		
		while(i >= 0) {
			heap.maxHeapify(i);
			i--;
		}
		
		return heap;
	}
	
	public void heapSort() {
		while(this.size > 0) {
			int temp = this.array[0];
			this.array[0] = this.array[this.size - 1];
			this.array[this.size - 1] = temp;
			this.size = this.size - 1;
			
			this.maxHeapify(0);
		}
		
		this.size = this.array.length;
	}

	public int[] getArray() {
		return this.array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
