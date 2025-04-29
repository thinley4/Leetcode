

class Solution {
    public String reverseWords(String s) {
        // split() - split into array of words
        // \\s means "whitespace" (space, tab, or newline).
        // + means "one or more times".
        // So \\s+ = one or more spaces/tabs/newlines.

        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();

        for(int i=words.length-1; i>=0; i--) {
            res.append(words[i]);
            if(i != 0) {
                res.append(" ");
            }
        }

        return res.toString().trim();
    }
}