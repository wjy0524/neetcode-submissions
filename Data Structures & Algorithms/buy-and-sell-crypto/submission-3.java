class Solution {
    public int maxProfit(int[] prices) {
        int sellDay = 1;
        int buyDay = 0;
        int maxProfit = 0;

        while(sellDay < prices.length){
            //이경우만 profit이 있는거니까 이때 maxProfit 업뎃
            if(prices[sellDay] > prices[buyDay]){
                maxProfit = Math.max(maxProfit, prices[sellDay] - prices[buyDay]);
            }else{
                buyDay = sellDay;
            }
            sellDay++;
        }

        return maxProfit;
    }
}
