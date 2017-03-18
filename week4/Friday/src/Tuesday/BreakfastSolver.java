package Tuesday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BreakfastSolver {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				System.out.println(solve(sc));
			}
		}
 	}

	private static int solve(Scanner sc) {
		// TODO Auto-generated method stub
		int pancakesCount = sc.nextInt();
		int hotPlatesCount = sc.nextInt();
		
		ArrayList<Integer> hotPlates = new ArrayList<Integer>();
		for (int i = 0; i < hotPlatesCount; i++) {
			hotPlates.add(sc.nextInt());
		}
		
		
		int minimumTime = calculateMinimumTime(pancakesCount, hotPlatesCount, hotPlates);
		
		return minimumTime;
	}

	private static int calculateMinimumTime(int pancakesCount, int hotPlatesCount, ArrayList<Integer> hotPlates) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = Collections.max(hotPlates) * pancakesCount;
		
		while(low < high) {
			int mid = low + ((high - low)/2);
			
			if(canCookMekici(pancakesCount, hotPlatesCount, hotPlates, mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}

	private static boolean canCookMekici(int pancakesCount, int hotPlatesCount, ArrayList<Integer> hotPlates, int availableTime) {
		// TODO Auto-generated method stub
		int cookedPancakes = 0;
		
		for (Integer hotPlate : hotPlates) {
			cookedPancakes += availableTime/ hotPlate;
		}
		return cookedPancakes >= pancakesCount;
	}
}
