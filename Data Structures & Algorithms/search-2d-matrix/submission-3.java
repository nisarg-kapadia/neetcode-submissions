class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        int left = 0;
        int right = m - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]){
                
                int l = 0;
                int r = n-1;
                while(l <= r){                
                    int midCol = l + (r-l)/2;
                    if(target == matrix[mid][midCol]){
                        return true;
                    }else if(matrix[mid][midCol] > target){
                        r = midCol - 1;
                    }else{
                        l = midCol + 1;
                    }
                }

                return false;
            }else if(target < matrix[mid][0]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
        
    }
}
