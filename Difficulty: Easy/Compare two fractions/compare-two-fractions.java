//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
       String parts[] = str.split(", ");
       String val1[] = parts[0].split("/");
       String val2[] = parts[1].split("/");
       int a = Integer.parseInt(val1[0]);
       int b = Integer.parseInt(val1[1]);
       int c = Integer.parseInt(val2[0]);
       int d = Integer.parseInt(val2[1]);
       
       double ab = (double)a/b;
       double cd = (double)c/d;
       
       if(ab == cd){
           return "equal";
       }
       else if(ab > cd){
           return parts[0];
       }
       else{
           return parts[1];
       }
    }
}
