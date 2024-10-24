//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] == 0) {
                continue;
            } else if(arr[i] == arr[i-1]) {
                arr[i-1] *= 2;
                arr[i] = 0;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i:arr) {
            if(i != 0) ans.add(i);
        }
        for(int i = ans.size(); i < arr.length; i++) ans.add(0);
        return ans;
    }
}
