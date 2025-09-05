import java.util.Deque;
import java.util.LinkedList;

class Solution {
    /**
     * Finds the maximum number of consecutive robots that can be run within the given budget.
     * This method uses a sliding window approach with a monotonic deque to efficiently
     * find the maximum charge time within the current window.
     *
     * @param chargeTimes The array of charge times for each robot.
     * @param runningCosts The array of running costs for each robot.
     * @param budget The total budget for running the robots.
     * @return The maximum number of consecutive robots.
     */
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        long currentRunningCostSum = 0;
        int maxRobots = 0;
        
        // Deque to store indices of chargeTimes in decreasing order,
        // used to find the maximum chargeTime in the current window.
        Deque<Integer> dq = new LinkedList<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            // Add the current robot's running cost to the sum.
            currentRunningCostSum += runningCosts[right];

            // Maintain the monotonic decreasing deque for chargeTimes.
            // Remove elements from the back that are smaller than the current element.
            while (!dq.isEmpty() && chargeTimes[dq.peekLast()] <= chargeTimes[right]) {
                dq.pollLast();
            }
            dq.offerLast(right);

            // Calculate the current window size and the max charge time.
            int currentWindowSize = right - left + 1;
            long maxChargeTime = chargeTimes[dq.peekFirst()];
            
            // Check if the current window's total cost exceeds the budget.
            // If it does, shrink the window from the left.
            while (maxChargeTime + (long)currentWindowSize * currentRunningCostSum > budget) {
                // Remove the robot at the left of the window from the sum.
                currentRunningCostSum -= runningCosts[left];
                
                // If the maximum charge time was at the left of the window, remove it from the deque.
                if (dq.peekFirst() == left) {
                    dq.pollFirst();
                }

                // Shrink the window by moving the left pointer.
                left++;
                
                // Re-calculate maxChargeTime and window size for the new window.
                // This check is important inside the loop as values change.
                if (left <= right) {
                    currentWindowSize = right - left + 1;
                    if (!dq.isEmpty()) {
                        maxChargeTime = chargeTimes[dq.peekFirst()];
                    }
                } else {
                    // Window is empty, break the inner loop.
                    break;
                }
            }
            
            // Update the maximum number of robots found so far.
            maxRobots = Math.max(maxRobots, right - left + 1);
        }
        
        return maxRobots;
    }
}