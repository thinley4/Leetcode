class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        // Smallest possible palindrom which is single char
        String maxStr = s.substring(0, 1);

        for(int i=0; i<s.length()-1; i++){
            String odd = expand(i, i, s);
            String even = expand(i, i+1, s);

            if(odd.length() > maxStr.length()){
                maxStr = odd;
            }
            if(even.length() > maxStr.length()){
                maxStr = even;
            }
        }

        return maxStr; 
    }
    private String expand(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}