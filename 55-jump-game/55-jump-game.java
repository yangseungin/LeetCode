class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return dfs(nums, 0, dp);
    }

    private  boolean dfs(int[] nums, int index, int[] dp) {
        if (index == nums.length - 1)
            return true;
        if (index >= nums.length)
            return false;

        if (dp[index] != -1)
            return dp[index] == 1;

        for (int i = index + 1; i <= index + nums[index]; i++) {

            if (dfs(nums, i, dp)) {
                dp[index] = 1;
                return true;
            }

        }
        dp[index] = 0;
        return false;
    }
}