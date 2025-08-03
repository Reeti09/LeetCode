class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i:nums){
            int c=mp.getOrDefault(i,0);
            if(c>0){
                return true;
            }
            mp.put(i, c+1);
        }
        return false;
    }
}