class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result){
        result.add(new ArrayList<>(currentSubset));
        for(int i=start;i<nums.length;i++){
            currentSubset.add(nums[i]);
            backtrack(nums, i+1, currentSubset, result);
            currentSubset.remove(currentSubset.size()-1);
        }
    }
}