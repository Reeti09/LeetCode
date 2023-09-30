class Solution {
    public int[] getConcatenation(int[] nums) {
        int l=nums.length;
        int ar[]=new int[2*l];
        for(int i=0;i<l;i++){
            ar[i]=nums[i];
            ar[i+l]=nums[i];
        }
        return ar;

    }
}