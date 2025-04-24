import java.util.*;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> allElements = new HashSet<>();
        for (int num : nums) {
            allElements.add(num);
        }
        int totalDistinct = allElements.size();

        int left = 0, res = 0;
        Map<Integer, Integer> window = new HashMap<>();

        for (int right = 0; right < n; right++) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            while (window.size() == totalDistinct) {
                res += n - right; // all subarrays starting at left and ending from right to n-1
                window.put(nums[left], window.get(nums[left]) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                left++;
            }
        }

        return res;
    }
}
