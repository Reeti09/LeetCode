class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;  // Number of even indices → 5 choices
        long oddCount = n / 2;         // Number of odd indices → 4 choices

        long powerOf5 = modPow(5, evenCount, MOD);
        long powerOf4 = modPow(4, oddCount, MOD);

        return (int) ((powerOf5 * powerOf4) % MOD);
    }

    // Modular exponentiation: (base^exp) % mod
    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}
