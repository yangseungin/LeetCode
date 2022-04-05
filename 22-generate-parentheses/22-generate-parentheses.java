class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(n, n, new StringBuilder(), result);

        return result;
    }
    
    public void dfs(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, sb.append("("), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            dfs(left, right - 1, sb.append(")"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}