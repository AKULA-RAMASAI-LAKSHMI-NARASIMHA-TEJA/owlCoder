//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] mat) {
        // Code here
        for(int k = 0; k < mat.length; k++) {
            int i = 0, j = mat[0].length-1;
            boolean pal = true;
            while(i <= j) {
                if(mat[k][i] != mat[k][j]) {
                    pal = false;
                    break;
                }
                i++;
                j--;
            }
            if(pal) return Integer.toString(k)+" R";
        }
        for(int k = 0; k < mat[0].length; k++) {
            int i = 0, j = mat.length-1;
            boolean pal = true;
            while(i <= j) {
                if(mat[i][k] != mat[j][k]) {
                    pal = false;
                    break;
                }
                i++;
                j--;
            }
            if(pal) return Integer.toString(k)+" C";
        }
        return "-1";
    }
}
