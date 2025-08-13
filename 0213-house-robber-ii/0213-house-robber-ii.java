class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int amt1=robLinear(nums, 0, nums.length-2);
        int amt2=robLinear(nums, 1, nums.length-1);
        return Math.max(amt1, amt2);
        
    }
    private int robLinear(int[] nums, int start, int end){
        int robbed1=0, robbed2=0;
        for(int i=start;i<=end;i++){
            int current=Math.max(robbed1, robbed2+nums[i]);
            robbed2=robbed1;
            robbed1=current;
        }
        return robbed1;
    }
}