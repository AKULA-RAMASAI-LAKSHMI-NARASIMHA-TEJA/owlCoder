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
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(char ch:map.keySet()) {
            pq.offer(map.get(ch)*map.get(ch));
        }
        while(k > 0) {
            int square = pq.poll();
            int root = (int)Math.sqrt(square) - 1;
            pq.offer(root*root);
            k--;
        }
        int ans = 0;
        while(!pq.isEmpty()) ans += (int)pq.poll();
        return ans;
    }
}