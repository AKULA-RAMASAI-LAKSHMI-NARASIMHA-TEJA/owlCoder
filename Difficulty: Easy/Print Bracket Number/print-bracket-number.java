//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(char c:str.toCharArray()) {
            if(c == '(') {
                stack.add(num);
                ans.add(num);
                num++;
            } else if (c == ')') {
                ans.add(stack.pop());
            }
        }
        return ans;
    }
};