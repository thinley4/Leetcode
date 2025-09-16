class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int slen = s.length();
        boolean[] bs = new boolean[slen+1];
        bs[0] = true;

        for(int i=1; i<=slen; i++) {
            for(String word : wordDict) {
                // calculate start
                // start = curr - word.length()
                int start = i - word.length();
                // must be positive, check index 0 is true
                // compare string, if same string make true 
                if(start >= 0 && bs[start] == true) {
                    String halfString = s.substring(start, i);
                    if(halfString.equals(word)) {
                        bs[i] = true;
                    }
                }
            }
        }

        return bs[bs.length-1];
    }
}