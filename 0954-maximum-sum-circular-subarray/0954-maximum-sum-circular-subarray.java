class Solution {
    private int kadane(int[] a){
        int sum=a[0];
        int maxi=a[0];
        for(int i=1;i<a.length;i++){
            sum=Math.max(sum+a[i], a[i]);
            maxi=Math.max(maxi, sum);
        }
        return maxi;
    }
    public int maxSubarraySumCircular(int[] nums) 
    {
        if(nums.length==0) return 0;
        int x=kadane(nums);
        int y=0;
        for(int i=0;i<nums.length;i++){
            y+=nums[i];
            nums[i]*=-1;
        }
        int z=kadane(nums);
        if(y+z==0) return x;
        return Math.max(x, y+z); 
        
    }
}