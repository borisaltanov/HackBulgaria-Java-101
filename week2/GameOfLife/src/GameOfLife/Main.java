package GameOfLife;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int numberOfPoints = scanner.nextInt();
		
		GameOfLife game = new GameOfLife(20);
		
		for (int i = 0; i < numberOfPoints; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			game.fillSquare(x, y);
		}
		
		scanner.close();
		
		System.out.println(game);
		
		while(true) {
			game.mark();
			System.out.println(game);
			Thread.sleep(200);
			System.out.println("\n\n");
		}

	}

}
