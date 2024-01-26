//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) adj.add(new ArrayList<>());
        int[] deg = new int[N];
        for(int[] p:prerequisites) {
            adj.get(p[1]).add(p[0]);
            deg[p[0]]++;
        }
        boolean[] vis = new boolean[N];
         Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++) if(deg[i] == 0) {q.offer(i); vis[i] = true;}
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i:adj.get(node)) {
                if(!vis[i]) {deg[i]--;
                if(deg[i]==0) {
                    vis[i] = true;
                    q.offer(i);
                }}
            }
        }
        for(boolean v:vis) if(!v) return false;
        return true;
    }
    
}