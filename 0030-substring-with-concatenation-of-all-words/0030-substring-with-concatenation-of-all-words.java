import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int windowSize = wordLen * numWords;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate over different starting points
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> currentMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);

                    // If word frequency exceeds, move left pointer
                    while (currentMap.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // Valid window found
                    if (right - left == windowSize) {
                        result.add(left);
                    }
                } else {
                    // Reset when encountering an invalid word
                    currentMap.clear();
                    left = right;
                }
            }
        }
        return result;  // ✅ Return moved outside the loop
    }

    
}
