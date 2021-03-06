package Thursday;

import java.util.Arrays;
import java.util.List;


public class Main {

	public static class Node {
		private int value;
		private Node left;
		private Node right;
		
		public Node (int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public static Node build(List<Integer> values){
			if (values.isEmpty()) {
				return null;
			}
			
			int middle = values.size() / 2;
			int value = values.get(middle);
			
			Node left = build(values.subList(0, middle));
			Node right = build(values.subList(middle + 1, values.size()));
			
			return new Node(value, left, right);
			
		}
		
		public void print(String prefix) {
			if(left != null) {
				left.print(prefix + " ");
			}
			System.out.print(prefix);
			System.out.println(value);
			if(right != null) {
				right.print(prefix + " ");
			}
		}
		
		public static int numberOfNodes(Node node) {
			if (node == null){
				return 0;
			}
			return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
		}
		
		public int size() {
			int size = 1;
			if(left != null) {
				size += left.size();
			}
			if(right != null) {
				size += right.size();
			}
			return size;
		}
		
		public int depth() {
			int leftDepth = 1;
			int rightDepth = 1;
			if(left != null) {
				leftDepth += left.depth();
			}
			if(right != null) {
				rightDepth += right.depth();
			}
			return leftDepth > rightDepth ? leftDepth: rightDepth;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> values = Arrays.asList(1,2,3,6,7,10,12,15,20,23,28, 30, 33, 40, 50);
		Node root = Node.build(values);
		root.print("");
		System.out.println(root.numberOfNodes(root));
		System.out.println(root.size());
		System.out.println(root.depth());
		
		
	}

}
