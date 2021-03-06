package week02;

public class IntVector {
	int size = 0;
	int capacity = 10;
	int arr[] = new int[capacity];
	
	public IntVector() {}
	
	public IntVector(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	public IntVector(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.add(arr[i]);
		}
	}
	
	
	public void add(int data) {
		if (size == capacity) {
			resize();
		}
		arr[size] = data;
		size++;
	}
	
	public int size() {
		return size;
	}

	public void set(int index, int data) {
		arr[index] = data;
	}
	
	public int get(int index) {
		return arr[index];

	}	
	
	public void resize() {
		capacity *= 2;
		int[] temp = new int[capacity*2];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}
	
	
	//has exact signature
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += arr[i] + ", ";
	
		}
		return "[" + result + "]";
	}
}








