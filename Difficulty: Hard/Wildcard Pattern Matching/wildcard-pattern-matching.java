//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int fun(int i, int j) {
        if(j == mat.length()) {
            for(int k = i; k < pat.length(); k++) if(pat.charAt(k) != '*') return 0;
            return 1;
        }
        if(i == pat.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(pat.charAt(i) == mat.charAt(j) || pat.charAt(i) == '?') return dp[i][j] = fun(i+1, j+1);
        else if(pat.charAt(i) == '*') return dp[i][j] = (fun(i, j+1) | fun(i+1, j));
        else return dp[i][j] = 0;
        
    }
    int dp[][];
    String pat, mat;
    public int wildCard(String pattern, String str) {
        // Your code goes here
        dp = new int[pattern.length()+1][str.length()+1];
        for(int i = 0; i < pattern.length(); i++) Arrays.fill(dp[i], -1);
        this.pat = pattern;
        this.mat = str;
        return fun(0, 0);
    }
}
