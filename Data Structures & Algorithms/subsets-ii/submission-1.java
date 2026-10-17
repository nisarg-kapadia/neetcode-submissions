class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

       Arrays.sort(nums); 
       List<List<Integer>> ans = new ArrayList<>();

       fun(nums, 0, new ArrayList<>(), ans);

       return ans; 
    }

    public void fun(int[] nums, int idx, List<Integer> row, List<List<Integer>> ans){


        ans.add(new ArrayList<>(row));
           

        for(int i=idx;i<nums.length;i++){

            if(i > idx && nums[i] == nums[i-1]) continue;

            row.add(nums[i]);
            fun(nums, i + 1, row, ans);
            row.remove(row.size() - 1);
        }
    }


}
