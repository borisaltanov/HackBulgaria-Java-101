package LinkedList;

import java.util.HashSet;
import java.util.Stack;

public class MyLinkedList<T extends Comparable<T>> implements MyLinkedListInterface<T>{
	private class Node {
		T data;
		Node next = null;
		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	private Node head;
	private int size = 0;
	
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
		size = 0;
	}
	
	@Override
	/**
	 * O(1)
	 */
	public void addFirst(T newElement) {
		// TODO Auto-generated method stub
		Node newEl = new Node(newElement);
		newEl.next = head;
		head = newEl;
		size++;		
	}

	@Override
	/**
	 * O(n)
	 */
	public void addLast(T newElement) {
		// TODO Auto-generated method stub
		Node temp = head;
		Node newEl = new Node(newElement);
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = newEl;
		size++;
	}

	@Override
	/**
	 * O(n)
	 */
	public void add(T newElement, int index) {
		// TODO Auto-generated method stub
		if (index == 0) {
			this.addFirst(newElement);
		}
		else if(index < size) {
			Node temp = head;
			Node newEl = new Node(newElement);
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			newEl.next = temp.next;
			temp.next = newEl;
			size++;
		}
		else if(index == size) {
			this.addLast(newElement);
		}

		
	}

	@Override
	/**
	 * O(1)
	 */
	public T getFirst() {
		// TODO Auto-generated method stub
		return head.data;
	}

	@Override
	/**
	 * O(n)
	 */
	public T getLast() {
		// TODO Auto-generated method stub
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	@Override
	/**
	 * O(n)
	 */
	public T get(int index) {
		if (index == 0) {
			return this.getFirst();
		}
		else if (index < size) {
			Node temp = head;
			for(int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
		return null;
	}
	
	/**
	 * O(n)
	 * @param index
	 * @return
	 */
	public Node getNode(int index) {
		if (index == 0) {
			return head;
		}
		else if (index < size) {
			Node temp = head;
			for(int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		}
		return null;
	}
	
	/**
	 * O(1)
	 * @param n
	 * @param next
	 */
	public void setNodeNext(Node n, Node next) {
		n.next = next;
	}

	@Override
	/**
	 * 
	 */
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void remove(int index) {
		if(index == 0) {
			head = head.next;
			size--;
		}
		else if (index < size) {
			Node temp = head;
			for (int i = 1; i <index; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;
		}
	}

	@Override
	public void addList(MyLinkedListInterface<T> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.getSize(); i++) {
			T tempEl = list.get(i);
			this.addLast(tempEl);
		}
		
	}
	
	public T findKthLast(int k) {
		Node goToEnd = head;
		Node goToK = head;
		
		for (int i = 0; i < k; i++) {
			goToEnd = goToEnd.next;
		}
		
		while(goToEnd != null) {
			goToEnd = goToEnd.next;
			goToK = goToK.next;
		}
		return goToK.data;
	}
	
	public void deleteElemInMiddle(Node n) {
		Node temp = n;
		temp.data = temp.next.data;
		temp.next = temp.next.next;
		size--;
	}
	
	public void partition(T x) {
		Node less = null;
		Node more = null;
		Node lessFirst = null;
		Node moreFirst = null;
		Node temp = head;
		while(temp != null) {
			if (temp.data.compareTo(x) < 0) {
				if (less == null) {
					less = temp;
					lessFirst = temp;
				} else {
					less.next = temp;
					less = less.next;
				}
			} else {
				if (more == null) {
					more = temp;
					moreFirst = temp;
				} else {
					more.next = temp;
					more = more.next;
				}
			}
			temp = temp.next;
		}
		
		if (less == null) {
			head = moreFirst;
		} else {
			less.next = moreFirst;
			head = lessFirst;
		}
		
		
		
	}
	
	public T connectedList(MyLinkedList<T> other) {
		Node temp = head;
		Node temp2 = other.head;
		int bla = Math.abs(this.size - other.size);
		for(int i = 0; i < bla; i++) {
			temp = temp.next;
		}
		while(temp != null) {
			if(temp == temp2) {
				return temp.data;
			}
			temp = temp.next;
			temp2 = temp2.next;
		}
		return null;
	}
	
	// hare and turle floyd
	public boolean hasLoop() {
		HashSet<Node> tempH = new HashSet<>();
		Node temp = head;
		while(temp.next != null) {
			if (tempH.contains(temp) == true) {
				return true;
			}
			tempH.add(temp);
			temp = temp.next;
			
		}
		return false;
	}
	
	// if floyd -> use previous two tasks 
	public T firstNodeInLoop() {
		HashSet<Node> tempH = new HashSet<>();
		Node temp = head;
		while(temp.next != null) {
			if (tempH.contains(temp) == true) {
				return temp.data;
			}
			tempH.add(temp);
			temp = temp.next;
			
		}
		return null;
	}
	
	
	public boolean isPalindrome() {
		Stack<Node> tempS = new Stack<>();
		Node temp = head;
		while(temp.next != null) {
			tempS.push(temp);
			temp = temp.next;
		}
		tempS.push(temp);
		temp = head;
		while(temp.next != null) {
			Node compare = tempS.pop();
			if (temp.data != compare.data) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}

/*	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	
/*	private T getFirstCommon(Node firstNode, Node secondNode) {
		Node firstStart = firstNode;
		Node secondStart = secondNode;
		
		int countRestarts = 0;
		
		while (firstNode != secondNode && countRestarts < 3) {
			if (firstNode.next == null) {
				firstNode = secondStart;
				countRestarts++;
			} else {
				firstNode = firstNode.next;
			}
			if (secondNode.next == null) {
				secondNode = firstStart;
			} else {
				secondNode = secondNode.next;
				countRestarts++;
			}
		}
		
		T result = null;
		if (firstNode == secondNode) {
			result = firstNode.data;
		}
		return result;
	}
*/
	
	
	
	
	
	
	
	
	
	
	



}
