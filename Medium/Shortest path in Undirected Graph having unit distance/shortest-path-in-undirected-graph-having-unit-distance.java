//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge:edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        boolean vis[] = new boolean[n];
        vis[src] = true;
        Arrays.fill(ans, -1);
        ans[src] = 0;
        int dist = 1;
        while(!q.isEmpty()) {
            int s = q.size();
            for(int i = 0; i < s; i++) {
                src = q.poll();
                for(int node:adj.get(src)) {
                    if(!vis[node]) {
                        vis[node] = true;
                        ans[node] = dist;
                        q.offer(node);
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}