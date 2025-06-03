import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length; // Total number of boxes (0 to n-1)

        // State trackers for each box
        boolean[] boxFound = new boolean[n];   // True if we have discovered this box
        boolean[] keyFound = new boolean[n];   // True if we have the key for this box
        boolean[] boxOpened = new boolean[n];  // True if this box has been fully processed

        long totalCandies = 0; // Use long to prevent potential overflow for total candies

        // Queue for boxes that are currently openable and waiting to be processed
        Queue<Integer> q = new LinkedList<>();

        // Set to store boxes that we have found, but cannot open yet
        // (because they are closed AND we don't have their key yet).
        // These boxes are 'pending' their key.
        Set<Integer> unopenedButFoundBoxes = new HashSet<>();

        // 1. Initialize the state based on initialBoxes
        for (int boxId : initialBoxes) {
            boxFound[boxId] = true; // Mark the box as found
            if (status[boxId] == 1) { // If the box is initially open
                q.offer(boxId); // Add it to the queue, it's ready to be opened
            } else { // If the box is initially closed
                unopenedButFoundBoxes.add(boxId); // Add it to the set of pending boxes
            }
        }

        // 2. Perform BFS traversal
        while (!q.isEmpty()) {
            int currentBox = q.poll(); // Get an openable box from the queue

            // If this box has already been opened and processed, skip it
            // This prevents double-counting candies and re-processing contents.
            if (boxOpened[currentBox]) {
                continue;
            }

            // Mark the box as opened and collect its candies
            boxOpened[currentBox] = true;
            totalCandies += candies[currentBox];

            // Process keys found inside the current box
            for (int keyId : keys[currentBox]) {
                // If we haven't found this key before
                if (!keyFound[keyId]) {
                    keyFound[keyId] = true; // Mark the key as found
                    // Check if this newly found key unlocks a box we already possess
                    // but were unable to open (it was in unopenedButFoundBoxes).
                    if (unopenedButFoundBoxes.contains(keyId)) {
                        q.offer(keyId); // This box is now openable, add it to the queue
                        unopenedButFoundBoxes.remove(keyId); // Remove from pending set
                    }
                }
            }

            // Process boxes found inside the current box
            for (int containedBoxId : containedBoxes[currentBox]) {
                // If this is a newly discovered box
                if (!boxFound[containedBoxId]) {
                    boxFound[containedBoxId] = true; // Mark the new box as found
                    // Check if the newly found box is immediately openable
                    // (either it's initially open OR we already have its key).
                    if (status[containedBoxId] == 1 || keyFound[containedBoxId]) {
                        q.offer(containedBoxId); // Add it to the queue
                    } else { // It's found, but closed and we don't have its key yet
                        unopenedButFoundBoxes.add(containedBoxId); // Add to pending set
                    }
                }
                // If the box was already found (boxFound[containedBoxId] was true),
                // its state would have been handled previously. We don't need to re-add.
            }
        }

        return (int) totalCandies; // Cast total candies back to int for return
    }
}