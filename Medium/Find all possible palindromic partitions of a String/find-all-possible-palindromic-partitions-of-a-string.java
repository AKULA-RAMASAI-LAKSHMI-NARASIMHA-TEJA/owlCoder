//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean pal(String str) {
        int i=0, j=str.length()-1;
        while(i<=j) {
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static void findPartitions(String s, ArrayList<ArrayList<String>> ans, int idx, ArrayList<String> temp) {
        if(idx >= s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx+1; i<=s.length(); i++) {
            String str = s.substring(idx, i);
            if(pal(str)) {
                temp.add(str);
                findPartitions(s, ans, i, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        findPartitions(S, ans, 0, new ArrayList<>());
        return ans;
    }
};