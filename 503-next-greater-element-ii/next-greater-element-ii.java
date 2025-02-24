class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] arr = new int[n];
        // Initialize -1 for every indicies
        for(int i=0; i<n; i++) {
            arr[i] = -1;
        }
        // for circular array, we iterate n*2 time
        for(int i=0; i<n*2; i++) {
            // stack.peek = current element in an array
            // nums[i%n] = next element in an array
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                // Found greater next elem
                arr[stack.pop()] = nums[i%n];
            }
            if(i<n) {
                stack.push(i);
            }
        }
        return arr;
    }
}