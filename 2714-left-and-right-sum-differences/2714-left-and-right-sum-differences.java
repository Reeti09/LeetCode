class Solution {
    public int[] leftRightDifference(int[] nums) {
        int r=0,left=0;
        int l=nums.length;
        int ar[]=new int[l];
        for(int i=0;i<l;i++){
            r+=nums[i];
        }
        for(int i=0;i<l;i++){
            r-=nums[i];
            ar[i]=Math.abs(r-left);
            left+=nums[i];
        }
        return ar;
        
    }
}