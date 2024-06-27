//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            GfG g = new GfG();
            boolean b = g.isToepliz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    /*You are required to complete this method*/
    boolean constant(int mat[][], int i, int j) {
        while(i+1 < mat.length && j+1 < mat[0].length) {
            if(mat[i][j] != mat[i+1][j+1]) return true;
            i++;
            j++;
        }
        return false;
    }
    boolean isToepliz(int mat[][]) {
        // Your code here
        for(int i = 0; i < mat.length; i++) if(constant(mat, i, 0)) return false;
        for(int i = 0; i < mat[0].length; i++) if(constant(mat, 0, i)) return false;
        return true;
    }
}