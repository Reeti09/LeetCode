class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefix = 0;
        long minPrefix = 0;
        long maxPrefix = 0;

        for (int diff : differences) {
            prefix += diff;
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int) Math.max(0, maxStart - minStart + 1);
    }
}
