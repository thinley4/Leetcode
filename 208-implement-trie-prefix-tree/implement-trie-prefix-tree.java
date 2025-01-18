class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }
    
    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        // Insert function
        private void insert(String word, int idx) {
            // base case
            if (idx >= word.length()) return;
            //find index
            int i = word.charAt(idx) - 'a';
            // No node
            if(nodes[i] == null){
                nodes[i] = new Node();
            }
            // If current char is at the last node
            if(idx == word.length()-1) {
                nodes[i].isEnd = true;
            }
            nodes[i].insert(word, idx+1);
        }

        // Search function
        private boolean search(String word, int idx){
            // If word == "apple" to be search
            // Inserted word "app" (available in tree)
            if(idx >= word.length()) return false;

            // Find node in tree
            Node node = nodes[word.charAt(idx) - 'a'];
            // Node not found in tree
            if(node == null) return false;

            // found
            if(idx == word.length()-1 && node.isEnd) return true;

            return node.search(word, idx+1);
        }

        // Startwith function
        private boolean startsWith(String prefix, int idx) {
            // Prefix is greater than the available word
            if(idx >= prefix.length()) return false;

            Node node = nodes[prefix.charAt(idx) - 'a'];

            // Node not present
            if(node == null) return false;

            // prefix found
            if(idx == prefix.length() - 1) return true;

            return node.startsWith(prefix, idx+1);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */