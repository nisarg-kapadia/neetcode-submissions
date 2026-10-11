class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = 1;

        for(int i=1;i<n;i++){

            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int suffix = nums[n - 1];

        for(int i=n-2;i>=0;i--){
            prefix[i] *= suffix;
            suffix *= nums[i];
        }

        return prefix;
    }
}  
