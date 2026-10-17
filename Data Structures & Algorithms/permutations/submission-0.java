class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];

        List<List<Integer>> ans = new ArrayList<>();

        fun(nums, new ArrayList<>(), ans, used);
        return ans;
    }

    public void fun(
        int[] nums, List<Integer> row, List<List<Integer>> ans, boolean[] used) {
        
        if(row.size() == nums.length){

            ans.add(new ArrayList<>(row));
            return;
        }
        

        for(int i=0;i<nums.length;i++){
            
            if(used[i]) continue;

            used[i] = true;
            row.add(nums[i]);

            fun(nums, row, ans, used);

            used[i] = false;
            row.remove(row.size() - 1);
        }
    }
}
