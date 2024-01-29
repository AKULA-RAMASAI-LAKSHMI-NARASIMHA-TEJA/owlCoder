//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    int dir[][] = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public boolean dfs(String s, int i, int j, char[][] board, int idx, int n, int m) {
        if(idx >= s.length()) {
            return true;
        }
        char curr = board[i][j];
        board[i][j]='*';
        for(int[] d:dir) {
            int ni = i+d[0], nj = j+d[1];
            if(ni>=0 && ni<n && nj>=0 && nj<m && board[ni][nj]==s.charAt(idx)) 
            if(dfs(s, ni, nj, board, idx+1, n, m)) {
                board[i][j] = curr;
                return true;
            }
        }
        board[i][j] = curr;
        return false;
    }
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        Set<String> ans = new LinkedHashSet<>();
        int n=board.length, m=board[0].length;
        for(String s:dictionary) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(board[i][j] == s.charAt(0) && dfs(s, i, j, board, 1, n, m)) ans.add(s);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}