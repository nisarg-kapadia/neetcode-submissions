class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int max = 0;
        for(int w : weights){
            sum += w;
            max  = Math.max(max, w);
        }    

        int left = max;
        int right = sum;

        int ans = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(canShip(weights, mid, days)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean canShip(int[] weights, int cap, int days){

        int d = 1;
        int wt = 0;

        for(int w : weights){

            if(wt + w <= cap){
                wt += w;
            }else{
                d++;
                wt = w;
            }
        }

        return d <= days;

        

        
    }
}