class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        // iterate over array
        for(int i=0; i<heights.length; i++) {
            // while stack not empty && heights[i] <= heights[stack.peek()] (prev value)
            while(stack.peek() != -1 && heights[i] <= heights[stack.peek()] ){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1; // since prev elem is pop so, -1 is needed
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // while stack is not empty
        while(stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
}