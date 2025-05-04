class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), res, digitToLetters);

        return res;
    }

    public void backtrack(String digits, int idx, StringBuilder comb, List<String> res, HashMap<Character, String> digitToLetters) {
        // if digits are two like "23" then when length equal to '2'
        // then return
        if(idx == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(idx));
        // taking 'a' -> 'def'
        // like: 'ad', 'ae', 'af'
        for(char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx+1, comb, res, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}