//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod = (int)1e9 + 7;
    int dp[][];
    public int solve(int arr[],int n, int sum, int idx) {
        if(idx >= n) 
        {
            if(sum == 0) return 1;
            return 0;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int ans = 0;
        if(sum-arr[idx] >= 0) ans = (ans%mod + solve(arr, n, sum-arr[idx], idx+1)%mod)%mod;
        ans = (ans%mod + solve(arr, n, sum, idx+1)%mod)%mod;
        return dp[idx][sum] = ans;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new int[n+1][sum+1];
	    for(int i=0; i<n+1; i++) Arrays.fill(dp[i], -1);
	    return solve(arr, n, sum, 0);
	} 
}