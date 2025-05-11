class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
                if (count == 3) return true;
            } else {
                count = 0;  // Reset the counter if even number is found
            }
        }

        return false;
    }
}
