package bst;

public class BstUse {

	public static void main(String[] args) {

		BST tree=new BST();
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(5);
		tree.insert(6);
		tree.insert(8);
		tree.print();
		System.out.println(tree.size());
		System.out.println(tree.isPresent(8));
		
	}

}
