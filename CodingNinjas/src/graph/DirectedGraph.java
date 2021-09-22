package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;
public class DirectedGraph {
	
	
	public static void DFS(int edges[][])
	{
		boolean visited[]=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				printDFSHelper(edges,i,visited);
			}
		}
	}
	
	private static void printDFSHelper(int[][] edges, int sv, boolean[] visited) {
		
		System.out.println(sv);
		visited[sv]=true;
		
		for(int i=0;i<edges.length;i++)
		{
			if(edges[sv][i]==1 && !visited[i])
			{
				printDFSHelper(edges, i, visited);
			}
		}
	}
	
	public static void BFS(int edges[][])
	{
		boolean visited[]=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				printBFSHelper(edges, i, visited);
			}
		}
	}
	
	public static void printBFSHelper(int [][]edges,int sv,boolean visited[])
	{
		
		Queue<Integer> traverse=new LinkedList<>();
		traverse.add(sv);
		visited[sv]=true;
		while(!traverse.isEmpty())
		{
			int front=traverse.poll();
			
			System.out.println(front);
			for(int i=0;i<edges.length;i++)
			{
				if(edges[front][i]==1 && !visited[i])
				{
					visited[i]=true;
					traverse.add(i);
				}
			}
		}
	}
	
	public static boolean hashPath(int edges[][],int sv,int ev)
	{
		boolean visited[]=new boolean[edges.length];
		return hashPathHelper(edges, sv, ev, visited);
	}
	
	public  static boolean hashPathHelper(int edges[][],int sv,int ev,boolean visited[])
	{
		if(edges[sv][ev]==1)
			return true;
		visited[sv]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[sv][i]==1 && !visited[i])
			{ 
				visited[i]=true;
				if(hashPathHelper(edges, i, ev, visited))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static void getPath(int edges[][],int sv,int ev)
	{
		int n=edges.length;
		boolean visited[]=new boolean[n];
		getPathHelper(edges, sv, ev, visited,""+sv);
	}
	
	public  static void getPathHelper(int edges[][],int sv,int ev,boolean visited[],String str)
	{
		if(edges[sv][ev]==1) 
		{
			str+=ev;
			System.out.println(str);
			return;
		}
		visited[sv]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[sv][i]==1 && !visited[i])
			{ 
				visited[i]=true;
				getPathHelper(edges, i, ev, visited,str+i);
			   return;
				
			}
		}
		
	}
	public static ArrayList<Integer> getPath2(int edges[][],int sv,int ev)
	{
		int n=edges.length;
		boolean visited[]=new boolean[n];
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(sv);
		return getPathHelper2(edges, sv, ev, visited,list);
	}
	
	public  static ArrayList<Integer> getPathHelper2(int edges[][],int sv,int ev,boolean visited[],ArrayList<Integer>list)
	{
		if(edges[sv][ev]==1) 
		{
			list.add(ev);
			return list;
		}
		visited[sv]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[sv][i]==1 && !visited[i])
			{ 
				visited[i]=true;
				if(hashPath(edges, sv, i))
				{
					list.add(i);
				return getPathHelper2(edges, i, ev, visited,list);
				}
			}
		}
		return null;
		
	}
	
	
	public static ArrayList<Integer> getBFSPath(int edges[][],int sv,int ev)
	{
		boolean visited[]=new boolean[edges.length];
		return getBFSPathHelper(edges, sv, ev, visited, new ArrayList<Integer>());
	}
	
	public static ArrayList<Integer> getBFSPathHelper(int edges[][],int sv,int ev,boolean visited[],ArrayList<Integer>list)
	{
		if(edges[sv][ev]==1)
		{
			list.add(sv);
			list.add(ev);
			return list;
		}
		
		Queue<Integer> q=new LinkedList<Integer>();
		HashMap<Integer,Integer> map=new HashMap<>();
		visited[sv]=true;
		q.add(sv);
		while(!q.isEmpty())
		{
			int front=q.poll();
			for(int i=0;i<edges.length;i++)
			{
				if(edges[front][i]==1 && !visited[i])
				{
					map.put(i, front);
					visited[i]=true;
					q.add(i);
				}
			}
			
		}
		
		if(hashPath(edges, sv, ev))
		{
			while(true)
			{
				list.add(ev);
				if(sv==ev)
					break;
				int val=map.get(ev);
				ev=val;
			}
		}
		Collections.reverse(list);
		return list;
	}
	
	public static boolean isConnected(int edges[][])
	{
		boolean visited[]=new boolean[edges.length];
		Queue<Integer> q=new LinkedList<>();
		q.add(0);
		visited[0]=true;
		while(!q.isEmpty())
		{
			int front=q.poll();
			for(int i=0;i<edges.length;i++)
			{
				if(edges[front][i]==1 && !visited[i])
				{
					q.add(i);
					visited[i]=true;
				}
			}
			
		}
		boolean flag=true;
		for(boolean i:visited)
		{
			flag=i;
		}
		
		return flag;
	}
	
	public static ArrayList<ArrayList<Integer>> AllConnectedComponents(int [][]edges)
	{
		boolean visited[]=new boolean[edges.length];
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				list.add(Helper(edges, i, visited));
			}
		}
		return list;
	}
	
	public static ArrayList<Integer> Helper(int edges[][],int sv,boolean visited[])
	{
		Queue<Integer>q=new LinkedList<>();
		q.add(sv);
		visited[sv]=true;
		ArrayList<Integer>list=new ArrayList<Integer>();
		while(!q.isEmpty())
		{
			int front=q.poll();
			list.add(front);
			for(int i=0;i<edges.length;i++)
			{
				if(edges[front][i]==1 && !visited[i])
				{
					q.add(i);
					visited[i]=true;
				}
			}
		}
		
		return list;
		
	}
	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of vertexes ");
		int n=sc.nextInt();
		System.out.println("Entere the no of edges ");
		int e=sc.nextInt();
		int edges[][]=new int[n][n];
		
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter starting vertex and end vertex ");
			int sv=sc.nextInt();
			int ev=sc.nextInt();
			edges[sv][ev]=1;
		}
		
		System.out.println("DFS");
		DFS(edges);
		System.out.println("BFS");
		BFS(edges);
		 
		// 6 5 0 1 1 3 3 4 4 2 2 5  
		// 7 6 1 2 2 3 3 1 4 6 6 5 5 4 
		
		System.out.println("hash path ");
		System.out.println(hashPath(edges, 0, 5));
		System.out.println("DFS path in String");
		getPath(edges,0, 5);
		System.out.println("DFS path in ArrayList");
		System.out.println(getPath2(edges, 0, 5));
		System.out.println("BFS path in ArrayListS");
		System.out.println(getBFSPath(edges, 0, 5));
		System.out.println("is Connected "+ isConnected(edges));
		System.out.println(AllConnectedComponents(edges));
		
	}
}
