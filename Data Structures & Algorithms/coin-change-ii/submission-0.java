class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length][amount + 1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return ways(coins, 0, amount, dp);
    }

    public int ways(int[] coins, int idx, int amt, int[][] dp){

        if(amt == 0){
            return 1;
        }

        if(amt < 0 || idx == coins.length){
            return 0;
        }

        if(dp[idx][amt] != -1){
            return dp[idx][amt];
        }

        int ways = 0;
        int notpick = ways(coins, idx + 1, amt, dp);
        int pick = 0;
        if(amt - coins[idx] >= 0){
            pick = ways(coins, idx, amt - coins[idx], dp);
        }

        return dp[idx][amt] = pick + notpick;
    }
}
