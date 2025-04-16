import java.util.HashMap;

public class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        long res = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            pairs += count; // contributes 'count' new pairs
            freq.put(val, count + 1);

            while (pairs >= k) {
                res += n - right;
                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                freq.put(leftVal, leftCount - 1);
                pairs -= leftCount - 1; // remove (leftCount - 1) pairs
                left++;
            }
        }

        return res;
    }
}
