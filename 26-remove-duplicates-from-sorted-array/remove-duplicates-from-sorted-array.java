class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;// slow index
        int k=0;
        int j=1;// fast index
        int n=1; //count
        while(j<nums.length) {
            // if same
            if(nums[i] == nums[j]) {
                j++;
            } else {
                // not same
                n++;
                nums[k+1] = nums[j];
                k++;
                i=j;
                j++;
            }
        }
        return n;
    }
}