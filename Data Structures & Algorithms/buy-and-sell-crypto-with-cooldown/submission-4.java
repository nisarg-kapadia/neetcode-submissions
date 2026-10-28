class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 2][2];
        
        for(int i = n-1; i>=0;i--){

            for(int buy=0; buy<=1; buy++){
                
                int profit = 0;
                if(buy == 0){

                    profit = Math.max(-prices[i] + dp[i+1][1], dp[i+1][0]);

                }else{

                    profit = Math.max(prices[i] + dp[i+2][0], dp[i+1][1]);
                }

                dp[i][buy] = profit;

            }
        }

        return dp[0][0];

        

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
