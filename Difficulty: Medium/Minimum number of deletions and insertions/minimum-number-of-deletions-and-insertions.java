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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestCommonSubseq(int i, int j, String str1, String str2, int dp[][]) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)) return dp[i][j] = 1 + LongestCommonSubseq(i-1, j-1, str1, str2, dp);
        return dp[i][j] = Math.max(LongestCommonSubseq(i, j-1, str1, str2, dp), LongestCommonSubseq(i-1, j, str1, str2, dp));
    }
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n = str1.length(), m = str2.length();
	    int dp[][] = new int[n][m];
	    for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
	    int lcs = LongestCommonSubseq(n-1, m-1, str1, str2, dp);
	    return n+m-2*lcs;
	} 
}