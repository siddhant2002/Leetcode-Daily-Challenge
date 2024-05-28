class Solution {
    public double myPow(double x, int n) {

        if(n < 0) return task(1 / x, 0 - n);
        return task(x, n);
    }

    static double task(double x, int n) {
        if(n == 0) return 1.0;

        double temp = task(x, n / 2);

        if((n & 1) != 0) {
            return temp * temp * x;
        }

        return temp * temp;
    }
}