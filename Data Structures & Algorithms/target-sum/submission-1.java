class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int range = 2*sum + 1;
        int[][] dp = new int[nums.length][range];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return count(nums, 0, target, sum, dp);

    }

    public int count(int[] nums,int idx, int target, int sum, int[][] dp){

        if(idx == nums.length){
            if(target == 0) return 1;
            else return 0;
        }

        if(target > sum || target < -sum) return 0;

        if(dp[idx][target + sum] != -1) return dp[idx][target + sum];

        int plus = count(nums,idx + 1, target + nums[idx], sum, dp);
        int minus =  count(nums,idx + 1, target - nums[idx], sum, dp);

        return dp[idx][target + sum] = plus + minus;
    }
}