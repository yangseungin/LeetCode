class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = i; j >= 1; j--) {
                sum = sum + dp[i - j] * dp[j - 1];
            }
            dp[i] = sum;
       }

        return dp[n];
    }
}