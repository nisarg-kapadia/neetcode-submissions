class Solution {
    public int trap(int[] height) {
        
        int ans = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right){

            if(height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left];
                left++;
                
            }else{
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
        
    }
}
