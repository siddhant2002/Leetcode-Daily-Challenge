class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int startVal = 1;
        int endVal = m;
        
        while (startVal <= endVal) {
            int midVal = (startVal + endVal) / 2;
            
            long temp = 1;
            
            for(int i = 0; i < n; i++) {
                temp *= midVal;
                
                if(temp > Integer.MAX_VALUE){
                    temp = Integer.MAX_VALUE;
                    break;
                }
            }
            
            if ((int)temp == m) {
                return midVal;
            } else if (temp > m) {
                endVal = midVal - 1;
            } else {
                startVal = midVal + 1;
            }
        }
        
        return -1;
    }
}