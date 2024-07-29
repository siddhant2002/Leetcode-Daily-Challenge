class Solution {
    static int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long first = pow(5, even) % mod;
        long second = pow(4, odd) % mod;

        return (int)((first * second) % mod);
    }

    static long pow(int num, long n) {
        if(n == 0) return 1;

        long temp = pow(num, n / 2);

        if((n & 1) != 0) {
            return (num * temp * temp) % mod;
        }

        return (temp * temp) % mod;
    }
}