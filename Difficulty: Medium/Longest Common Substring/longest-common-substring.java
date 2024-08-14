//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int[][] dp=new int[str1.length()][str2.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return solve(str1,str2,0,0,dp);
    }
    int solve(String str1, String str2,int i,int j,int[][] dp){
        if(i==str1.length() || j==str2.length())
            return 0;
            
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int opt1=solve(str1,str2,i+1,j,dp);
        int opt2=solve(str1,str2,i,j+1,dp);
        int cur=0,x=i,y=j;
        while(x<str1.length() && y<str2.length() &&
            str1.charAt(x++)==str2.charAt(y++))
            cur++;
        return dp[i][j]=Math.max(cur,Math.max(opt1,opt2));
    }
}