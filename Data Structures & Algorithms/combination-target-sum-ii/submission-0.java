class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        recurse(candidates, 0, target, new ArrayList<>(), ans);

        return ans;

    }

    public void recurse(int[] nums, int idx, int target, List<Integer> cur, List<List<Integer>> ans){

        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(idx >= nums.length || target < 0) return;

        

        for(int i = idx ; i < nums.length; i++){

            if(i > idx && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target){
                break;
            }

            cur.add(nums[i]);
            recurse(nums, i + 1, target - nums[i], cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
