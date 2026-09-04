class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0;
        int sellDay = 1;
        int maxProfit = 0;

        while(sellDay < prices.length){
            if(prices[sellDay] > prices[buyDay]){
                maxProfit = Math.max(maxProfit, prices[sellDay]-prices[buyDay]);
            }else{
                buyDay = sellDay;
            }
            sellDay++;
        }

        return maxProfit;
    }
}
