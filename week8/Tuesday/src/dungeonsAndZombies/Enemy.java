package dungeonsAndZombies;

public class Enemy extends Character{
	private int damage;

	public Enemy(int health, int mana, int damage) {
		super(health, mana);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	@Override
	public boolean canCast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean attack() {
		// TODO Auto-generated method stub
		return false;
	}

}
