package daaa;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 3, 3, 5, 7};
		int b[] = {2, 4, 5, 6, 8};
		 
		Arrays.sort(a);
		Arrays.sort(b);
		 
		int i = 0;
		int j = 0;
		 
		int temp;
		while (j < b.length) {
			
		    if (a[i] < b[j]) {
		        System.out.print(a[i] + " ");
		        temp = a[i++];
		        
		    } else if (a[i] > b[j]) {
		        System.out.print(b[j] + " ");
		    	temp = b[j++];
		    } else {
		    	System.out.print(a[i] + " ");
		    	temp = a[i++];
		    	j++;
		    }
		    
		}
	}

}
