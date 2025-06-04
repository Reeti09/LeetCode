class Solution {
    public String answerString(String word, int numFriends) {
        // If there is only one friend, return the whole word as is.
        if (numFriends == 1) {
            return word;
        }
      
        int wordLength = word.length();
        String answer = "";
      
        // Iterate over each character of the word.
        for (int i = 0; i < wordLength; ++i) {
            // Determine the maximum substring length that can be taken starting from the current position.
            int maxSubstringLength = Math.min(wordLength - i, wordLength - numFriends + 1);
          
            // Extract the substring starting at position i with the determined length.
            String currentSubstring = word.substring(i, i + maxSubstringLength);
          
            // Compare the current substring with the answer found so far and update if it is greater.
            if (answer.compareTo(currentSubstring) < 0) {
                answer = currentSubstring;
            }
        }
      
        // Return the largest lexicographical substring found.
        return answer;
    }
}
