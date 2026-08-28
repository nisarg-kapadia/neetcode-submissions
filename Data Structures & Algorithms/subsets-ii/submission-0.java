class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void recurse(int[] nums, int idx, List<Integer> cur, List<List<Integer>> ans){

        
        ans.add(new ArrayList<>(cur));
            

        if(idx > nums.length) return;

        for(int i = idx; i < nums.length; i++){

            if(i > idx && nums[i] == nums[i-1]) continue;

            cur.add(nums[i]);
            recurse(nums, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }


}
