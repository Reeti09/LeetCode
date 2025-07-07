import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: Sort events by their start day.
        // If start days are the same, sorting by end day can sometimes be slightly
        // more efficient, but not strictly necessary for correctness of this greedy approach.
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int attendedCount = 0;
        int eventIdx = 0; // Pointer to the next event to consider from the sorted array
        // Find the maximum possible day an event can end, to determine the loop limit.
        // Or, more efficiently, iterate through days until no more events can be attended.
        // The maximum end day can be up to 10^5, so iterating day by day is feasible.
        
        // A min-priority queue to store the end days of available events.
        // We want to process events that end earliest first.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // currentDay will iterate from the earliest possible event start day
        // until all events are processed or no more events can be attended.
        int currentDay = 1; // Days typically start from 1 based on constraints

        // The loop continues as long as there are events left to be considered
        // (eventIdx < events.length) OR there are events currently available in the minHeap.
        while (eventIdx < events.length || !minHeap.isEmpty()) {

            // If the minHeap is empty, it means there are no events currently available
            // to attend. We can skip days until the start day of the next available event.
            if (minHeap.isEmpty() && eventIdx < events.length) {
                currentDay = Math.max(currentDay, events[eventIdx][0]);
            }
            
            // Add all events that start on or before currentDay to the minHeap.
            // We specifically add events that start on `currentDay` as we process day by day.
            while (eventIdx < events.length && events[eventIdx][0] <= currentDay) {
                minHeap.offer(events[eventIdx][1]); // Add endDay to the minHeap
                eventIdx++;
            }

            // Remove events from the minHeap that have already ended before currentDay.
            while (!minHeap.isEmpty() && minHeap.peek() < currentDay) {
                minHeap.poll();
            }

            // If there are any events available for currentDay (i.e., minHeap is not empty),
            // attend the one that ends earliest.
            if (!minHeap.isEmpty()) {
                minHeap.poll(); // Remove the event with the smallest endDay (greedy choice)
                attendedCount++;
            }

            // Move to the next day.
            currentDay++;
        }

        return attendedCount;
    }
}