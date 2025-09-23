class Solution {
    public int removeDuplicates(int[] nums) {
        int l=nums.length;
        int c=0;
        if(nums.length==0) return 0;
        for(int i=0;i<l;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                nums[c]=nums[i];
                c++;
            }
        }
        return c;
        
    }
}