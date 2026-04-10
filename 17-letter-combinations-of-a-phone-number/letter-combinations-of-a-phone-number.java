class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, char[]> map = new HashMap<>();

        // no digit return empty array
        if(digits.length() == 0)
            return res;

        // Map digit to character
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        // call helper function
        helper(digits, "", res, 0, map);
        
        return res;
    }

    public void helper(String digits, String value, List<String> res, int index, HashMap<Character, char[]> map){
        // aim
        if(digits.length() == index) {
            res.add(value);
            return;
        }
        // 2 -> abc
        char currDigit = digits.charAt(index); // 2
        char[] charValues = map.get(currDigit); // [a, b, c]

        for(int i=0; i<charValues.length; i++) {
            helper(digits, value+charValues[i], res, index+1, map);
        }

    }
}