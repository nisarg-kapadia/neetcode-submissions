class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    public void fun(int[] nums, int idx, int target, List<Integer> row, List<List<Integer>> ans){

        if(target == 0){
            ans.add(new ArrayList<>(row));
            return;
        }

        if(idx == nums.length || target < 0) return;

        row.add(nums[idx]);
        fun(nums, idx, target - nums[idx], row, ans);
        row.remove(row.size() - 1);
        fun(nums, idx + 1, target, row, ans);
    } 
}
