//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
        int n= str.length();
        int i=0, k=0, j=1, c=0;
        while(i<n && j<n){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j++;
                c++;
            }
            else{
                i=0;
                k++;
                j=k;
                c=0;
            }
        }
        
        return c;
    }
}