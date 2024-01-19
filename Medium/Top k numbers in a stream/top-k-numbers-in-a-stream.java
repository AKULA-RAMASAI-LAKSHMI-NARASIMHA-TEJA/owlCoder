//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends

class Pair{
    int value, freq;
    Pair(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }
}
class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> temp = new PriorityQueue<>();
        for(int i=0; i<N; i++) ans.add(new ArrayList<>());
        for(int i=0; i<N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            PriorityQueue<Map.Entry<Integer, Integer>> q=new PriorityQueue<>((a,b)->{
                if(a.getValue()==b.getValue()) return a.getKey()-b.getKey();
                else return b.getValue()-a.getValue();
            });//a.getValue==b.getValue?a.getKey-b.getKey:a.getValue-b.getValue);
            q.addAll(map.entrySet());
            int t=K;
            while(!q.isEmpty() && t>0) {
                int val = q.poll().getKey();
                ans.get(i).add(val);
                t--;
            }
            q.clear();
        }
        return ans;
        
    }
}