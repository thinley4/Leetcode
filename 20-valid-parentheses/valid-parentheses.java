class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        // iterate in string
        for(int i=0; i<n; i++) {
            // if stack is empty and close bracket return false
            if(stk.empty() && ( s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' ) )
                return false;

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')  {
                stk.push(s.charAt(i));
            } else {
            // for close bracket
            // validate matching
                if( (s.charAt(i) == ')' && stk.peek() == '(' ) || (s.charAt(i) == '}' && stk.peek()=='{' ) || (s.charAt(i) == ']' && stk.peek() == '[' ) ) {
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }
            }
        }

        return stk.empty();
    }
}