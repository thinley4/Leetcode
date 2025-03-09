class Solution {
    public boolean isPalindrome(int start, int last, String s) {
        while(start < last) {
            if(s.charAt(start) != s.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalindrome(i, j, s)) {
                    ans++;
                }
            }   
        }
        return ans;
    }
}