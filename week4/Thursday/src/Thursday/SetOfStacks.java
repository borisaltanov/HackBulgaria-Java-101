package Thursday;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<T extends Comparable<T>> implements MyStackInterface<T>{
	private ArrayList<Stack<T>> set = new ArrayList<Stack<T>>();
	private int maxHigh = 0;
	private int indexOfStack = 0;
	
	public SetOfStacks(int maxHigh) {
		// TODO Auto-generated constructor stub
		this.maxHigh = maxHigh;
		this.indexOfStack = 0;
		Stack<T> s = new Stack<>();
		this.set.add(s);
	}
	

	@Override
	public T pop() {
		T elementToPop = null;
		if (set.get(indexOfStack).size() > 0) {
			elementToPop = set.get(indexOfStack).pop();
		} else {
			set.remove(indexOfStack);
			indexOfStack--;
			elementToPop = set.get(indexOfStack).pop();
		}
		return elementToPop;
	}

	@Override
	public void push(T element) {
		if (set.get(indexOfStack).size() < this.maxHigh) {
			set.get(indexOfStack).push(element);
		} else {
			indexOfStack++;
			Stack<T> s = new Stack<>();
			this.set.add(s);
			set.get(indexOfStack).push(element);
		}
		
	}

	@Override
	public T peek() {
		return set.get(indexOfStack).peek();
	}

	@Override
	public int getSize() {
		return maxHigh * (indexOfStack) + set.get(indexOfStack).size();
	}

}
