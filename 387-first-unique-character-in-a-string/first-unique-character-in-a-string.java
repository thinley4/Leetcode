class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // char and value(repetation) added in hashmap
        for(int i=0; i<s.length(); i++) {
            // put the element with repetation value
            map.put(s.charAt(i), 1 + map.getOrDefault(s.charAt(i), 0));
        }

        // iterate in a string and if value is 1 than return index
        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}