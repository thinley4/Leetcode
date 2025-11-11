class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        // 'open bracket' push
        // 'close bracket' check top if match pop
        for(int i=0; i<s.length(); i++) {
            // open 
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stk.push(s.charAt(i));
            else {
                // close
                // if stack empty invalid
                if(stk.isEmpty())
                    return false;

                if( (stk.peek() == '(' && s.charAt(i) == ')') || (stk.peek() == '{' && s.charAt(i) == '}') || (stk.peek() == '[' && s.charAt(i) == ']') )
                    stk.pop();
                else
                    return false;
            }
        }

        return stk.isEmpty();
    }
}