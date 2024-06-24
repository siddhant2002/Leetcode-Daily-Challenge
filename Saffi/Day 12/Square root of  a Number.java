class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		
		long startVal = 1;
        long endVal = x;
        long target = 0;
        
        while (startVal <= endVal) {
            long midVal = (startVal + endVal) / 2;
            
            if (midVal * midVal == x) {
                return midVal;
            } else if (midVal * midVal > x) {
                endVal = midVal - 1;
            } else {
                startVal = midVal + 1;
                target = midVal;
            }
        }
        
        return target;
	 }
}