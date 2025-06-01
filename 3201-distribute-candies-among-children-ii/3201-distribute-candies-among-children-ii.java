class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0; // Use long for count, as the number of ways can be large
        for (int c1 = 0; c1 <= n; c1++) {
            if (c1 > limit) {
                // If c1 already exceeds the limit, then any larger c1 value will also exceed the limit.
                // So, we can break out of the loop early.
                break;
            }

            // Calculate the remaining candies that need to be distributed between c2 and c3.
            int remainingCandies = n - c1;

            // Now, we need to find the number of ways to distribute 'remainingCandies'
            // between c2 and c3, such that 0 <= c2 <= limit and 0 <= c3 <= limit.

            // Determine the minimum value c2 can take:
            // c2 >= 0
            // c3 = remainingCandies - c2. Since c3 <= limit, we have remainingCandies - c2 <= limit,
            // which implies c2 >= remainingCandies - limit.
            // So, min_c2 is the maximum of these two lower bounds.
            int min_c2 = Math.max(0, remainingCandies - limit);

            // Determine the maximum value c2 can take:
            // c2 <= limit
            // c3 = remainingCandies - c2. Since c3 >= 0, we have remainingCandies - c2 >= 0,
            // which implies c2 <= remainingCandies.
            // So, max_c2 is the minimum of these two upper bounds.
            int max_c2 = Math.min(remainingCandies, limit);

            // If there's a valid range for c2 (i.e., the maximum is not less than the minimum),
            // then the number of ways to choose c2 (and thus implicitly c3) is (max_c2 - min_c2 + 1).
            if (max_c2 >= min_c2) {
                count += (max_c2 - min_c2 + 1);
            }
        }

        return count;
    }
}