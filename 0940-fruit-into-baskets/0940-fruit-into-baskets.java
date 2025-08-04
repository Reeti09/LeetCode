import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int start = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int end = 0; end < fruits.length; end++) {
            // Add the current fruit to the window
            fruitCount.put(fruits[end], fruitCount.getOrDefault(fruits[end], 0) + 1);

            // Shrink the window if it contains more than 2 types of fruit
            while (fruitCount.size() > 2) {
                int fruitToRemove = fruits[start];
                fruitCount.put(fruitToRemove, fruitCount.get(fruitToRemove) - 1);
                
                // If the count of a fruit becomes 0, remove it from the map
                if (fruitCount.get(fruitToRemove) == 0) {
                    fruitCount.remove(fruitToRemove);
                }
                
                // Move the start of the window
                start++;
            }

            // Update the maximum number of fruits
            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }
}