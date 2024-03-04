//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Pair {
    int row, col, effort;
    Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

class Solution {
    
    int MinimumEffort(int heights[][]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int dir[][] = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int dis[][] = new int[heights.length][heights[0].length];
        for(int i=0; i<dis.length; i++) Arrays.fill(dis[i], (int)1e6);
        dis[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(p.row == heights.length-1 && p.col == heights[0].length-1) {
                return p.effort;
            }
            for(int d[]:dir) {
                int ni = p.row+d[0];
                int nj = p.col+d[1];
                if(ni>=0 && nj>=0 && ni<heights.length && nj<heights[0].length && 
                Math.abs(heights[ni][nj]-heights[p.row][p.col]) < dis[ni][nj]) {
                    dis[ni][nj] = Math.abs(heights[ni][nj]-heights[p.row][p.col]);
                    pq.offer(new Pair(ni, nj, Math.max(p.effort, Math.abs(heights[p.row][p.col]-heights[ni][nj]))));
                }
            }
        }
        return 0;
    }
}