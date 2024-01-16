//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int ans;
    static void findSeq(int m, int n, int curr, int cnt) {
        //System.out.println(curr+" "+nxt+" "+cnt);
        // System.out.println(ans);
        if(curr > m || cnt>n){  return; }
        if(cnt == n){ ans++; return;  }
        for(int i=2*curr; i<=m; i++) {
            if(cnt<n) findSeq(m, n, i, cnt+1);
        }
    } 
    static int numberSequence(int m, int n)
    {
        // code here
        ans = 0;
        for(int i=1; i<=m; i++)findSeq(m, n, i, 1);
        return ans;
    }
}