package BinaryTree;

import java.util.Scanner;

public class BinaryTreeTest2 {
	
	
	public static BinaryTree<Integer> removeNode(BinaryTree<Integer>root)
	{
		if(root==null)
			return null;
		if(root!=null && root.left==null && root.right==null)
		{		
			return null;
		}
		
		root.left=removeNode(root.left);
		root.right=removeNode(root.right);
		
		return root;
	}
	
	
	public static BinaryTree<Integer>TakeInputBetter(boolean isRoot,int rootData,boolean isLeft)
	{
		if(isRoot)
		{
			System.out.println("Enter Root data ");
		}
		else {
			if(isLeft)
			{
				System.out.println("Enter Left child data of "+rootData);
			}
			else {
				System.out.println("Enter Right child data of "+rootData);
			}
		}
		
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		
		if(data==-1)
			return null;
		
		BinaryTree<Integer>root=new BinaryTree<Integer>(data);
		BinaryTree<Integer>left=TakeInputBetter(false,data,true);
		BinaryTree<Integer>right=TakeInputBetter(false,data,false);
		
		root.left=left;
		root.right=right;
		return root;
		
		
	}
	
	public static void printDetailed(BinaryTree<Integer>root)
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
		
		
		
		printDetailed(root.left);
		printDetailed(root.right);
	}
	
	public static int height(BinaryTree<Integer>root)
	{
		if(root==null)
			return 0;
		
		int left=height(root.left);
		int right=height(root.right);
		
		int max=Math.max(left, right);
		
		return max+1;
		
		
	}
	
	public static boolean isBalance(BinaryTree<Integer>root)
	{
		
		if(root==null)
			return true;
		
		int lh=height(root.left);
		int rh=height(root.right);
		int ans=Math.abs(lh-rh);
		
		boolean lb=isBalance(root.left);
		boolean rb=isBalance(root.right);
		
		return (lb&rb&(ans<=1));
		
		
		
	}
	
	
	public static IsTreeBalanced isBalancedBetter(BinaryTree<Integer>root)
	{
		if(root==null)
		{
			IsTreeBalanced ans=new IsTreeBalanced();
			ans.height=0;
			ans.isBal=true;
			return ans;
		}
		
		
		
		IsTreeBalanced left=isBalancedBetter(root.left);
		IsTreeBalanced right=isBalancedBetter(root.right);
		boolean isBalanced=true;
		int height=Math.max(left.height, right.height)+1;
		
		if(Math.abs(left.height-right.height)>1)
		{
			isBalanced=false;
			
		}
		
		if(left.isBal==false || right.isBal==false)
		{
			isBalanced=false;
			
		}
		
		 IsTreeBalanced ans=new IsTreeBalanced();
		 ans.height=height;
		 ans.isBal=isBalanced;
		 return ans;
	}


	public static void main(String[] args) {

		BinaryTree<Integer>root=TakeInputBetter(true,0,true);
		printDetailed(root);
//		root=removeNode(root);
//		System.out.println("--------------------------");
//		printDetailed(root);
		
		System.out.println(isBalance(root));
		System.out.println(isBalancedBetter(root).isBal);
		
		
		
		
		
	}

}
