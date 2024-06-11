class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=nums1.length;
        for(int i=len-1,j=m-1,k=n-1; i>=0; i--)
        {
            if(j>=0 && k>=0)
            {
                if(nums2[k]>nums1[j])
                {
                    nums1[i]=nums2[k];
                    k--;
                }
                else
                {
                    nums1[i]=nums1[j];
                    j--;
                }
            }
            else if(j>=0)
            {
                nums1[i]=nums1[j];
                j--;
            }
            else
            {
                nums1[i]=nums2[k];
                k--;
            }
        }
    }
}