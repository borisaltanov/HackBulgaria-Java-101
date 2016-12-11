package Tuesday;

public class StackBonus<T extends Comparable<T>> implements MyStackInterface<T> {
	private MyStackInterface<T> l = new MyLinkedList<T>();
	private T minElement;

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(T element) {
		if (l.getSize() == 0) {
			l.push(element);
			minElement = element;
		} else {
			l.push(element);
			if (element.compareTo(this.minElement) == -1) {
				minElement = element;
			}
		}
		
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public T getMin() {
		return minElement;S
	}
}
