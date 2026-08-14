class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for(int p : piles){
            max = Math.max(p, max);
        }

        int left = 1;
        int right = max;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(canEat(piles, mid, h)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEat(int[] piles, int k, int h){

        int hours = 0;
        for(int p : piles){

            if(p <= k){
                hours++;
            }else{
                if(p % k == 0) hours += p/k;
                else hours += (p/k) + 1;
            }
        }

        return hours <= h;
    }
}
