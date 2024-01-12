//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Node {
    int row, col;
    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution
{
    int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<Node> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1){
                    q.offer(new Node(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int res[][] = new int[grid.length][grid[0].length];
        int c = 1;
        while(!q.isEmpty()) {
            int s=q.size();
            for(int i=0; i<s; i++) {
                Node n=q.poll();
                for(int[] d:dir) {
                    int ni = n.row+d[0], nj = n.col+d[1];
                    if(ni >= 0 && nj >= 0 && ni <grid.length && nj < grid[0].length && !vis[ni][nj]) {
                        res[ni][nj] = c;
                        vis[ni][nj] = true;
                        q.offer(new Node(ni, nj));
                    }
                }
            }
            c++;
        }
        return res;
    }
}