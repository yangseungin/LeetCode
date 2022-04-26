class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> combination = new ArrayList<>();
        dfs(result, combination, nums);

        return result;
    }

    public  void dfs(List<List<Integer>> result, List<Integer> combination, int[] nums) {
        if (nums.length == combination.size()) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (combination.contains(nums[i])) {
                continue;
            }

            combination.add(nums[i]);
            dfs(result, combination, nums);
            combination.remove(combination.size() - 1);
        }
    }
}