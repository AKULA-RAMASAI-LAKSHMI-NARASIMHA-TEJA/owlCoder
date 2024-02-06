//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    int dp[];
    public int maxProfit(int[] price, int n, int curr) {
        if(curr >= n) return 0;
        if(dp[curr] != -1) return dp[curr];
        int ans = 0;
        for(int i=0; i<n-curr; i++) {
            ans = Math.max(ans, price[i]+maxProfit(price, n, i+curr+1));
        }
        return dp[curr] = ans;
    }
    public int cutRod(int price[], int n) {
        //code here
        dp = new int[n];
        Arrays.fill(dp, -1);
        return maxProfit(price, n, 0);
    }
}