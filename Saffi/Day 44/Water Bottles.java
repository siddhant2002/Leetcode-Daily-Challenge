class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int ans = 0;
        
        while(numBottles >= numExchange) {
            int d = numBottles / numExchange;
            ans += d * numExchange;
            numBottles = numBottles % numExchange + d;
        }

        return ans + numBottles;
    }
}