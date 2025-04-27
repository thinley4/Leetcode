class Solution {
    public boolean isPalindrome(String s) {
        // uppercase to lowercase
        // remove non-alphanumeric characters
        String lower = s.toLowerCase();
        System.out.println(lower);
        String clean = lower.replaceAll("[^A-Za-z0-9]", "");
        char[] arr = clean.toCharArray();
        System.out.println(arr);
        int i=0;
        int j=arr.length-1;
        while(i<=j) {
            if(arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}