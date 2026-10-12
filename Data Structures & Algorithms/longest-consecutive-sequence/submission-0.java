class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }    

        int maxLen = 1;
        

        for(int num : nums){

            if(!set.contains(num - 1)){
                int cur = num;
                int curLen = 0;
                while(set.contains(cur)){

                    cur++;
                    curLen++;
                }

                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
