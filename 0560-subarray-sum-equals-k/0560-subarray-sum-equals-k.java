class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp=new HashMap<>();
        int c=0, currentSum=0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if(mp.containsKey(currentSum-k)){
                c+=mp.get(currentSum-k);
            }
            mp.put(currentSum, mp.getOrDefault(currentSum, 0)+1);
        }
        return c;
        
    }
}