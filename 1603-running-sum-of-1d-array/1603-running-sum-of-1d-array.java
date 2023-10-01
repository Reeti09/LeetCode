class Solution {
    public int[] runningSum(int[] nums) {
        int l=nums.length;
        int s=0;
        int ar[]=new int[l];
        for(int i=0;i<l;i++){
            s+=nums[i];
            ar[i]=s;
        }
        return ar;
    }
}