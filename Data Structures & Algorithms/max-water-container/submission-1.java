class Solution {
    public int maxArea(int[] heights) {
        
        int ans = 0;
        int n = heights.length;

        int left = 0;
        int right = n - 1;

        while(left < right){
            int width = right - left;
            ans = Math.max(ans, Math.min(heights[left], heights[right]) * width);
            if(heights[left] < heights[right]){
                left++;
                
            }else{
                right--;
            }
        }

        return ans;
    }
}
