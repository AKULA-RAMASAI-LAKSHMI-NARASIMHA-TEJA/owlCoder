//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ds, boolean vis[]) {
        vis[node] = true;
        for(int i:adj.get(node)) {
            if(!vis[i]) dfs(i, adj, ds, vis);
        }
        ds.add(node);
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<V; i++) revAdj.add(new ArrayList<>());
        for(int i=0; i<adj.size(); i++) {
            for(int v:adj.get(i)) {
                revAdj.get(v).add(i);
            }
        }
        boolean vis[] = new boolean[V];
        ArrayList<Integer> dfs1 = new ArrayList<>();
        ArrayList<Integer> dfs2 = new ArrayList<>();
        for(int i=0; i<V; i++) {
            if(!vis[i]) dfs(i, adj, dfs1, vis);
        }
        Collections.reverse(dfs1);
        Arrays.fill(vis, false);
        int ans = 0;
        for(int i:dfs1) {
            if(!vis[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, revAdj, temp, vis);
                ans++;
            }
        }
        return ans;
    }
}
