class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        // two pointer approach
        // left = 0, right = last
        int leftIdx = 0;
        int rightIdx = numbers.length-1;

        while(leftIdx < rightIdx) {
            int sum = numbers[leftIdx] + numbers[rightIdx];
            if(sum == target) {
                ans[0] = leftIdx+1;
                ans[1] = rightIdx+1;
                return ans;
            } else if(sum > target) {
                rightIdx--;
            } else {
                // sum is lesser than target
                leftIdx++;
            }
        }
        return ans;
    }
}