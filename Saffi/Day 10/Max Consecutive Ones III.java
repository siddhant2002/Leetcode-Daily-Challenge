class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0, kc = k;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                right++;
            }
            else {
                if(kc > 0) {
                    right++;
                    kc--;
                }
                else {
                    max = Math.max(max, right - left);

                    while(left < nums.length && nums[left] == 1) {
                        left++;
                    }

                    left++;

                    right++;
                }
            }
        }


        max = Math.max(max, right - left);

        return max;
    }
}