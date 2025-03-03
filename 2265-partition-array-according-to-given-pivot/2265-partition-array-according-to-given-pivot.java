class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;

        // Step 1: Add elements < pivot
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }

        // Step 2: Add elements == pivot
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }

        // Step 3: Add elements > pivot
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }

        return result;
    }
}
