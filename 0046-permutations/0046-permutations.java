class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currentPer=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(nums, used, currentPer, result);
        return result;

        
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPer, List<List<Integer>> result){
        if(currentPer.size()==nums.length){
            result.add(new ArrayList<>(currentPer));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                currentPer.add(nums[i]);
                used[i]=true;
                backtrack(nums, used, currentPer, result);
                currentPer.remove(currentPer.size()-1);
                used[i]=false;
            }
        }
    } 
}