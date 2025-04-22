class Solution {
    static final int MOD = 1_000_000_007;
    static long[] fact;
    static long[] invFact;

    // Fast exponentiation
    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    // Precompute factorials
    void precompute(int max) {
        fact = new long[max + 1];
        invFact = new long[max + 1];
        fact[0] = 1;
        for (int i = 1; i <= max; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[max] = pow(fact[max], MOD - 2);
        for (int i = max - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    // Combination function C(n, k)
    long comb(int n, int k) {
        if (k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    // Factorization
    Map<Integer, Integer> getPrimeFactors(int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                x /= i;
            }
        }
        if (x > 1) map.put(x, 1);
        return map;
    }

    public int idealArrays(int n, int maxValue) {
        precompute(n + 10000); // buffer for combinations
        long res = 0;
        for (int v = 1; v <= maxValue; v++) {
            Map<Integer, Integer> primes = getPrimeFactors(v);
            long ways = 1;
            for (int exp : primes.values()) {
                ways = ways * comb(n - 1 + exp, exp) % MOD;
            }
            res = (res + ways) % MOD;
        }
        return (int) res;
    }
}
