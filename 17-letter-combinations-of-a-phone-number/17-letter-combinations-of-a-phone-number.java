class Solution {
    private Map<Character, char[]> numbers = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        initPhoneNumber();

        dfs(digits, new StringBuilder(), result);

        return result;
    }
    private void dfs(String digits, StringBuilder sb, List<String> list) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        for(char c: numbers.get(digits.charAt(sb.length()))){
            sb.append(c);
            dfs(digits,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void initPhoneNumber() {
        numbers.put('2', new char[]{'a', 'b', 'c'});
        numbers.put('3', new char[]{'d', 'e', 'f'});
        numbers.put('4', new char[]{'g', 'h', 'i'});
        numbers.put('5', new char[]{'j', 'k', 'l'});
        numbers.put('6', new char[]{'m', 'n', 'o'});
        numbers.put('7', new char[]{'p', 'q', 'r', 's'});
        numbers.put('8', new char[]{'t', 'u', 'v'});
        numbers.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

}