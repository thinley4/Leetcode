class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int max = 0;

        for(int i : nums) {
            int temp = Math.max(max, prev+i);
            prev = max;
            max = temp;
        }
        return max;
    }
}