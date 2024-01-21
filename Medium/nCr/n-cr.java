//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static long fact[] = new long[1001];
    static long invfact[] = new long[1001];
    static long mod = (long)1e9 + 7L;
    static long pow(long a, long b) {
        long ans = 1L;
        while(b>0) {
            if((b&1)==1) { 
                ans *= a;
                ans %= mod;
            }
            a *= a;
            a %= mod;
            b >>= 1L;
        }
        return ans;
    }
    static void preFact() {
        fact[0] = 1L;
        invfact[0] = 1L;
        for(int i=1; i<=1000; i++) {
            fact[i] = (fact[i-1]*i*1L)%mod;
            invfact[i] = pow(fact[i], mod-2L)%mod;
        }
    }
    static int nCr(int n, int r)
    {
        // code here
        preFact();
        if(r>n) return 0;
        return (int)((fact[n]%mod * invfact[r]%mod * invfact[n-r]%mod)%mod);
    }
}