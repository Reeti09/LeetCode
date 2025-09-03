class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> unique=new HashSet<>();
        for(int num: nums){
            if(num>0){
                unique.add(num);
            }
        }
        return unique.size();
    }
}