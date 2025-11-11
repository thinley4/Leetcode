class Solution {
    public boolean isAnagram(String s, String t) {
        // sort both string
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        // if len not equal return false
        if(sArr.length != tArr.length)
            return false;
            
        for(int i=0; i<sArr.length; i++) {
            if(sArr[i] != tArr[i])
                return false;
        }
        
        return true;
    }
}