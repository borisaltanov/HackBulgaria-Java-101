package dungeonsAndZombies;

public class Fight {
	private Hero h;
	private String attackType;
	private Enemy e;
	
	public Fight(Hero hero, Enemy enemy, String attackType) {
		this.h = hero;
		this.e = enemy;
		this.attackType = attackType;
	}
	
	public void fight(){
		while(h.isAlive() && e.isAlive()) {
			System.out.println(h.getCurrentHealth());
			e.takaDamage(h.attack(this.attackType));
			System.out.println(e.getCurrentHealth());
			if (e.isAlive()) {
				h.takaDamage(e.attack());
				System.out.println(h.getCurrentHealth());
			}
		}
	}
}
