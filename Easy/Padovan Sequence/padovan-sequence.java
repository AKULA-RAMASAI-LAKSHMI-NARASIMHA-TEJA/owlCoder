//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        int a=1, b=1, c=1;
        int i = 2;
        int mod = (int)1e9 + 7;
        while(i<n) {
            int t = (a%mod + b%mod)%mod;
            int t1 = b;
            b = c%mod;
            a = t1%mod;
            c = t%mod;
            i++;
        }
        return c;
    }
    
}
