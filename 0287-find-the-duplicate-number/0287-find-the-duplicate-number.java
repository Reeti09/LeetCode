class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the two pointers (slow and fast)
        // We're treating the array indices as nodes and nums[index] as the next pointer.
        // E.g., index 0 points to nums[0], nums[0] points to nums[nums[0]], and so on.
        // A duplicate number in the range [1, n] guarantees a cycle in this sequence.

        int slow = 0; // Conceptual start of our linked list (index 0)
        int fast = 0; // Also conceptual start (index 0)

        // Make the first moves outside the loop to ensure slow != fast initially.
        // This setup allows us to use a standard 'while' loop instead of a 'do-while'.
        slow = nums[slow];        // slow moves one step
        fast = nums[nums[fast]];  // fast moves two steps

        // Now, loop until slow and fast pointers meet
        while (slow != fast) {
            slow = nums[slow];        // slow continues one step
            fast = nums[nums[fast]];  // fast continues two steps
        }

        // Phase 2: Find the entry point of the cycle (which is the duplicate number)
        // Reset one pointer (slow) to the very beginning (index 0).
        // The other pointer (fast) remains at the meeting point found in Phase 1.
        slow = 0; 
        
        // Move both pointers one step at a time until they meet again.
        // This second meeting point is the start of the cycle, which is our duplicate.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Both pointers now point to the duplicate number
        return slow; // Or return fast; both are the same
    }
}