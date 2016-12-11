package Thursday;

public class StackSort<T extends Comparable<T>> {
	private MyStackInterface<T> firstStack = new MyLinkedList<T>();
	private MyStackInterface<T> secondStack = new MyLinkedList<T>();
	
	public StackSort(T [] arr) {
		fillFirstStack(arr);
	}
	
	private void fillFirstStack(T [] arr) {
		for (int i = 0; i < arr.length; i++) {
			firstStack.push(arr[i]);
		}
	}
	
	public void sortStack() {
		while (firstStack.getSize() != 0) {
			if (secondStack.getSize() == 0) {
				secondStack.push(firstStack.pop());
			} else if (firstStack.peek().compareTo(secondStack.peek()) > 0) {
				secondStack.push(firstStack.pop());
			} else {
				T temp = firstStack.pop();
				while (secondStack.getSize() > 0 && temp.compareTo(secondStack.peek()) < 0) {
					firstStack.push(secondStack.pop());
				}
				secondStack.push(temp);				
			}
		}
		
	}
	public void output() {
		while(secondStack.getSize() != 0) {
			System.out.println(secondStack.pop());
		}
	}
	
}
