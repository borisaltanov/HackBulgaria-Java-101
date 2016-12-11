package dungeonsAndZombies;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] map = {{'S','.','#','#','.','.','.','.','.','T'},
						{'#','T','#','#','.','.','#','#','#','.'},
						{'#','.','#','#','#','E','#','#','#','E'},
						{'#','.','E','.','.','.','#','#','#','.'},
						{'#','#','#','T','#','#','#','#','#','G'}};
		
		Dungeon d = new Dungeon(map);
		Hero h = new Hero("Birad", "Dragonslayer", 100, 100, 5);
		d.spawn(h);
		d.printMap();
		d.move("left");
		d.printMap();
		d.move("up");
		d.printMap();

	}

}
