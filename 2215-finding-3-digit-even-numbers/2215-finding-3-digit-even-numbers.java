class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // leading zero
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // avoid same digit
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue; // unique digits only
                    if (digits[k] % 2 != 0) continue; // must be even
                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    result.add(num);
                }
            }
        }

        // Convert Set to int[]
        int[] ans = new int[result.size()];
        int idx = 0;
        for (int num : result) ans[idx++] = num;
        return ans;
    }
}
