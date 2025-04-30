public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            // Convert number to string to count digits
            int digits = String.valueOf(num).length();
            if (digits % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(sol.findNumbers(nums)); // Output: 2
    }
}
