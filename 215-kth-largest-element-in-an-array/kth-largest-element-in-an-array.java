class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int len = nums.length;

        // store all elem in pqueue
        for(int i=0; i<len; i++) {
            p.add(nums[i]);
        }

        // run loop till (len-k)
        int till = len - k;
        for(int i=1; i<=till; i++) {
            // remove from pqueue
            p.poll();
        }
        return p.peek();
    }
}