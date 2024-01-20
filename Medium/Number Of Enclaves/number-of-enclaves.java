//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length, m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        int no_ones=0, vis_ones=0;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    no_ones++;
                    if((i==0 || i==n-1 || j==0 || j==m-1)) {
                        vis[i][j] = true;
                        q.offer(new int[] {i, j});
                        vis_ones++;
                    }
                }
                else vis[i][j] = true;
            }
        }
        while(!q.isEmpty()) {
            int i = q.peek()[0], j=q.peek()[1];
            q.poll();
            for(int[] d:dir) {
                int ni = i+d[0], nj = j+d[1];
                if(ni>=0 && ni<n && nj>=0 && nj<m && !vis[ni][nj]) {
                    vis_ones++;
                    q.offer(new int[] {ni, nj});
                    vis[ni][nj] = true;
                }
            }
        }
        return no_ones-vis_ones;
    }
}