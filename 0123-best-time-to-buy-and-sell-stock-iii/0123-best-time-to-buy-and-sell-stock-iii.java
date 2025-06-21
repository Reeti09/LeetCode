class Solution {
    public int maxProfit(int[] prices) {
        int firstBuyProfit=-prices[0];
        int firstSellProfit=0;
        int secondBuyProfit=-prices[0];
        int secondSellProfit=0;
        for(int i=1;i<prices.length;i++){
            firstBuyProfit=Math.max(firstBuyProfit, -prices[i]);
            firstSellProfit=Math.max(firstSellProfit, firstBuyProfit+prices[i]);
            secondBuyProfit=Math.max(secondBuyProfit, firstSellProfit-prices[i]);
            secondSellProfit=Math.max(secondSellProfit, secondBuyProfit+prices[i]);
        }
        return secondSellProfit;
    }
}