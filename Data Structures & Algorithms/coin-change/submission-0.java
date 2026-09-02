class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for(int amt = 1; amt <= amount; amt++){

            for(int c : coins){

                if(amt >= c){
                    dp[amt] = Math.min(dp[amt-c] + 1, dp[amt]);
                }
            }
        }

        return dp[amount] == 1000000 ? -1 : dp[amount];
    }
}
