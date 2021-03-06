package Friday;

import java.util.Scanner;

public class Sortings {
	
	public static void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr, min, i);
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j-1] > arr[j]) {
				swap(arr, j-1, j);
				j--;
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j-1] > arr[j]) {
					swap(arr, j-1, j);
				}
			}
		}
	}
	
	public static int min(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int[] histogram(int[] arr) {
		int histMin = min(arr);
		int histMax = max(arr);
		int size = histMax - histMin + 1;
		int [] histogram = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			histogram[arr[i] - histMin] +=1;
		}
		
		
		return histogram;
	}
	
	public static void countingSort(int[] arr) {
		int min = min(arr);
		int [] hist = histogram(arr);
		
		int arrIndex = 0;
		for (int i = 0; i < hist.length; i++) {
			if(hist[i] > 0) {
				for (int j = 0; j < hist[i]; j++) {
					arr[arrIndex] = i + min;
					arrIndex++;
				}
			}
		}
	}
	
	public static void missingNumbers(int n, int arr1[], int m, int arr2[]) {
		//int min1 = min(arr1);
		int min2 = min(arr2);
		int [] hist1 = histogram(arr1);
		int [] hist2 = histogram(arr2);
		for (int i = 0; i < hist1.length; i++) {
			if(hist1[i] != hist2[i]) {
				System.out.print(i + min2 + " ");
			}
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {3,5,6, 3,3,2,7,7,8,1,0, -2};
		//selectionSort(arr);
		//insertionSort(arr);
		//bubbleSort(arr);
		countingSort(arr);
/*		int [] hist = histogram(arr);
		for (int i = 0; i < hist.length; i++) {
			System.out.println(i + " " + hist[i]);
		}
		System.out.println();*/
		
/*		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] A = new int [n];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int [] B = new int [m];
		for (int i = 0; i < B.length; i++) {
			B[i] = sc.nextInt();
		}
		
		missingNumbers(n, A, m, B);

	}

}
