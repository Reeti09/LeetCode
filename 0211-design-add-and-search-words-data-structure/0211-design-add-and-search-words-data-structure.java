import java.util.*;

class WordDictionary {
    
    // Trie Node class
    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    // Pair class for BFS
    private class Pair {
        TrieNode node;
        int index;

        public Pair(TrieNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word to the Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // Searches using BFS (handles '.' wildcard)
    public boolean search(String word) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TrieNode node = current.node;
            int index = current.index;

            if (index == word.length()) {
                if (node.isEnd) return true;
                continue;
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        queue.offer(new Pair(node.children[i], index + 1));
                    }
                }
            } else {
                int charIndex = c - 'a';
                if (node.children[charIndex] != null) {
                    queue.offer(new Pair(node.children[charIndex], index + 1));
                }
            }
        }

        return false;
    }
}
