class Solution {
    public int removeElement(int[] nums, int val) {
        int l=nums.length;
        int l1=0;
        for(int i=0;i<l;i++){
            if(nums[i]!=val){
                nums[l1]=nums[i];
                l1++;
            }
            
            
        }
        return l1;
    }
}