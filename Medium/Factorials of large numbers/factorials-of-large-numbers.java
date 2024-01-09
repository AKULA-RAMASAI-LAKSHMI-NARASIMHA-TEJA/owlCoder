//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        int c=0;
        for(int n=2; n<=N; n++) {
            for(int j=0; j<ans.size(); j++) {
                int d=ans.get(j)*(n)+c;
                ans.set(j, d%10);
                c=d/10;
            }
            while(c!=0) {
                ans.add(c%10);
                c/=10;
            }
            c=0;
        }
        Collections.reverse(ans);
        return ans;
    }
}