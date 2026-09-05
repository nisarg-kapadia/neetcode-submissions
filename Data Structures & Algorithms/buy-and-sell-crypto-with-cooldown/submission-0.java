class Solution {
    public int maxProfit(int[] prices) {

      int n = prices.length;
      int[][] dp = new int[n][2];
      for(int i=0;i<n;i++){
        Arrays.fill(dp[i], -1);
      }  

      return fun(prices, 0, 0, dp);
    }

    public int fun(int[] prices, int idx, int buy, int[][] dp){
        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;
        if(buy == 0){

            profit = Math.max(fun(prices, idx + 1, buy, dp),
            -prices[idx] + fun(prices, idx + 1, 1, dp));
        }else{

            profit = Math.max(fun(prices, idx + 1, 1, dp),
            prices[idx] + fun(prices, idx + 2, 0, dp));
        }

        return dp[idx][buy] = profit;
    }
}
