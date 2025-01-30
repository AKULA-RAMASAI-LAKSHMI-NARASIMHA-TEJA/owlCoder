//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public boolean isSafe(int i, int j, int m[][], int n) {
        for(int x = i; x >= 0; x--) {
            if(m[x][j] == 1) return false;
        }
        for(int x = i, y = j; x >= 0 && y >= 0; x--, y--) {
            if(m[x][y] == 1) return false;
        }
        for(int x = i, y = j; x >= 0 && y < n; x--, y++) {
            if(m[x][y] == 1) return false;
        }
        return true;
    }
    public void placeQueens(int i, int[][] m, int n, ArrayList<ArrayList<Integer>> ans) {
        if(i == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    if(m[x][y] == 1) {
                        temp.add(y+1);
                    }
                }
            }
            ans.add(temp);
            return;
        }
        for(int j = 0; j < n; j++) {
            if(isSafe(i, j, m, n)) {
                m[i][j] = 1;
                placeQueens(i+1, m, n, ans);
                m[i][j] = 0;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int m[][] = new int[n][n];
        placeQueens(0, m, n, ans);
        return ans;
    }
}
