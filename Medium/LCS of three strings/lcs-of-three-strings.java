//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCS(int i, int j, int k, int n1, int n2, int n3, int[][][] dp, char[] a, char[] b, char[] c) {
        if(i>=n1 || j>=n2 || k>=n3) return 0;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        if(a[i]==b[j] && b[j]==c[k]) return dp[i][j][k] = 1+LCS(i+1, j+1, k+1, n1, n2, n3, dp, a, b, c);
        else{
            int t = LCS(i+1, j, k, n1, n2, n3, dp, a, b, c);
            t = Math.max(t, LCS(i, j+1, k, n1, n2, n3, dp, a, b, c));
            t = Math.max(t, LCS(i, j, k+1, n1, n2, n3, dp, a, b, c));
            t = Math.max(t, LCS(i, j+1, k+1, n1, n2, n3, dp, a, b, c));
            t = Math.max(t, LCS(i+1, j, k+1, n1, n2, n3, dp, a, b, c));
            t = Math.max(t, LCS(i+1, j+1, k, n1, n2, n3, dp, a, b, c));
            t = Math.max(t, LCS(i+1, j+1, k+1, n1, n2, n3, dp, a, b, c));
            return dp[i][j][k] = t;
        }
    }
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int dp[][][] = new int[n1][n2][n3];
        for(int i=0; i<n1; i++) {
            for(int j=0; j<n2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return LCS(0, 0, 0, n1, n2, n3, dp, A.toCharArray(), B.toCharArray(), C.toCharArray());
        
    }
}