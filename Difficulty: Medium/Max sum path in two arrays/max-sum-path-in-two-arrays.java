//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int n = arr1.size(), m = arr2.size();
        int s1 = 0, s2 = 0;
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(arr1.get(i) < arr2.get(j)) {
                s1 += arr1.get(i);
                i++;
            } else if (arr1.get(i) > arr2.get(j)) {
                s2 += arr2.get(j);
                j++;
            } else {
                s1 = Math.max(s1, s2) + arr1.get(i);
                s2 = s1;
                i++;
                j++;
            }
        }
        while(i < n) {
            s1 += arr1.get(i);
            i++;
        }
        while(j < m) {
            s2 += arr2.get(j);
            j++;
        }
        return Math.max(s1, s2);
    }
}