package Tuesday;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> q = new MyQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(4);
		for (int i = 0; i < q.getSize(); i++) {
			System.out.println(q.dequeue());
		}

	}

}
