//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public void find(int idx, String s, String curr, HashSet<String> set) {
        //System.out.println(s+" "+s.length());
        if(s.length() == 0) {
            set.add(curr);
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String str = s.substring(0, i)+s.substring(i+1);
            find(idx+1, str, curr+c, set);
        }
    }
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> set = new HashSet<>();
        find(0, s, "", set);
        //System.out.println(set);
        return new ArrayList<>(set);
    }
}