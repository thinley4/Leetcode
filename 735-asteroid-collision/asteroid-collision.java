class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack();

        for(int a: asteroids) {
            // if positive push
            if(a > 0) {
                stk.push(a);
            } else {
                // if negative
                // if stack not empty & stk peek positive & stk peek smaller than current asteroid, pop from stack
                while(!stk.isEmpty() && stk.peek() > 0 && stk.peek() < -a) {
                    stk.pop();
                }
                // store '-ve' value in stack after poping
                if(stk.isEmpty() || stk.peek() < 0) {
                    stk.push(a);
                }
                // if same value pop from stack
                if(stk.peek() == -a)
                    stk.pop();
            }
        }
        // store in array in reverse
        int[] res = new int[stk.size()];
        int endIdx = res.length-1;

        while(!stk.isEmpty()) {
            res[endIdx] = stk.pop();
            endIdx--;
        }
        return res;

    }
}