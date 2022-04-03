class Solution {
    private Map<Character, String> numbers = new HashMap<>();
    
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

        for(char c: numbers.get(digits.charAt(sb.length())).toCharArray()){
            sb.append(c);
            dfs(digits,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void initPhoneNumber() {
        numbers.put('2', "abc");
        numbers.put('3', "def");
        numbers.put('4', "ghi");
        numbers.put('5', "jkl");
        numbers.put('6', "mno");
        numbers.put('7', "pqrs");
        numbers.put('8', "tuv");
        numbers.put('9', "wxyz");
    }

}