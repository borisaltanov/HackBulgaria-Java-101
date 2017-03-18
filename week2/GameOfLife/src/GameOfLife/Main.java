package GameOfLife;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int numberOfPoints = scanner.nextInt();
		
		GameOfLifeBetter game = new GameOfLifeBetter(20);
		
		for (int i = 0; i < numberOfPoints; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			game.insert(x, y);
		}
		
		scanner.close();
		
		System.out.println(game);
		
		while(true) {
			game.nextGeneration();
			System.out.println(game);
			Thread.sleep(200);
			System.out.println("\n\n");
		}

	}

}
