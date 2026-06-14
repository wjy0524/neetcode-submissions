class Solution {
    public int maxProfit(int[] prices) {
        int buyIdx = 0;
        int sellIdx = 1;
        int mxProfit = 0;

        while(sellIdx < prices.length){
            //prices[buyIdx] > prices[sellIdx]이면 buyIdx = sellIdx 여야함
            if(prices[buyIdx] > prices[sellIdx]){
                buyIdx = sellIdx;
            }else{
                mxProfit = Math.max(mxProfit, prices[sellIdx] - prices[buyIdx]);
            }
            sellIdx++;
        }

        return mxProfit;
    }
}
