import java.util.HashSet;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] A) {
        // all_ors will store all unique OR values of all subarrays.
        Set<Integer> all_ors = new HashSet<>();
        
        // prev_ors will store the unique OR values of all subarrays ending at the previous index.
        Set<Integer> prev_ors = new HashSet<>();

        for (int x : A) {
            // current_ors will store the unique OR values of all subarrays ending at the current index.
            Set<Integer> current_ors = new HashSet<>();

            // A new subarray consisting of just x.
            current_ors.add(x);

            // Extend all previous subarrays by ORing with x.
            for (int y : prev_ors) {
                current_ors.add(y | x);
            }
            
            // Add all the new OR values to our global set.
            all_ors.addAll(current_ors);
            
            // Update prev_ors for the next iteration.
            prev_ors = current_ors;
        }
        
        return all_ors.size();
    }
}