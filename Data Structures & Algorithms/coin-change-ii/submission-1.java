class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length + 1][amount + 1];

        int n = coins.length;

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i = n-1;i>=0;i--){

            for(int amt = 0;amt <= amount;amt++){

                int notpick = dp[i + 1][amt];
                int pick = 0;
                if(amt >= coins[i]){
                    pick = dp[i][amt - coins[i]];
                }

                dp[i][amt] = pick + notpick;
            }
        }

        return dp[0][amount];
        
    }

    // public int ways(int[] coins, int idx, int amt, int[][] dp){

    //     if(amt == 0){
    //         return 1;
    //     }

    //     if(amt < 0 || idx == coins.length){
    //         return 0;
    //     }

    //     if(dp[idx][amt] != -1){
    //         return dp[idx][amt];
    //     }

    //     int ways = 0;
    //     int notpick = ways(coins, idx + 1, amt, dp);
    //     int pick = 0;
    //     if(amt - coins[idx] >= 0){
    //         pick = ways(coins, idx, amt - coins[idx], dp);
    //     }

    //     return dp[idx][amt] = pick + notpick;
    // }
}
