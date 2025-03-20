import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);

            // If character is repeated, update left pointer
            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            // Update character's last seen index
            map.put(current, right);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
