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
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        stk.add(-1);
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') stk.add(i);
            else {
                stk.pop();
                if(stk.isEmpty()) stk.add(i);
                ans = Math.max(ans, i-stk.peek());
            }
        }
        return ans;
    }
}