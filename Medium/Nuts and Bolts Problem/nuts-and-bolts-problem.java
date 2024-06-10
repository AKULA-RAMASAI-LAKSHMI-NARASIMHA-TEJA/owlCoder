//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    HashMap<Character, Character> map1 = new HashMap<>();
    HashMap<Character, Character> map2 = new HashMap<>();
    void match(int n, char arr[], HashMap<Character, Character> map) {
        for(int i = 0; i < n; i++) arr[i] = map.get(arr[i]);
    }
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        map1.put('0', '!'); map1.put('1', '#'); map1.put('2', '$'); map1.put('3', '%'); map1.put('4', '&');
        map1.put('5', '*'); map1.put('6', '?'); map1.put('7', '@'); map1.put('8', '^');
        map2.put('!', '0'); map2.put('#', '1'); map2.put('$', '2'); map2.put('%', '3'); map2.put('&', '4');
        map2.put('*', '5'); map2.put('?', '6'); map2.put('@', '7'); map2.put('^', '8');
        match(n, nuts, map2);
        match(n, bolts, map2);
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        match(n, nuts, map1);
        match(n, bolts, map1);
    }
}