class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        Set<String> result = new HashSet<>();
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars); // Optional: helps with optimizations

        backtrack(chars, new StringBuilder(), used, result);
        return result.size();
    }

    private void backtrack(char[] tiles, StringBuilder current, boolean[] used, Set<String> result) {
        for (int i = 0; i < tiles.length; i++) {
            if (used[i]) continue;
            // Avoid using the same character in the same position in the same recursive layer
            if (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.append(tiles[i]);
            result.add(current.toString());

            backtrack(tiles, current, used, result);

            // Backtrack
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}
