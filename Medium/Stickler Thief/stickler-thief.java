//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int sum(int arr[],int n,int[] dp,int i){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i]=Math.max(arr[i]+sum(arr,n,dp,i+2),sum(arr,n,dp,i+1));
    }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return sum(arr,n,dp,0);
    }
}