class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minRecolors = Integer.MAX_VALUE;
        int whiteCount = 0;

        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minRecolors = whiteCount;

        // Slide the window across the string
        for (int i = k; i < blocks.length(); i++) {
            // Remove the leftmost character from the window
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Add the new rightmost character to the window
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            minRecolors = Math.min(minRecolors, whiteCount);
        }

        return minRecolors;
    }
}
