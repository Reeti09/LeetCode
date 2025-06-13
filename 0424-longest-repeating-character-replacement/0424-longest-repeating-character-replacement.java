class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength=0;
        int maxCount=0;
        int left=0;
        Map<Character, Integer> mp=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char current=s.charAt(right);
            mp.put(current, mp.getOrDefault(current, 0)+1);
            maxCount=Math.max(maxCount, mp.get(current));
            int currentWindow=right-left+1;
            if(currentWindow-maxCount>k){
                char charAtLeft = s.charAt(left);
                mp.put(charAtLeft, mp.get(charAtLeft) - 1);
                left++;
            }
            maxLength=Math.max(maxLength, right-left+1);

        }
        return maxLength;
        
    }
}