package SortingObjects;

import java.util.Random;

public class Sortings {
	
	public static void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void quickSort(int[] arr, int from, int to) {
		if (from <  to) {
			int pivot = partition(arr, from, to);
			quickSort(arr, from, pivot - 1);
			quickSort(arr, pivot + 1, to);
		}
	}
	
	public static int partition(int[] arr, int from, int to) {
		int randIndex = from + new Random().nextInt(to-from + 1);
		int pivot = arr[randIndex];
		swap(arr, randIndex, to);
		int i = from;
		for(int j = from; j < to; j++ ) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, to);
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {3,5,6, 3,3,2,7,0,7,8,1,-2};
		quickSort(arr, 0, arr.length - 1);;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
