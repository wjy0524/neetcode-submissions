class Solution {
    public int maxProfit(int[] prices) {
        //규칙 left pointer: buy right pointer: sell
        //if prices[left] > prices[right]: left = right
        //반대면 right++하면서 maxProfit 업데이트
        int mxProfit = 0;
        int left = 0;
        int right = 1;
        
        while(right < prices.length){
            if(prices[left] > prices[right]){
                left = right;
            }else{
                mxProfit = Math.max(mxProfit, prices[right] - prices[left]);
            }
            right++;
        }

        return mxProfit;
    }
}
