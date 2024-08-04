class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        
        int xor = 0;
        
        for(int i : Arr) {
            xor = xor ^ i;
        }
        
        int lastBitNum = (xor & (xor - 1)) ^ xor; 
        // gives the number with only the last set bit of xor
        
        List<Integer> bucket1 = new ArrayList<>();
        List<Integer> bucket2 = new ArrayList<>();
        
        for(int i : Arr) {
            if((i & lastBitNum) != 0) bucket1.add(i);
            else bucket2.add(i);
        }
        
        int num1 = task(bucket1);
        int num2 = task(bucket2);
        
        int ans[] = {Math.max(num1, num2), Math.min(num1, num2)};
        
        return ans;
    }
    
    static int task(List<Integer> bucket) {
        int xor = 0;
        
        for(int i : bucket) {
            xor = xor ^ i;
        }
        
        return xor;
    }
}