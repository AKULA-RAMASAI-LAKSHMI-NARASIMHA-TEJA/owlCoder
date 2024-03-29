//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Node{
    int val,parent;
    Node(int val, int parent) {
        this.val = val;
        this.parent = parent;
    }
}
class Solution {
    public boolean findCycle(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src) {
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(src, -1));
        vis[src]=true;
        while(!q.isEmpty()) {
            Node n=q.poll();
            for(int adjNode : adj.get(n.val)) {
                if(adjNode == n.parent) continue;
                if(vis[adjNode]) return true;
                else {
                    vis[adjNode]=true;
                    q.offer(new Node(adjNode, n.val));
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
               if(findCycle(V, adj, vis, i)==true) return true;
            }
        }
        return false;
    }
}