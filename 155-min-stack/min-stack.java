class MinStack {
    List<int[]> stack = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        // empty push val & minVal
        if(stack.isEmpty()) {
            stack.add(new int[] {val, val});
        }
        // Not empty, compare with stack top min and curr min
        else {
            int minVal = Integer.MIN_VALUE;
            int size = stack.size();
            int min = stack.get(size - 1)[1];

            minVal = Math.min(val, min);
            stack.add(new int[] {val, minVal});
        }
    }
    
    public void pop() {
        int size = stack.size();
        stack.remove(size-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1)[0];
    }
    
    public int getMin() {
        return stack.get(stack.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */