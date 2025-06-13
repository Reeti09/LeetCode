class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        int left=0,c=0;
        if(n<3){
            return 0;
        }
        Map<Character, Integer> mp=new HashMap<>();
        for(int right=0;right<n;right++){
            char current=s.charAt(right);
            mp.put(current, mp.getOrDefault(current,0)+1);
            if(right-left+1==3){
                if(mp.size()==3){
                    c++;
                }
                char leave=s.charAt(left);
                mp.put(leave, mp.getOrDefault(leave, 0)-1);
                if(mp.get(leave)==0){
                    mp.remove(leave);
                }
                left++;
            }
        }
        return c;

        
    }
}