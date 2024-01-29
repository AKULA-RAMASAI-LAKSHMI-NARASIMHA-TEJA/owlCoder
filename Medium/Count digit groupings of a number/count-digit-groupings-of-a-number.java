//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int ans;
    public int Count(String str, int idx, int prev, int[][] dp) {
        if(idx >= str.length()) {
            return 1;
        } 
        if(dp[idx][prev] != -1) return dp[idx][prev];
        ans=0;
        int curr=0;
        for(int i=idx; i< str.length(); i++) {
            curr += str.charAt(i)-'0';
            if(prev <= curr) {
                ans += Count(str, i+1, curr, dp);
            }
        }
        return dp[idx][prev] = ans;
    }
    public int TotalCount(String str)
    {
        // Code here
        int dp[][] = new int[str.length()+1][5051];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return Count(str, 0, 0, dp);
    }
}