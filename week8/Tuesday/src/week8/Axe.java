package week8;


public class Axe extends ToSmash{

	public Axe() {
		super(10, 50);
	}
	
	public String toString() {
		return "Axe " + damage + " " + durability;
	}
}
