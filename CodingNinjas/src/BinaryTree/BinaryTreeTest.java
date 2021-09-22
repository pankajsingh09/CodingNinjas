package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeTest {
	
	
	public static void nodeAtKDepth(BinaryTree<Integer>root,int count)
	{
		if(root==null)
			return;
		
		 if(count==0)
		{
			System.out.println("Node is "+root.data);
			return;
		}
		
		
		nodeAtKDepth(root.left, count-1);
		nodeAtKDepth(root.right, count-1);		
		
	}
	
	public static int noOFLeafNodes(BinaryTree<Integer>root)
	{
		if(root==null)
			return 0;
		
		else if(root.left==null && root.right==null)
			return 1;
		
		
		int left=noOFLeafNodes(root.left);
		int right=noOFLeafNodes(root.right);
		
		return left+right;
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
	
	public static int largestElement(BinaryTree<Integer>root)
	{
		if(root==null)
			return -1;
		
		int left=largestElement(root.left);
		int right=largestElement(root.right);
		int max=Math.max(left, right);
		max=Math.max(max, root.data);
		
		return max;
	}
	
	public static void postorder(BinaryTree<Integer>root)
	{
		if(root==null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void preorder(BinaryTree<Integer>root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void inorder(BinaryTree<Integer>root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static int noOfNodes(BinaryTree<Integer>root)
	{
		
		if(root==null)
			return 0;
		int left=noOfNodes(root.left);
		int right=noOfNodes(root.right);
		
		return left+right+1;
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
	
	public static BinaryTree<Integer> takeInput()
	{
		System.out.println("Enter Root Data");
		Scanner sc=new Scanner(System.in);
		
		int data=sc.nextInt();
		if(data==-1)
		{
			return null;
		}
			
		BinaryTree<Integer>root=new BinaryTree<Integer>(data);
		BinaryTree<Integer>rootL=takeInput();
		BinaryTree<Integer>rootR=takeInput();
		
		root.left=rootL;
		root.right=rootR;
		
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
	
	public static void print(BinaryTree<Integer>root)
	{
		if(root==null)
			return;
		
		System.out.println(root.data);
		print(root.left);
		print(root.right);
	}

	public static int diameter(BinaryTree<Integer>root)
	{
		
		if(root==null)
			return 0;
		
		
		int h=height(root.right)+height(root.left);
		int ld=diameter(root.left);
		int rd=diameter(root.right);
				
		return Math.max(h, Math.max(ld, rd));
	}
	
	public static Pair<Integer,Integer> diameter_Height(BinaryTree<Integer>root)
	{
		if(root==null)
		{
			Pair<Integer, Integer> output=new Pair<Integer, Integer>();
			output.first=0;
			output.second=0;
			return output;
		}
		
		Pair<Integer,Integer>ol=diameter_Height(root.left);
		Pair<Integer, Integer>or=diameter_Height(root.right);
		
		int height=1+Math.max(ol.first, or.first);
		int option1=ol.first+or.first;
		int option2=ol.second;
		int option3=or.second;
		
		int diameter=Math.max(option1, Math.max(option2, option3));
		Pair<Integer, Integer> output=new Pair<Integer, Integer>();
		output.first=height;
		output.second=diameter;
		return output;
		
		
	}
	
	
	public static BinaryTree<Integer> takeInputLevelWise()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the root data ");
		int rootdata=sc.nextInt();
		if(rootdata==-1)
			return null;
		
		BinaryTree<Integer>root=new BinaryTree<Integer>(rootdata);
		
		Queue<BinaryTree<Integer>> pendingChildrens=new LinkedList<BinaryTree<Integer>>();
		
		pendingChildrens.add(root);
		
		while(!pendingChildrens.isEmpty())
		{
			BinaryTree<Integer> front=pendingChildrens.remove();
			System.out.println("Enter left child of "+front.data);
			int leftData=sc.nextInt();
			if(leftData!=-1)
			{
				BinaryTree<Integer>leftChild=new BinaryTree<Integer>(leftData);
				front.left=leftChild;
				pendingChildrens.add(leftChild);
			}
			
			System.out.println("Enter right child of "+front.data);
			int rightData=sc.nextInt();
			if(rightData!=-1)
			{
				BinaryTree<Integer>rightChild=new BinaryTree<Integer>(rightData);
				front.right=rightChild;
				pendingChildrens.add(rightChild);
			}
		}
		
		return root;
		
		
		
	}
	
	public static void printLevelWise(BinaryTree<Integer>root)
	{
		if(root==null)
		{
			System.out.println("Null");
		}
		
		Queue<BinaryTree<Integer>> Nodes=new LinkedList<>();
		Nodes.add(root);
		
		while(!Nodes.isEmpty())
		{
			BinaryTree<Integer> child=Nodes.poll();
			System.out.print(child.data+" : ");
			if(child.left!=null)
			{
				Nodes.add(child.left);
				System.out.print("L"+child.left.data);
			}
			if(child.right!=null)
			{
				Nodes.add(child.right);
				System.out.print(", R"+child.right.data);
			}
			System.out.println();
			
			
		}	
			
	}
	
	
	public static boolean findElement(BinaryTree<Integer> root,int data)
	{
		if(root==null)
			return false;
		
		if(root.data==data)
			return true;
		
		else {
			if(root.data<data)
			{
				return findElement(root.right, data);
			}
			else {
				return findElement(root.left,data);
			}
		}
		
	}
	
	
	public static BinaryTree<Integer> createBST(int arr[],int low,int high)
	{
		
		if(low>high)
		{
			return null;
		}
		
		int mid=(low+high)/2;
		BinaryTree<Integer>root=new BinaryTree<Integer>(arr[mid]);
		root.left=createBST(arr,low,mid-1);
		root.right=createBST(arr,mid+1,high);
		
		return root;
		
	}
	
	public static int maximum(BinaryTree<Integer>root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		
		int lmax=maximum(root.left);
		int rmax=maximum(root.right);
		
		return Math.max(root.data, Math.max(lmax, rmax));
	}
	
	public static int minimum(BinaryTree<Integer>root)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		
		int lmin=minimum(root.left);
		int rmin=minimum(root.right);
		
		return Math.min(root.data, Math.max(lmin, rmin));
	}
	
	
	public static boolean isBST(BinaryTree<Integer>root)
	{
		if(root==null)
			return true;
		
		int lmax=maximum(root.left);
		if(lmax>root.data)
			return false;
		int rmin=minimum(root.right);
		if(rmin<root.data)
			return false;
		
		boolean isLBST=isBST(root.left);
		boolean isRBST=isBST(root.right);
		
		return isLBST&& isRBST;
	}
	
	
	public static IsBst isBalancedBST(BinaryTree<Integer>root)
	{
		if(root==null)
		{
			IsBst ans=new IsBst();
			ans.Rmin=Integer.MAX_VALUE;
			ans.Lmax=Integer.MIN_VALUE;
			ans.flag=true;
			return ans;
		}
		
		IsBst left=isBalancedBST(root.left);
		IsBst right=isBalancedBST(root.right);
		boolean flag=true;
		if(left.Lmax>root.data)
		{
			flag=false;
		}
		
		if(right.Rmin<root.data)
		{
			flag=false;
		}
		
		IsBst ans=new IsBst();
		ans.Lmax=Math.max(root.data, left.Lmax);
		ans.Rmin=Math.min(root.data, right.Rmin);
		ans.flag=flag && left.flag && right.flag;
		
		return ans;
		
	}
	
	public static boolean isBST3(BinaryTree<Integer> root,int minRange,int maxRange)
	{
		if(root==null)
			return true;
		
		if(root.data<minRange || root.data>maxRange)
			return false;
		
		boolean left=isBST3(root.left, minRange,root.data-1);
		boolean right=isBST3(root.right, root.data, maxRange);
		
		return left && right;
		
	}
	
	
	public static BinaryTree<Integer> buildTreeUsingTraversals(int in[],int l1,int r1,int pre[],int l2,int r2)
	{
		
		if(l1>r1 || l2> r2)
		{
			return null;
		}
		
		int rootData=pre[l2];
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootData);
		
		int inRootPos=-1;
		for(int i=l1;i<=r1;i++)
		{
			if(in[i]==rootData)
			{
				inRootPos=i;
				break;
			}
		}
		
		int preLeftPos=-1;
		
		for(int i=l2+1;i<=r2;i++)
		{
			if(pre[i]==in[inRootPos-1])
			{
				preLeftPos=i;
				break;
			}
		}
		
		root.left=buildTreeUsingTraversals(in, l1, inRootPos-1, pre, l2+1, preLeftPos);
		root.right=buildTreeUsingTraversals(in, inRootPos+1, r1, pre, preLeftPos+1, r2);
		
		
		return root;
		
	}
	
	public static void main(String[] args) {

//		BinaryTree<Integer>T=new BinaryTree<Integer>(1);
//		
//		
//		BinaryTree<Integer>TLeft=new BinaryTree<Integer>(2);
//		BinaryTree<Integer>TRight=new BinaryTree<Integer>(3);
//		T.left=TLeft;
//		T.right=TRight;
//		
//		
//		
//		
//		BinaryTree<Integer>T3=new BinaryTree<Integer>(4);
//		BinaryTree<Integer>T4=new BinaryTree<Integer>(5);
//		
//		TLeft.right=T3;
//		TRight.left=T4;
		
		
		// 1 3 6 -1 -1 8 -1 -1 2 -1 7 4 -1 -1 5 -1 -1 
//		
//		BinaryTree<Integer>root=TakeInputBetter(true,0,true);
//		printDetailed(root);
				/*
		System.out.println("No of nodes are : "+noOfNodes(root));
		
		System.out.println("\n inorder");
		inorder(root);
		
		System.out.println("\n postorder");
		postorder(root);
		
		System.out.println("\n preorder");
		preorder(root);
		
		System.out.println();
		
		System.out.println("Largest Element is "+largestElement(root));
		
		System.out.println("height "+height(root));
		
		System.out.println("No of Leaf Nodes "+noOFLeafNodes(root));
		
		nodeAtKDepth(root, 2);
		
		
		
		System.out.println("height is "+height(root));
		System.out.println("diameter is "+diameter(root));
		
		long t2=System.currentTimeMillis();
		System.out.println("Height is "+diameter_Height(root).first);
		System.out.println("diameter is "+diameter_Height(root).second);
		System.out.println(System.currentTimeMillis()-t2);
		*/
		
//		BinaryTree<Integer>root=takeInputLevelWise();
//
//		printLevelWise(root);
//		System.out.println(findElement(root, 5));
		
//		int arr[]= {1,2,3,4,5,6,7};
//		BinaryTree<Integer>root=createBST(arr, 0, arr.length-1);
//		printLevelWise(root);
		
//		long t1=System.currentTimeMillis();
//		System.out.println(System.currentTimeMillis()-t1);
		
//		System.out.println(isBST(root));
//
//		System.out.println(isBalancedBST(root).flag);
//		
//		System.out.println(isBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
		int in[]= {4,2,5,1,6,3,7};
		int pre[]= {1,2,4,5,3,6,7};
		
		BinaryTree<Integer>root=buildTreeUsingTraversals(in, 0, in.length-1, pre, 0, pre.length-1);
		printLevelWise(root);


		
		
	}

}
