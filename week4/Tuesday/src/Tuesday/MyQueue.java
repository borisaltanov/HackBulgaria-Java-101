package Tuesday;

public class MyQueue<T extends Comparable<T>> implements MyQueueInterface<T>{
	private MyStackInterface<T> fillbox = new MyLinkedList<T>();
	private MyStackInterface<T> outbox = new MyLinkedList<T>();
	private int size = 0;
	
	

	@Override
	public void enqueue(T element) {
		fillbox.push(element);
		size++;
	}

	private void fillOutbox() {
		if (outbox.getSize() == 0) {
			while(fillbox.getSize() != 0) {
				outbox.push(fillbox.pop());
			}
		}
	}
	
	@Override
	public T dequeue() {
		fillOutbox();
		return outbox.pop();
	}



	@Override
	public T peek() {
		fillOutbox();
		return outbox.peek();
	}
	

	@Override
	public int getSize() {
		return this.size;
	}
	
	
}
