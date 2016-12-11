package week8;

public class ToSmash {
	int damage;
	int durability;
	int maxDurability;
	
	public ToSmash(int damage, int durability) {
		this.damage = damage;
		this.durability = durability;
		this.maxDurability = durability;
	}
	
	public int hit() {
		if(durability > 0 && durability >= maxDurability/2) {
			durability--;
			return damage;
		}
		if(damage > 1) {
			damage--;
		}
		return damage;
	}
}
