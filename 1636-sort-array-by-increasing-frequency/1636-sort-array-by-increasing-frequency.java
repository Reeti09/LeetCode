import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // 1. Count how many times each number appears
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 2. Put all numbers into a List (Easier to sort than an array)
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        // 3. Sort the list with our two simple rules
        Collections.sort(list, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            
            // If frequencies are different, smaller frequency comes first
            if (freqA != freqB) {
                return freqA - freqB;
            }
            // If frequencies are same, larger number comes first
            return b - a;
        });

        // 4. Move the sorted list back into an array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }
}