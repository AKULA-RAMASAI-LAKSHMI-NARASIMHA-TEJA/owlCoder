//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution {
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[node] = true;
        for(int i:adj.get(node)) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, node)) return true;
            }
            else if(i != parent) return true;
        }
        return false;
    }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge:edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        if(dfs(0, adj, vis, -1)) return false;
        for(boolean v:vis) if(!v) return false;
        return true;
    }
}

