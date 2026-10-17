class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        fun(candidates, 0, target, new ArrayList<>(), ans);

        return ans;

    }

    public void fun(int[] nums, int idx, int target, List<Integer> row, List<List<Integer>> ans){

        if(target == 0){

            ans.add(new ArrayList<>(row));
            return;
        }

        if(idx == nums.length || nums[idx] > target || target < 0){
            return;
        }

        for(int i = idx; i < nums.length; i++){

            if(i > idx && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            
            row.add(nums[i]);
            fun(nums, i + 1, target - nums[i], row, ans);
            row.remove(row.size()-1);
        }
    }
}
