import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);  // prefix count = 0 occurs once

        long result = 0;
        int prefix = 0;

        for (int num : nums) {
            if (num % mod == k) {
                prefix++;
            }

            int currMod = prefix % mod;
            int target = (currMod - k + mod) % mod;

            result += map.getOrDefault(target, 0L);
            map.put(currMod, map.getOrDefault(currMod, 0L) + 1);
        }

        return result;
    }
}
