import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Step 1: Sort the array. This is essential for the two-pointer approach.
        Arrays.sort(nums);

        // Iterate through the array with the first pointer 'i'.
        // We only need to go up to n-2 because we need at least two more elements.
        for (int i = 0; i < n - 2; i++) {
            // Optimization: If the current number is positive, the sum will always be positive.
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate elements for the first pointer 'i'.
            // This prevents us from generating duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 2: Initialize the two-pointers for the rest of the array.
            int left = i + 1;
            int right = n - 1;

            // Step 3: Use the two-pointer technique to find pairs that sum to -nums[i].
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // A valid triplet is found. Add it to the result list.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move pointers to find other potential triplets.
                    left++;
                    right--;

                    // Step 4: Skip duplicate elements for the second and third pointers.
                    // This is crucial for avoiding duplicate triplets.
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // The sum is too small. Move the left pointer to the right.
                    left++;
                } else { // sum > 0
                    // The sum is too large. Move the right pointer to the left.
                    right--;
                }
            }
        }
        return result;
    }
}