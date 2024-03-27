//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findShortestPath(int[][] mat) {
        // code here
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        int dir[][] = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int direc[][] = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                } else mat[i][j] = (int)1e4;
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d[]:dir) {
                int n_i = curr[0]+d[0];
                int n_j = curr[1]+d[1];
                if(n_i>=0 && n_j>=0 && n_i<mat.length && n_j<mat[0].length && !vis[n_i][n_j]) {
                    vis[n_i][n_j] = true;
                    mat[n_i][n_j] = 0;
                }
            }
        }
        int ans = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);
        for(int i = 0; i < mat.length; i++) {
            //System.out.println(Arrays.toString(mat[i]));
            if(mat[i][0] != 0) {
                mat[i][0] = 1;
                pq.offer(new int[]{i, 0, 1});
            }
        }
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            if(curr[1] == mat[0].length-1) return curr[2];
            //System.out.println(curr[0]+" "+curr[1]+" "+curr[2]);
            for(int d[]:direc) {
                int n_i = curr[0]+d[0];
                int n_j = curr[1]+d[1];
                if(n_i>=0 && n_j>=0 && n_i<mat.length && n_j<mat[0].length  && mat[n_i][n_j]!=0) {
                    //System.out.println(mat[n_i][n_j]+" "+mat[curr[0]][curr[1]]);
                    if(mat[n_i][n_j] > mat[curr[0]][curr[1]]+1) {
                        mat[n_i][n_j] = mat[curr[0]][curr[1]]+1;
                        pq.offer(new int[]{n_i, n_j, mat[curr[0]][curr[1]]+1});
                    }
                }
            }
        }
        return -1;
    }
}
