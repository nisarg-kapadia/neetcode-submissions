class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];
        return partition(nums, 0, sum/2, dp);
    }

    public boolean partition(int[] nums, int idx, int target, Boolean[][] dp){

        if(target == 0){
            return true;
        }

        if(idx >= nums.length || target < 0){
            return false;
        }

        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        boolean notTake = partition(nums, idx + 1, target, dp);
        boolean take = false;
        if(nums[idx] <= target){
            take = partition(nums, idx + 1, target - nums[idx], dp);
        }

        return dp[idx][target] = take || notTake;
    }
}
