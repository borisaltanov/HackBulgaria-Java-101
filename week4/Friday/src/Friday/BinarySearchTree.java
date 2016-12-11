package Friday;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {
	private class Node {
		private T data;
		private Node left;
		private Node right;
		
		public Node (T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		
	}
	
	private Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	private Node insertNode(Node current, T element) {
		if (current == null) {
			current = new Node(element);
		} else if (element.compareTo(current.data) < 0) {
			current.left =  insertNode(current.left, element);
		} else {
			current.right = insertNode(current.right, element);
		}
		return current;
		
	}
	
	 String traverseInOrder(Node current) {
		String result = "";
		if (current.left != null) {
			result += traverseInOrder(current.left);
		}
			result += current.data.toString() + ", ";
		if (current.right != null) {
			result += traverseInOrder(current.right);
		}
		return result;
	}
	
	private boolean findNode(Node current, T element) {
		boolean found = false;
		if (current.data.compareTo(element) == 0) {
			found = true;
		} else if (current.left != null && current.data.compareTo(element) > 0) {
			found = findNode(current.left, element);
		} else if (current.right != null) {
			found = findNode(current.right, element);
		}
		return found;
	}
	
	private Node findMin(Node current) {
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	private Node removeNode(Node current, T element) {
		if (current == null) {
        	return null;
        }
        if (current.left == null && current.right == null) {
        	return null;
        }
        if (current.data.compareTo(element) > 0) {
        	current.left = removeNode(current.left, element);
        } else if (current.data.compareTo(element) < 0) {
        	current.right = removeNode(current.right, element);
        } else {
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;
            
            current.data = findMin(current.right).data;
            current.right = removeNode(current.right, current.data);
        }
        return current;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	private boolean isEqualRec(Node lhs, Node rhs) {
		// find a solution
	/*	if (lhs == null && rhs == null) {
			return true;
		}
		if (lhs != null && rhs != null) {
			boolean values = lhs.data.compareTo(rhs.data) != 0;
			boolean leftSubtree = isEqualRec(lhs.left, rhs.left);
			boolean rightSubtree = isEqualRec(lhs.right, rhs.right);
			return values && leftSubtree && rightSubtree;
		}*/
		return false;
		
	}
	
	public boolean isEqual(Node other) {
		return isEqualRec(root, other);
	}
	
	
	@Override
	public void insert(T element) {
		root = insertNode(root, element);
	}
	
	@Override
	public void remove(T element) {
		root = removeNode(root, element);
	}
	
	@Override
	public boolean find(T element) {
		return findNode(root, element);
	}
	
	public String toString() {
		return traverseInOrder(root);
	}
	
	

}
