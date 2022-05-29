class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        return dfs(s, wordDict, 0, set);
    }

    private static boolean dfs(String s, List<String> wordDict, int index, Set<Integer> set) {
//        System.out.println(set);
        if (index == s.length()) {
            return true;
        }
        if (set.contains(index)) {
            return false;
        }
        //false
        String substring = s.substring(index);
        for (String word : wordDict) {
            
            if (substring.startsWith(word)) {
                if (dfs(s, wordDict, index + word.length(), set)) {
                    return true;
                }
            }
        }
        set.add(index);

        return false;
    
    }
}