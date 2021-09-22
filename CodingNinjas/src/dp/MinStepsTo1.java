package dp;

public class MinStepsTo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(move(10));
	}
	
	public static int move(int n)
	{
		if(n==1)
		 return 0;
		if(n<1)
			return Integer.MIN_VALUE;
		
		int ans1=Integer.MAX_VALUE;
		int ans2=Integer.MAX_VALUE;
		int ans3=Integer.MAX_VALUE;
		
		if(n%3==0)
			ans1=move(n/3);
		 if(n%2==0)
			ans2=move(n/2);
		
			ans3=move(n-1);
		
		
		int myans=Math.min(ans1, Math.min(ans2, ans3))+1;
		return myans;
	}
	
	

}
