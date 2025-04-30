class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++) {
            // if open push in stack
            char c = s.charAt(i);
            if(map.containsValue(c)) {
                stack.push(c);
            } else if(map.containsKey(c)) {
                // close bracket
                if(stack.isEmpty() || stack.pop() != map.get(c)) {
                    // if empty OR ')' NOT '('
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}