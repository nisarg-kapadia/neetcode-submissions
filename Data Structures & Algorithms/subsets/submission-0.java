class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void fun(int[] nums, int idx, List<Integer> row, List<List<Integer>> ans){

        if(idx == nums.length){

            ans.add(new ArrayList<>(row));
            return;
        }

        row.add(nums[idx]);
        fun(nums, idx + 1, row, ans);
        row.remove(row.size() - 1);
        fun(nums, idx + 1, row, ans);
    }
}
