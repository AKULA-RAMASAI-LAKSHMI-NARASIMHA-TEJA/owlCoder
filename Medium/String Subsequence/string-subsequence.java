//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static int ans;
    public static int count(String s1, String s2, int i, int j, int dp[][]) {
        if(j == s2.length()) return 1;
        if(i >= s1.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int a=0, b=0;
        if(s1.charAt(i) == s2.charAt(j)) {
            a = count(s1, s2, i+1, j+1, dp);
            a %= (int)1e9 + 7;
        }
        b = count(s1, s2, i+1, j, dp);
        b %= (int)1e9 + 7;
        return dp[i][j] = (a+b)%((int)1e9 + 7);
    }
    public static int countWays(String s1, String s2) {
        // code here
        int dp[][] = new int[s1.length()][s2.length()];
        for(int i=0; i<s1.length(); i++) Arrays.fill(dp[i], -1);
        return count(s1, s2, 0, 0, dp);
    }
}
