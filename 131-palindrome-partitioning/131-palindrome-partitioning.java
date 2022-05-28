class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s.toCharArray(), 0);
        return result;
    }

    private void dfs(List<List<String>> result, ArrayList<String> list, char[] charArr, int index) {
        if (index == charArr.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = index; i < charArr.length; i++) {
            if (isPalindrome(charArr, i, index)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i - index + 1; j++) {
                    sb.append(charArr[j + index]);
                }
                list.add(sb.toString());

                dfs(result, list, charArr, i + 1);

                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char[] charArr, int i, int index) {
        while (i > index) {
            if (charArr[i--] != charArr[index++]) {
                return false;
            }
        }
        return true;
    }
}