//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minThrow(int N, int arr[]){
        // code here
        int adj[] = new int[31];
        boolean vis[] = new boolean[31];
        Arrays.fill(adj, -1);
        for(int i=0; i<arr.length; i+=2) adj[arr[i]] = arr[i+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int pos = curr[0];
            int steps = curr[1];
            if(pos == 30) return steps;
            for(int i=pos+1; i<=pos+6 && i<31; i++) {
                if(adj[i] != -1 && !vis[adj[i]]) {
                    q.offer(new int[]{adj[i], steps+1});
                    vis[adj[i]] = true;
                } else {
                    q.offer(new int[]{i, steps+1});
                    vis[i] = true;
                }
            }
        }
        return -1;
    }
}