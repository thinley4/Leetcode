class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        Arrays.sort(arrS);
        char[] arrT = t.toCharArray();
        Arrays.sort(arrT);

        if(arrS.length != arrT.length) return false;
        
        for(int i=0; i<arrS.length; i++){
            if(arrT[i] != arrS[i]){
                return false;
            }
        }
        return true;
    }
}