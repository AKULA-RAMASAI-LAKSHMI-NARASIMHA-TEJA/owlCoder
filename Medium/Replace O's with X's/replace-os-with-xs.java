//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static void dfs(int n, int m, int i, int j, char a[][], char res[][], boolean vis[][]) {
        res[i][j] = 'O';
        vis[i][j] = true;
        for(int[] d:dir) {
            int ni=i+d[0], nj=j+d[1];
            if(ni>=0 && nj>=0 && ni<n && nj<m && !vis[ni][nj]) {
                if(a[ni][nj]=='O') dfs(n, m, ni, nj, a, res, vis);
                else vis[ni][nj] = true;
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean vis[][] = new boolean[n][m];
        char res[][] = new char[n][m];
        for(int i=0; i<n; i++) Arrays.fill(res[i],'X');
        for(int i=0; i<m; i++) if(!vis[0][i] && a[0][i]=='O') dfs(n, m, 0, i, a, res, vis);
        for(int i=0; i<m; i++) if(!vis[n-1][i] && a[n-1][i]=='O') dfs(n, m, n-1, i, a, res, vis);
        for(int i=0; i<n; i++) if(!vis[i][0] && a[i][0]=='O') dfs(n, m, i, 0, a, res, vis);
        for(int i=0; i<n; i++) if(!vis[i][m-1] && a[i][m-1]=='O') dfs(n, m, i, m-1, a, res, vis);
        return res;
    }
}
