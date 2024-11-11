//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        int max = 0;
        HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        // HashMap<Integer,Integer> m2 = new HashMap<>();
        for(int i = 0; i< arr.length; i++){
            if(m1.containsKey(arr[i])){
                max = Math.max(max,(i-m1.get(arr[i])));
            }else{
                m1.put(arr[i],i);
            }
        }
        return max;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends