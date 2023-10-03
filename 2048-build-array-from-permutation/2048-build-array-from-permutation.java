class Solution {
    public int[] buildArray(int[] nums) {
        int l=nums.length;
        int ar[]=new int[l];
        for(int i=0;i<l;i++){
            ar[i]=nums[nums[i]];
        }
        return ar;

    
    }
}