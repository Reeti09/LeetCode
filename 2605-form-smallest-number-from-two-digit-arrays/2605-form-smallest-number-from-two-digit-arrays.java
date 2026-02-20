class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int minEl=Integer.MAX_VALUE;
        for(int i: nums1){
            for(int j: nums2){
                if(i==j){
                    minEl=Math.min(minEl,i);
                }
            }
        }
        if(minEl!=Integer.MAX_VALUE){
            return minEl;
        }
        Arrays.sort(nums1);

        Arrays.sort(nums2);
        int a=nums1[0];
        int b=nums2[0];
        if(a<b){
            return a*10+b;
        }
        else{
            return b*10+a;
        }

        
    }
}