//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair {
    String s;
    int steps;
    Pair(String s, int i) {
        this.s = s;
        this.steps = i;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set = new HashSet<>();
        for(String s:wordList) set.add(s);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startWord, 1));
        while(!q.isEmpty()) {
            String curr = q.peek().s;
            int step = q.peek().steps;
            q.poll();
            if(curr.compareTo(targetWord)==0) return step;
            for(int j=0; j<curr.length(); j++) {
                for(int k=0; k<26; k++) {
                    String temp = curr.substring(0, j)+(char)('a'+k)+curr.substring(j+1);
                    if(set.contains(temp)) {
                        q.offer(new Pair(temp, step+1));
                        set.remove(temp);
                    }
                }
            }
         
        }
        return 0;
    }
}