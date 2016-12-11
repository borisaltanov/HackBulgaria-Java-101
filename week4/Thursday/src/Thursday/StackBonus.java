package Thursday;

public class StackBonus implements MyStackInterface<Integer> {
	private MyStackInterface<Integer> l = new MyLinkedList<Integer>();
	private Integer minElement;
	private int size = 0;

	@Override
	public Integer pop() {
		if (l.getSize() == 0) {
			return null;
		}
		Integer elementToPop = l.peek();
		if (elementToPop.compareTo(this.minElement) >= 0) {
			elementToPop = l.pop();
		} else {
			minElement = 2 * minElement - elementToPop;
			elementToPop = l.pop();
		}
		this.size--;
		return elementToPop;

		
	}

	@Override
	public void push(Integer element) {
		if (l.getSize() == 0) {
			l.push(element);
			minElement = element;
		} else {
			if (element.compareTo(this.minElement) >= 0) {
				l.push(element);
			} else {
				l.push(2 * element - minElement);
				minElement = element;
			}
		}
		this.size++;
		
	}

	@Override
	public Integer peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	public Integer getMin() {
		return minElement;
	}
}
