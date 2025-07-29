class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int left=0;
        int right=nums.length;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            } 
            left=i+1;
            right=n-1;
             while(left<right){
                int currentSum=nums[i]+nums[left]+nums[right];
                if(currentSum==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                
                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }
                while(left<right && nums[right]==nums[right+1]){
                    right--;
                }
                }
             
             else if(currentSum<0){
                left++;
             }
             else{
                right--;
             }
             
        }
    }
    return result;
}
}