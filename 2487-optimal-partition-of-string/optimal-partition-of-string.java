class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1;
        for(int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            // Not in hashset
            if(set.contains(ch) == false) {
                set.add(ch);
            } else { // Present in hashset
                set.clear();
                count++;
                set.add(ch);
            }
        }
        return count;
    }
}