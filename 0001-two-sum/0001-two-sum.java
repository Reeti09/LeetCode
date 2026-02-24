class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int res=target-nums[i];
            if(mp.containsKey(res)){
                return new int[] {mp.get(res),i};
            }
            mp.put(nums[i],i);
        }
        return new int[] {};
    }
}