package dungeonsAndZombies;

public class Hero extends Character{
	private String name;
	private String title;
	private int manaRegenRate;
	private Weapon weapon;
	private Spell spell;

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
	
	public void equip(Weapon w) {
		this.weapon = w;
	}
	
	public void learn(Spell s) {
		this.spell = s;
	}


	@Override
	public int attack(String type) {
		if (type == "weapon") {
			return this.weapon.getDamage();
		}
		if (type == "spell" && this.canCast(this.spell)) {
			return this.spell.getDamage();
		}
		return 0;
	}

	@Override
	public boolean canCast(Spell s) {
		// TODO Auto-generated method stub
		return this.getCurrentMana() > s.getManaCost();
	}
	
}
