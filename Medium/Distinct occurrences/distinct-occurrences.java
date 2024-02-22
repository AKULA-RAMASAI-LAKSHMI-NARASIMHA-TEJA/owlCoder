//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int seq(String S,String T,int i,int j,int[][] dp){
        if(j==T.length())return 1;
        if(i>=S.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans=0;
        if(S.charAt(i)==T.charAt(j)){
            ans+=seq(S,T,i+1,j+1,dp);
        }
        ans+=seq(S,T,i+1,j,dp);
        ans%=1000000007;
        return dp[i][j]=ans;
    }
    int  subsequenceCount(String s, String t)
    {
	    // Your code here
	    int dp[][]=new int[s.length()][t.length()];
	    for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
	    return seq(s,t,0,0,dp);
    }

}