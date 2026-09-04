class Solution {
    public int maxProfit(int[] prices) {
        int buyIdx = 0;
        int sellIdx = 1;
        int maxProfit = 0;

        while(sellIdx < prices.length){
            if(prices[sellIdx] > prices[buyIdx]){
                maxProfit = Math.max(maxProfit, prices[sellIdx]-prices[buyIdx]);
                sellIdx++;
            }else{
                buyIdx = sellIdx;
                sellIdx++;
            }

        }

        return maxProfit;
    }
}
