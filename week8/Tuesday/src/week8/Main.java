package week8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int zombiesCount = input.nextInt();
		int zombiesHealth = input.nextInt();
		int counter = 0;
		
		Axe weapon = new Axe();
		
		
		for (int i = 0; i < zombiesCount; i++) {
			int oneZombieHealth = zombiesHealth;
			while(oneZombieHealth > 0) {
				oneZombieHealth -= weapon.hit();
				counter++;
			}
		}
		

		System.out.println(counter);
		
	}

}
