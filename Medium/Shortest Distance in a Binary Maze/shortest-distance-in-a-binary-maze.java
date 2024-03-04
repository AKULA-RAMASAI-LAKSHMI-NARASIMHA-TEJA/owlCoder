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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int dir[][] = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        q.offer(source);
        vis[source[0]][source[1]] = true;
        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                if(Arrays.equals(curr, destination)) return dist;
                for(int d[]:dir) {
                    int ni = curr[0]+d[0];
                    int nj = curr[1]+d[1];
                    if(ni>=0 && nj>=0 && ni<grid.length && nj<grid[0].length && !vis[ni][nj] && grid[ni][nj]==1) {
                        q.offer(new int[] {ni, nj});
                        vis[ni][nj] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
