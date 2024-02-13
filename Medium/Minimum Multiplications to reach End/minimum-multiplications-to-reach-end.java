//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int val;
    int steps;
    Pair(int v, int s) {
        this.val = v;
        this.steps = s;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair> q = new LinkedList<>();
        boolean vis[] = new boolean[100001];
        q.offer(new Pair(start, 0));
        vis[start] = true;
        int mod = 100000;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int v = p.val;
            int s = p.steps;
            if(v == end) return s;
            for(int i:arr) {
                int t = (i%mod * v%mod)%mod;
                if(!vis[t]){
                    q.offer(new Pair(t, s+1));
                    vis[t] = true;
                }
            }
        }
        return -1;
    }
}
