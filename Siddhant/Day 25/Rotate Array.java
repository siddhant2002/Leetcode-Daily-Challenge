class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length-1;
        k=k%(len+1);
        reverse(nums,0,len-k);
        reverse(nums,len-k+1,len);
        reverse(nums,0,len);
    }
    private void reverse(int arr[], int i, int j)
    {
        while(i<j)
        {
            int dup=arr[i];
            arr[i]=arr[j];
            arr[j]=dup;
            i++;
            j--;
        }
    }
}