class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int ans = 0;

        map.put(0, 1);
        for(int i=0;i<nums.length;i++){

            prefix += nums[i];
            int need = prefix - k;

            if(map.containsKey(need)){
                ans += map.get(need);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }   

        return ans;
    }
}