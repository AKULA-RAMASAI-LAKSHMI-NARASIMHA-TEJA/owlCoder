//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    public boolean isValid(int node, int col, int[] color, boolean graph[][], int n) {
        for(int i = 0; i < n; i++) {
            if(graph[node][i] && color[i] == col) return false;
        }
        return true;
    }
    public boolean dfs(int node, boolean graph[][], int m, int n, int[] color) {
        if(node == n) return true;
        for(int c = 0; c < m; c++) {
            if(isValid(node, c, color, graph, n)) {
                color[node] = c;
                if(dfs(node+1, graph, m, n, color)) return true;
                color[node] = -1;
            }
        }
        return false;
    }
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[] = new int[n];
        Arrays.fill(color, -1);
        return dfs(0, graph, m, n, color);
    }
}