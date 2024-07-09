class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(task(red, blue), task(blue, red));
    }
    
    static int task(int one, int two) {
        int ans = 0;
        int k = 1;
        
        while(one > 0 || two > 0) {
            if(one >= k) {
                one -= k;
                k++;
                ans++;
            }
            else {
                break;
            }
            
            if(two >= k) {
                two -= k;
                k++;
                ans++;
            }
            else {
                break;
            }
        }
        
        return ans;
        
    }
}