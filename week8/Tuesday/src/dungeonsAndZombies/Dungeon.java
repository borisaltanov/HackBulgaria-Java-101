package dungeonsAndZombies;

import java.util.ArrayList;

public class Dungeon {
	private char[][] map;
	private Hero h;
	private Enemy e = new Enemy(30, 20, 15);
	private int[] heroPosition = new int[2];
	
	public void setHeroPosition(int x, int y) {
		this.heroPosition[0] = x;
		this.heroPosition[1] = y;
	}
	
	public Dungeon(char[][] map){
		this.map = map;
	}

	public void heroAttack(String type) {
		Fight f = new Fight(h, e, type);
		f.fight();
	}
	
	
	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean spawn(Hero h) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 'S') {
					map[i][j] = 'H';
					this.h = h;
					this.heroPosition[0] = i;
					this.heroPosition[1] = j;
					return true;
				}
			}
		}
		return false;
	}
	
	private void move(Hero h, String direction) {
		if (direction == "down" && heroPosition[0] + 1 < map.length) {
			if(map[heroPosition[0] + 1][heroPosition[1]] != '#') {
				map[heroPosition[0]][heroPosition[1]] = '.';
				map[heroPosition[0] + 1][heroPosition[1]] = 'H';
				this.h.setCurrentMana(h.getCurrentMana() + h.getManaRegenRate());	
				this.setHeroPosition(heroPosition[0] + 1, heroPosition[1]);
			}
		}
		if (direction == "up" && heroPosition[0] - 1 > 0) {
			if(map[heroPosition[0] - 1][heroPosition[1]] != '#') {
				map[heroPosition[0]][heroPosition[1]] = '.';
				map[heroPosition[0] - 1][heroPosition[1]] = 'H';
				this.h.setCurrentMana(h.getCurrentMana() + h.getManaRegenRate());				
			}
		}
		if (direction == "left" && heroPosition[1] + 1 < map[0].length) {
			if(map[heroPosition[0]][heroPosition[1] + 1] != '#') {
				map[heroPosition[0]][heroPosition[1]] = '.';
				if (map[heroPosition[0]][heroPosition[1] + 1] == 'E') {
					this.heroAttack("weapon");
				}
				map[heroPosition[0]][heroPosition[1] + 1] = 'H';
				this.h.setCurrentMana(h.getCurrentMana() + h.getManaRegenRate());	
				this.setHeroPosition(heroPosition[0], heroPosition[1] + 1);
			}
		}
		if (direction == "right" && heroPosition[1] - 1 > 0) {
			if(map[heroPosition[0]][heroPosition[1] - 1] != '#') {
				map[heroPosition[0]][heroPosition[1]] = '.';
				map[heroPosition[0]][heroPosition[1] - 1] = 'H';
				this.h.setCurrentMana(h.getCurrentMana() + h.getManaRegenRate());				
			}
		}
	}
	
	public void move(String direction){
		switch (direction) {
		case "up": move(this.h, "up"); break;
		case "down": move(this.h, "down"); break;
		case "left": move(this.h, "left"); break;
		case "right": move(this.h, "right"); break;
		default:
			break;
		}
	}
	
}
