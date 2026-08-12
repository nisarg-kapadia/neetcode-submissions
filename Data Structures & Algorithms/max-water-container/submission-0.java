class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;

        int max = 0;
        while(left < right){

            int width = right - left;

            max = Math.max(max, width * Math.min(heights[left], heights[right]));

            if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }


        }    

        return max;
    }
}
