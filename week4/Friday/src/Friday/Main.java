package Friday;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(14);
		bst.insert(10);
		bst.insert(8);
		bst.insert(9);
		bst.insert(18);
		bst.insert(22);
		bst.insert(11);
		bst.insert(5);
		bst.insert(16);
		bst.insert(17);
		bst.insert(15);
		bst.insert(19);
		bst.insert(21);
		
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
		bst2.insert(14);
		bst2.insert(10);
		bst2.insert(8);
		bst2.insert(9);
		bst2.insert(18);
		bst2.insert(22);
		bst2.insert(11);
		bst2.insert(5);
		bst2.insert(17);
		bst2.insert(15);
		bst2.insert(19);
		bst2.insert(21);
		
		System.out.println(bst.isEqual(bst2.getRoot()));
		
		System.out.println(bst);
		
		bst.remove(17);
		System.out.println(bst);
		
		System.out.println(bst.isEqual(bst2.getRoot()));
		

	}

}
