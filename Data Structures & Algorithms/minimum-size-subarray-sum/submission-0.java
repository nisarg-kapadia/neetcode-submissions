class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int curSum = 0;

        int left = 0;
        int maxlen = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){

            curSum += nums[right];

            while(curSum >= target){
                maxlen = Math.min(maxlen, right - left + 1);
                curSum -= nums[left];
                left++;
            }
        }

        return maxlen == Integer.MAX_VALUE ? 0 : maxlen;
    }
}