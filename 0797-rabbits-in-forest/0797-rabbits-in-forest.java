class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int x : map.keySet()) {
            int count = map.get(x);
            int groupSize = x + 1;
            int groups = (count + x) / groupSize; // ceiling division
            total += groups * groupSize;
        }

        return total;
    }
}
