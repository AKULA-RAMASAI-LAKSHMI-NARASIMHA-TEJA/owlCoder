//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int compareLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Compare the lists based on their elements
        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            int compareResult = Integer.compare(list1.get(i), list2.get(i));
            if (compareResult != 0) {
                return compareResult;
            }
        }
        return Integer.compare(list1.size(), list2.size());
    }
    static void findPerms(ArrayList<Integer> arr , HashSet<ArrayList<Integer>> set, ArrayList<Integer> curr, boolean[] vis) {
        if(curr.size()==arr.size()) {
            set.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<arr.size(); i++) {
            if(vis[i]) continue;
            curr.add(arr.get(i));
            vis[i]=true;
            findPerms(arr, set, curr, vis);
            vis[i]=false;
            curr.remove(curr.size()-1);
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[n];
        findPerms(arr, set, new ArrayList<>(), vis);
        ans.addAll(set);
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                return compareLists(list1, list2);
            }
        });
        return ans;
    }
};