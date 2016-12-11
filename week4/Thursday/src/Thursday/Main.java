package Thursday;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		MyQueue<Integer> q = new MyQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(4);
		for (int i = 0; i < q.getSize(); i++) {
			System.out.println(q.dequeue());
		}
		
		Integer [] arr = {-3,14,18,-5,30};
		
		StackSort<Integer> s = new StackSort<Integer>(arr);
		
		s.sortStack();
		System.out.println();
		s.output();
		
		SetOfStacks<Integer> ss = new SetOfStacks<>(10);
		for (int i = 0; i < 47; i++) {
			ss.push(i);
		}
		System.out.println("size: " + ss.getSize());
		for (int i = 0; i < 47; i++) {
			System.out.println(ss.pop());
		}*/
		
		StackBonus sb = new StackBonus();
		sb.push(3);
		System.out.println(sb.getMin());
		sb.push(5);
		System.out.println(sb.getMin());
		sb.push(2);
		System.out.println(sb.getMin());
		sb.push(1);
		System.out.println(sb.getMin());
		sb.push(1);
		System.out.println(sb.getMin());
		sb.push(-1);
		System.out.println(sb.getMin());
		
		System.out.println();
		
		while (sb.getSize() != 0) {
			System.out.println(sb.getMin());
			sb.pop();
		}
	}

}
