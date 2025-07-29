class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        int prefixSum[] = new int[s.length()];
        int firstOccurence[] = new int[26];
        int lastOccurence[] = new int[26];
        Arrays.fill(firstOccurence, -1);
        Arrays.fill(lastOccurence, -1);
        
        for(int i = 0; i < s.length(); i++) {
            prefixSum[i] = i == 0 ? (int)s.charAt(i) : prefixSum[i-1] + (int)s.charAt(i);
            if(firstOccurence[s.charAt(i)-'a'] == -1) {
                firstOccurence[s.charAt(i)-'a'] = i;
            }
            lastOccurence[s.charAt(i)-'a'] = i;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            if(firstOccurence[i] != lastOccurence[i] && firstOccurence[i]+1 != lastOccurence[i]) {
                // System.out.println(i);
                ans.add(prefixSum[lastOccurence[i]-1] - prefixSum[firstOccurence[i]]);
            }
        }
        return ans;
    }
}