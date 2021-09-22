package bst;

import BinaryTree.BinaryTree;

public class BST {
	
	private BinaryTree<Integer> root;
	private int size;
	
	
	private static BinaryTree<Integer> insertHelper(BinaryTree<Integer>root,int x)
	{
		if(root==null)
		{
			BinaryTree<Integer>node=new BinaryTree<Integer>(x);
			
			return node;
			
		}
		if(root.data<=x)
		{
			BinaryTree<Integer>right=insertHelper(root.right, x);
			root.right=right;
			return root;
		}
		else 
		{
			BinaryTree<Integer>left=insertHelper(root.left, x);
			root.left=left;
			return root;
		}
	}
	
	public void insert(int x)
	{
		root=insertHelper(root, x);
		size++;
	}
	
	private static void printHelper(BinaryTree<Integer>root)
	{
		
			if(root==null)
				return;
			
			System.out.print(root.data+" : ");
			if(root.left!=null)
			{
				System.out.print("L"+root.left.data+" , ");
			}
			if(root.right!=null)
			{
				System.out.print("R"+root.right.data);
			}
			
			System.out.println();
			
			
			
			printHelper(root.left);
			printHelper(root.right);
		}
	
	
	public void print()
	{
		printHelper(root);
	}
	
	public  int size()
	{
		return this.size;
	}
	
	private static boolean isPresentHelper(BinaryTree<Integer>root,int x)
	{
		if(root==null)
			return false;
		if(root.data==x)
			return true;
		
		if(root.data<x)
		{
			return isPresentHelper(root.right, x);
		}
		else {
			return isPresentHelper(root.left, x);
		}
	}
	
	public boolean isPresent(int x)
	{
		return isPresentHelper(root, x);
	}
}
