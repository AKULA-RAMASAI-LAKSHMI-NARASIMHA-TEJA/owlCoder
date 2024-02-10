//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long dp[][][];
    public long solve(int n, int k, int arr[][], int i, int j) {
        if(i == n-1 && j == n-1 && k == arr[i][j]) return 1;
        if(i >= n || j >= n || k < 0) return 0;
        if(k >= arr[i][j]) return solve(n, k-arr[i][j], arr, i+1, j) + solve(n, k-arr[i][j], arr, i, j+1);
        return 0;
    }
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        return solve(n, k, arr, 0, 0);
    }
}