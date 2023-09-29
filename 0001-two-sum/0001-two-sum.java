class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ar[]=new int[2];
        int c=nums.length;
        for(int i=0;i<c-1;i++){
            for(int j=i+1;j<c;j++){
                if(nums[i]+nums[j]==target){
                    ar[0]=i;
                    ar[1]=j;
                    return ar;
                }
            }
        }
        return ar;
        
    }
}