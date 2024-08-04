class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;

        boolean primes[] = new boolean[n];

        primes[0] = true;
        primes[1] = true;

        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(primes[i]) continue;

            int k = 2 * i;

            while(k < n) {
                primes[k] = true;
                k += i;
            }
        }

        int ans = 0;

        for(boolean i : primes) {
            if(!i) ans++;
        }

        return ans;
    }
}