class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, maxLen=0;
        int n=s.length();
        Map<Character, Integer> mp=new HashMap<>();
        if(n==0) return 0;
        for(int right=0;right<n;right++){
            char current=s.charAt(right);
            if(mp.containsKey(current)){
                left=Math.max(left, mp.get(current)+1);
            }
            mp.put(current,right);
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;

    }
}