//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void sieve(boolean[] prime, int n) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i=2; i*i <= n; i++) {
            if(prime[i]) {
                for(int j=i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    void getPrimes(ArrayList<Integer> primes, boolean[] prime, int n) {
        for(int i=2; i*i<=n; i++) {
            if(prime[i]) primes.add(i);
        }
    }
    void setSegment(ArrayList<Integer> primes, boolean[] segment, int size, int l, int r) {
        Arrays.fill(segment, true);
        for(int p:primes) {
            /*
            int s;
            if(l/p <= 1) s=p+p;
            else if(l%p == 0) s=l;
            else s = p*l/p + p;
            // System.out.println(s);
            for(int i=s; i<=r; i+=p) segment[i-l] = false;
            */
            int low = l/p;
            if(low <= 1) low = p+p;
            else if(l%p != 0) low = low*p + p;
            else low*=p;
            for(int i=low; i <=r; i+=p) segment[i-l] = false;
        }
    }
    ArrayList<Integer> primeRange(int M, int N) {
        // code here
        boolean[] prime = new boolean[N+1];
        sieve(prime, N);
        // System.out.println(Arrays.toString(prime));
        ArrayList<Integer> primes = new ArrayList<>();
        getPrimes(primes, prime, N);
        // System.out.println(primes);
        boolean segment[] = new boolean[N-M+1];
        setSegment(primes, segment, N-M+1, M, N);
        // System.out.println(Arrays.toString(segment));
        ArrayList<Integer> ans = new ArrayList<>();
        if(M==1) segment[0] = false;
        for(int i=0; i<N-M+1; i++) if(segment[i]) ans.add(M+i);
        return ans;
    }
}