class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        // initialize array of length = n*2
        int[] nums2 = new int[n*2];

        int i=0;
        int j=0;
        while(i<n*2) {
            nums2[i] = nums[j];
            i++;
            j++;
            if(j>=n) {
                j=0;
            }
        }
        return nums2;
    }
}