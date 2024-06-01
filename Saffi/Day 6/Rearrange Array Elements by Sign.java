class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 1;

        int ans[] = new int[nums.length];

        for(int i : nums) {
            if(i < 0) {
                ans[neg] = i;
                neg += 2; 
            }
            else {
                ans[pos] = i;
                pos += 2;
            }
        }
        return ans;
    }
}