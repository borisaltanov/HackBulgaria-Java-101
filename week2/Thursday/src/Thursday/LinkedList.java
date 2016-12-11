package Thursday;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	
	private class Node {
		T data;
		Node next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
		
		
	}
	
	Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public void add(T data) {
		if (head==null) {
			head = new Node(data);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}
	
	public void insertAfter(T after, T data) {
		Node temp = head;
		
		while(temp.next.data != after) {
			temp = temp.next;
		}
		
		Node n = new Node(data);
		n.next = temp.next;
		temp.next = n;
	}
	
	public String toString(){
		String result = "";
		Node temp = head;
		while (temp.next != null) {
			result += temp.data + ", ";
			temp = temp.next;
		}
		
		
		return result;
	}
	
	
	public class LLIterator implements Iterator<T> {
		private Node cursor;
		
		public LLIterator() {
			cursor = head;
		}

		@Override
		public boolean hasNext() {
			return cursor.next != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}
