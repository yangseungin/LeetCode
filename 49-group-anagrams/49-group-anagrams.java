class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String sortedStr = String.valueOf(tmp);
            map.computeIfAbsent(sortedStr, s -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}