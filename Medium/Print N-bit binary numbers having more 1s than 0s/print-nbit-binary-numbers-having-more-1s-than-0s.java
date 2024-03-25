//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> ans;
    void fun(int n, String s, int len, int z, int o) {
        if(len == n) {
            ans.add(s);
            return;
        }
        fun(n, s+"1", len+1, z, o+1);
        if(z < o) fun(n, s+"0", len+1, z+1, o);
    }
    ArrayList<String> NBitBinary(int N) {
        // code here
        ans = new ArrayList<>();
        fun(N, "1", 1, 0, 1);
        return ans;
    }
}