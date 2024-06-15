//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        long ans = 0;
        long dp[] = new long[10];
        Arrays.fill(dp, 1L);
        for(int i = 1; i < n; i++) {
            long arr[] = new long[10];
            arr[0] = dp[0]+dp[8];
            arr[1] = dp[1]+dp[2]+dp[4];
            arr[2] = dp[1]+dp[2]+dp[3]+dp[5];
            arr[3] = dp[2]+dp[3]+dp[6];
            arr[4] = dp[1]+dp[4]+dp[5]+dp[7];
            arr[5] = dp[2]+dp[4]+dp[5]+dp[6]+dp[8];
            arr[6] = dp[3]+dp[5]+dp[6]+dp[9];
            arr[7] = dp[4]+dp[7]+dp[8];
            arr[8] = dp[5]+dp[7]+dp[8]+dp[9]+dp[0];
            arr[9] = dp[6]+dp[8]+dp[9];
            for(int j = 0; j < 10; j++) dp[j] = arr[j];
        }
        for(int i = 0; i < 10; i++) ans += dp[i];
        return ans;
    }
}