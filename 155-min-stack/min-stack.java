class MinStack {
    private List<int[]> stk;

    public MinStack() {
        stk = new ArrayList<>();
    }
    
    public void push(int val) {
        // if empty push, else check and compare and push smaller
        int[] top;
        if(stk.isEmpty()) 
            top = new int[]{val, val};
        else {
            // if not empty check stack and compare
            top = stk.get(stk.size() - 1);
        }
        int min_val = top[1];
        if(min_val > val)
            min_val = val;
        stk.add(new int[] {val, min_val});
    }
    
    public void pop() {
        stk.remove(stk.size()-1);
    }
    
    public int top() {
        return stk.isEmpty() ? -1 : stk.get(stk.size()-1)[0];
    }
    
    public int getMin() {
        return stk.isEmpty() ? -1 : stk.get(stk.size()-1)[1];
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