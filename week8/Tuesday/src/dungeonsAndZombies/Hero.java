package dungeonsAndZombies;

public class Hero extends Character{
	private String name;
	private String title;
	private int manaRegenRate;

	public Hero(String name, String title, int health, int mana, int manaRegenRate) {
		super(health, mana);
		this.name = name;
		this.title = title;
		this.manaRegenRate = manaRegenRate;
	}

	public String knownAs() {
		return this.getName() + " the " + this.getTitle();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getManaRegenRate() {
		return manaRegenRate;
	}

	public void setManaRegenRate(int manaRegenRate) {
		this.manaRegenRate = manaRegenRate;
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
