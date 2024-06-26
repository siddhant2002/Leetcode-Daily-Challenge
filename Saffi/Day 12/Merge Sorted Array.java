class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;

        int pos1 = m - 1, pos2 = n - 1;

        while(pos1 >= 0 && pos2 >= 0) {
            if(nums1[pos1] >= nums2[pos2]) {
                nums1[last--] = nums1[pos1--];
            }
            else {
                nums1[last--] = nums2[pos2--];
            }
        }

        while(pos2 >= 0) {
            nums1[last--] = nums2[pos2--];
        }
    }
}