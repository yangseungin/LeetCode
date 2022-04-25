class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        return dp[nums.length - 1];
    }
}