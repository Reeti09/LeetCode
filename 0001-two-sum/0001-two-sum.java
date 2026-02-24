class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int result=target-nums[i];
            if(mp.containsKey(result)){
                return new int[] {mp.get(result),i};
            }
            mp.put(nums[i],i);
        }
        return new int[] {};
        
    }
}