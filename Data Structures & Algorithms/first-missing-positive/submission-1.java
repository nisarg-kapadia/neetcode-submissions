class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int[] buckets = new int[n];
        for(int i=0;i<n;i++){

            if(nums[i] > 0 && nums[i] <= n){
                buckets[nums[i]-1]++; 
            }
        }

        for(int i=0;i<n;i++){
            if(buckets[i] == 0){
                return i + 1;
            }
        }

        return n + 1;


    }
}