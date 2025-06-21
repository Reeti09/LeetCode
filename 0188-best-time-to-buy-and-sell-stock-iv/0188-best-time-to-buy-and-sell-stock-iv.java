class Solution {
    /**
     * Calculates the maximum profit achievable by completing at most k transactions.
     *
     * @param k The maximum number of transactions allowed.
     * @param prices An array where prices[i] is the price of a given stock on day i.
     * @return The maximum profit that can be achieved.
     */
    public int maxProfit(int k, int[] prices) {
        int numberOfDays = prices.length;

        // Handle edge cases:
        // If there are no prices or k is 0, no profit can be made.
        if (numberOfDays == 0 || k == 0) {
            return 0;
        }

        // Optimization for when k is very large:
        // If k is greater than or equal to half the number of days,
        // it means we can make as many transactions as possible.
        // In this scenario, the problem reduces to "Best Time to Buy and Sell Stock II",
        // where we can sum up all positive price differences.
        if (k >= numberOfDays / 2) {
            int maxProfit = 0;
            for (int i = 1; i < numberOfDays; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // Initialize a 2D array to store the maximum profit.
        // profits[transactionCount][0] represents the maximum profit after 'transactionCount'
        // transactions, not holding a stock.
        // profits[transactionCount][1] represents the maximum profit after 'transactionCount'
        // transactions, holding a stock.
        // The size k+1 is for transaction counts from 0 to k.
        int[][] profits = new int[k + 1][2];

        // Initialize the 'holding' state for each possible transaction count.
        // If we make 'transactionCount' buys and are holding a stock on day 0,
        // the "profit" is actually the negative of the stock's price, representing the cost.
        for (int transactionCount = 1; transactionCount <= k; ++transactionCount) {
            profits[transactionCount][1] = -prices[0];
        }

        // Iterate through each day starting from the second day (index 1).
        for (int dayIndex = 1; dayIndex < numberOfDays; ++dayIndex) {
            // Iterate for each possible transaction count, from k down to 1.
            // Iterating backwards is crucial to ensure that when we use
            // profits[transactionCount - 1][0], it refers to the value from the
            // previous day's calculation, not the current day's updated value for
            // a lower transaction count.
            for (int transactionCount = k; transactionCount > 0; --transactionCount) {
                // Update profit for the state where we are NOT holding a stock
                // after 'transactionCount' completed transactions.
                // This can be achieved in two ways:
                // 1. We were holding a stock (profits[transactionCount][1]) and sold it today (prices[dayIndex]).
                // 2. We were already not holding a stock (profits[transactionCount][0]) and did nothing today.
                profits[transactionCount][0] = Math.max(profits[transactionCount][1] + prices[dayIndex], profits[transactionCount][0]);

                // Update profit for the state where we ARE holding a stock
                // after 'transactionCount' buys.
                // This can be achieved in two ways:
                // 1. We completed 'transactionCount - 1' transactions, were not holding a stock
                //    (profits[transactionCount - 1][0]), and bought a stock today (-prices[dayIndex]).
                // 2. We were already holding a stock (profits[transactionCount][1]) and did nothing today.
                profits[transactionCount][1] = Math.max(profits[transactionCount - 1][0] - prices[dayIndex], profits[transactionCount][1]);
            }
        }

        // The maximum profit will be stored in profits[k][0],
        // which represents the maximum profit after at most 'k' transactions
        // where we end up not holding any stock (i.e., all transactions are complete).
        return profits[k][0];
    }
}