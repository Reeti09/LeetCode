class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int count = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorVal = num ^ k;
            if (xorVal > num) {
                totalSum += xorVal;
                count++;
                minDiff = Math.min(minDiff, xorVal - num);
            } else {
                totalSum += num;
                minDiff = Math.min(minDiff, num - xorVal);
            }
        }

        if (count % 2 != 0) {
            totalSum -= minDiff;
        }

        return totalSum;
    }
}
