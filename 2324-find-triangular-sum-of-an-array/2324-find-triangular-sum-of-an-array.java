import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Calculates the triangular sum of an array by repeatedly summing adjacent elements.
     * @param nums The input array of digits.
     * @return The triangular sum.
     */
    public int triangularSum(int[] nums) {
        // Convert the input array to a list for easier manipulation.
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        while (list.size() > 1) {
            List<Integer> newNums = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = (list.get(i) + list.get(i + 1)) % 10;
                newNums.add(sum);
            }
            list = newNums;
        }

        return list.get(0);
    }
}