class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxWater=0;
        while(left<right){
            int currentWidth=right-left;
            int currentHeight=Math.min(height[left],height[right]);
            maxWater=Math.max(maxWater, currentHeight*currentWidth);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }

        }
        return maxWater;
    }
}