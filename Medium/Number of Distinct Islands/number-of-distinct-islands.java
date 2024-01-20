//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    void dfs(int i, int j, int[][] grid, boolean[][] vis, ArrayList<String> island, int p_i, int p_j, int n, int m) {
        vis[i][j] = true;
        island.add(Integer.toString(p_i - i)+" "+Integer.toString(p_j - j));
        for(int d[]:dir) {
            int ni = i+d[0], nj = j+d[1];
            if(ni >=0 && ni < n && nj >= 0 && nj < m && !vis[ni][nj] && grid[ni][nj] == 1) {
                dfs(ni, nj, grid, vis, island, p_i, p_j, n, m);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length, m = grid[0].length;
        HashSet<ArrayList<String>> ans = new HashSet<>();
        boolean vis[][] = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && grid[i][j]==1) {
                    ArrayList<String> island = new ArrayList<>();
                    dfs(i, j, grid, vis, island, i, j, n, m);
                    ans.add(island);
                }
            }
        }
        return ans.size();
    }
}
