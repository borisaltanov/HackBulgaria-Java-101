package Tuesday;

public class StackSort<T extends Comparable<T>> {
	private MyStackInterface<T> firstStack = new MyLinkedList<T>();
	private MyStackInterface<T> secondStack = new MyLinkedList<T>();
	
	public void fillFirstStack(T [] arr) {
		for (int i = 0; i < arr.length; i++) {
			firstStack.push(arr[i]);
		}
	}
	
	// sort
}
