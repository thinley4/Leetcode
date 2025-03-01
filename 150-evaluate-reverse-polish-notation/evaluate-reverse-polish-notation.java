class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if(s.equals("-")) {
                // first pop element is second number in an array
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if(s.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else {
                // When element is Number, push in stack
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}