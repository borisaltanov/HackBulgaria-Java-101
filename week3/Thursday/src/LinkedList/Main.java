package LinkedList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		l.addFirst(5);
		l.addFirst(3);
		l.addFirst(2);
		l.addFirst(8);
		l.addLast(7);
		l.addLast(10);
		l.add(12, 5);
		l.remove(1);
		
		
		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>();
		l2.addFirst(18);
		l2.addFirst(14);
		l2.addLast(11);
		l.addList(l2);
		l2.addFirst(29);
/*		System.out.println(l.getFirst());
		System.out.println(l.getLast());*/
		for (int i = 0; i < l.getSize(); i++) {
			System.out.println(l.get(i));
		}
		
		
/*		System.out.println();
		System.out.println(l.findKthLast(3));
		l.deleteElemInMiddle(l.getNode(3));
		System.out.println();*/
		
		System.out.println("Con " + l.connectedList(l2));
		
		l.partition(7);
		
		System.out.println();
		for (int i = 0; i < l.getSize(); i++) {
			System.out.println(l.get(i));
		}
		
		//System.out.println("fdsfsd" + l.getNode(0).data.compareTo(3));
		
		MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();
		l3.add(1, 0);
		l3.add(2, 1);
		l3.add(3, 2);
		l3.add(3, 3);
		l3.add(2, 4);
		l3.add(1, 5);
		l3.setNodeNext(l3.getNode(5), l3.getNode(2));
		System.out.println(l3.hasLoop());
		System.out.println(l3.firstNodeInLoop());
		//System.out.println(l3.isPalindrome());
		
		MyLinkedList<Integer> l4 = new MyLinkedList<Integer>();
		l4.add(1, 0);
		l4.add(2, 1);
		l4.add(6, 2);
		l4.add(3, 3);
		l4.add(2, 4);
		l4.add(1, 5);
		
		l4.partition(3);
		
		System.out.println();
		for (int i = 0; i < l4.getSize(); i++) {
			System.out.println(l4.get(i));
		}
		
				
				
				
				
		}

}
