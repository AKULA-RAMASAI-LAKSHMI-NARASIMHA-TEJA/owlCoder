//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Vertex {
    int node, weight;
    Vertex(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public void topoSort(int src, ArrayList<ArrayList<Vertex>> adj, boolean vis[], Stack<Integer> stack) {
        vis[src] = true;
        for(Vertex v:adj.get(src)) {
            int node = v.node;
            if(!vis[node]) topoSort(node, adj, vis, stack);
        }
        stack.add(src);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Vertex>> adj = new ArrayList<>();
		for(int i=0; i<N; i++) adj.add(new ArrayList<>());
		for(int[] edge:edges) {
		    int u = edge[0];
		    int v = edge[1];
		    int w = edge[2];
		    adj.get(u).add(new Vertex(v, w));
		}
		int ans[] = new int[N];
		int inf = (int)1e5 + 1;
		Arrays.fill(ans, inf);
		boolean vis[] = new boolean[N];
		Stack<Integer> stack = new Stack<>();
		topoSort(0, adj, vis, stack);
		ans[0] = 0;
		while(!stack.isEmpty()) {
		    int n = stack.pop();
		    for(Vertex v:adj.get(n)) {
		        int node = v.node;
		        int weight = v.weight;
		        if(ans[n]+weight < ans[node]) {
		            ans[node] = ans[n]+weight;
		        }
		    }
		}
		for(int i=0; i<N; i++) if(ans[i] == inf) ans[i] = -1;
		return ans;
	}
}