class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2 || s.indexOf("(") < 0 || s.lastIndexOf(")") < 0)
            return 0;

        boolean[] dp = new boolean[s.length()];
        Stack<Integer> que = new Stack<>();

        for (int i = s.indexOf("("); i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                que.push(i);
                continue;
            }

            if (!que.isEmpty()) {
                dp[i] = true;
                dp[que.pop()] = true;
            }
        }

        int maxLen = 0, now = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                now++;
                maxLen = Math.max(maxLen, now);
                continue;
            }
            now = 0;
        }
        return maxLen;
    }
}