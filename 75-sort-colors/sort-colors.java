class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        // Initialize freq of 0, 1 & 2 as '0'.
        count.put(0, 0);
        count.put(1, 0);
        count.put(2, 0);
        // Store the num with freq in hashmap
        for(int num : nums) {
            count.put(num, count.get(num) + 1);
        }
        int idx = 0;
        // int color = 0, 1, 2 (red, white, blue)
        for(int color = 0; color < 3; color++) {
            int freq = count.get(color);
            for(int j=0; j<freq; j++) {
                nums[idx] = color;
                idx++;
            }
        }
    }
}