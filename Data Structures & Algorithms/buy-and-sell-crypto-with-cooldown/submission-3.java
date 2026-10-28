class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){

            Arrays.fill(dp[i], -1);
        }

        return Math.max(fun(prices, 0, 0, dp), 0);

    }

    public int fun(int[] prices, int idx, int buy, int[][] dp){

        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;
        if(buy == 0){
            
            profit = Math.max(-prices[idx] + fun(prices, idx + 1, 1, dp), fun(prices, idx + 1, 0, dp));
            
        }else{

            profit = Math.max(prices[idx] + fun(prices, idx + 2, 0, dp), fun(prices, idx + 1, 1, dp));
        }

        return dp[idx][buy] = profit;
    }
}
