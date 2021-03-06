package week02;

import java.util.Vector;

public class Polynomial {
	public Vector<Integer> members = new Vector(10);
	
	public void add(int coeff, int power) {
		members.insertElementAt(coeff, power);
	}
	
	public Polynomial sum (Polynomial lhs, Polynomial rhs) {
		Polynomial result = new Polynomial();
		int size = lhs.members.size() > rhs.members.size() ? lhs.members.size() : rhs.members.size();
		for(int i = 0; i < size ; i++) {
			int tempEl = lhs.members.elementAt(i) + rhs.members.elementAt(i);
			result.add(tempEl, i);
		}
		return result;
	}
	
	public Polynomial substract (Polynomial lhs, Polynomial rhs) {
		Polynomial result = new Polynomial();
		int size = lhs.members.size() > rhs.members.size() ? lhs.members.size() : rhs.members.size();
		for(int i = 0; i < size ; i++) {
			int tempEl = lhs.members.elementAt(i) - rhs.members.elementAt(i);
			result.add(tempEl, i);
		}
		return result;
	}
	
	public Polynomial multiply (Polynomial lhs, Polynomial rhs) {
		Polynomial result = new Polynomial();
		int size = lhs.members.size() > rhs.members.size() ? lhs.members.size() : rhs.members.size();
		for(int i = 0; i < size ; i++) {
			int tempEl = lhs.members.elementAt(i) * rhs.members.elementAt(i);
			result.add(tempEl, i);
		}
		return result;
	}
	
	public Polynomial multiplyNumber (Polynomial lhs, int multiplicator) {
		Polynomial result = new Polynomial();
		for(int i = 0; i < lhs.members.size() ; i++) {
			int tempEl = lhs.members.elementAt(i) * multiplicator;
			result.add(tempEl, i);
		}
		return result;
	}
	
	public Polynomial derivative (Polynomial lhs) {
		Polynomial result = new Polynomial();
		for(int i = 1; i < lhs.members.size() ; i++) {
			int tempEl = lhs.members.elementAt(i) * i;
			result.add(tempEl, i - 1);
		}
		return result;
	}
	
	
	
	public String toString() {
		String result = "";
		for(int i = members.size() - 1; i > -1; i--) {
			result += members.elementAt(i) + "x^" + i + " ";
		}
		return result;
	}

}
