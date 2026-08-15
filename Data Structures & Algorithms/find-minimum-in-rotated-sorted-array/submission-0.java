class Solution {
    public int findMin(int[] nums) {

       int left = 0;
       int right = nums.length - 1;

       int min = 1001;

       while(left <= right){

        int mid = left + (right - left)/2;

        min = Math.min(nums[mid], min);

        if(nums[left] <= nums[mid]){

            if(nums[left] < nums[right]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }else{
            right = mid - 1;
        }
       } 

       return min;
    }
}
