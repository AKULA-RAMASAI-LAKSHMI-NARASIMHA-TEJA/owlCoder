//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static int dir[][] = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static char c[] = new char[] {'U', 'L', 'D', 'R'};
    public static void countPaths(int[][] m, int n, ArrayList<String> ans, int i, int j, String curr, boolean[][] vis) {
        if(i<0 || j<0 || i>=n || j>=n || vis[i][j] || m[i][j]==0) return; 
        if(i==n-1 && j==n-1) {
            ans.add(curr);
            return;
        }
        vis[i][j] = true;
        for(int idx=0; idx<4; idx++) {
            int ni = i+dir[idx][0], nj = j+dir[idx][1];
            countPaths(m, n, ans, ni, nj, curr+c[idx], vis);
        }
        vis[i][j] = false;
    } 
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean vis[][] = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0]==0 || m[n-1][n-1]==0) return ans;
        countPaths(m, n, ans, 0, 0, "", vis);
        return ans;
    }
}