class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count=numBottles;
        while(numBottles>0)
        {
            numBottles-=numExchange;
            numBottles++;
            count++;
        }
        return count-1;
    }
}