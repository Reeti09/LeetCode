class Solution {
    public int singleNumber(int[] nums) {
        int c=0;
        for(int i:nums){
            c^=i; 
        }
        return c;
        
    }
}