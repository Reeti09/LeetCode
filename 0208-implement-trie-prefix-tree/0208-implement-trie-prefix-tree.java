class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    // Constructor for TrieNode
    public TrieNode() {
        children = new TrieNode[26]; // For 26 lowercase English letters
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    // Constructor for Trie
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Get index 0–25
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create node if missing
            }
            node = node.children[index]; // Move to next
        }
        node.isEnd = true; // Mark the end of the word
    }

    // Search if the word exists
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEnd;
    }

    // Check if any word starts with prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) { // <-- fixed from 'word' to 'prefix'
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }
}
