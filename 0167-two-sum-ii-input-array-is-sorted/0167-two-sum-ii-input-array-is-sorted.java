class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        while(left<right){
            int currentSum=numbers[left]+numbers[right];
            if(currentSum==target){
                return new int[]{left+1, right+1};
            }
            else if(currentSum<target){
                left++;
            }
            else if(currentSum>target){
                right--;
            }
        }
        return new int[]{-1, -1};
        
    }
}