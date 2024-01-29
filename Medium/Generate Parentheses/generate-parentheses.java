//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public void findParenthesis(int n, int open, int close, String curr, List<String> ans) {
        if(open==n && close==n) {
            ans.add(curr);
            return;
        }
        if(open < n) findParenthesis(n, open+1, close, curr+'(', ans);
        if(open > close) findParenthesis(n, open, close+1, curr+')', ans);
        
    }
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ans = new ArrayList<String>();
        findParenthesis(n, 0, 0, "", ans);
        return ans;
    }
}
