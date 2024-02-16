//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        ArrayList<String> list = new ArrayList<>();
        list.add(startWord);
        Queue<ArrayList<String>> q = new LinkedList<>();
        q.offer(list);
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> used = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String s:wordList) set.add(s);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                list = q.poll();
                String last = list.get(list.size()-1);
                if(last.equals(targetWord)) {
                    if(ans.size()==0) ans.add(new ArrayList<>(list));
                    else if(ans.get(0).size() == list.size()) ans.add(new ArrayList<>(list));
                    continue;
                }
                for(int i=0; i<last.length(); i++) {
                    temp = new ArrayList<>(list);
                    char[] arr = last.toCharArray();
                    for(char ch='a'; ch<='z'; ch++) {
                        arr[i] = ch;
                        String curr = new String(arr);
                        if(set.contains(curr)) {
                            temp.add(curr);
                            q.offer(new ArrayList<>(temp));
                            temp.remove(temp.size()-1);
                            used.add(curr);
                        }
                    }
                }
            }
            for(String s:used) set.remove(s);
            used.clear();
        }
        return ans;
    }
}