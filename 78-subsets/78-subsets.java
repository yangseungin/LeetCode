class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        dfs(res, sub, nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sub, int[] nums, int idx) {
        res.add(new ArrayList<>(sub));

        for (int i = idx; i < nums.length; i++) {
            sub.add(nums[i]);
            dfs(res, sub, nums, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
    
}