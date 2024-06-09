class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> nm=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--)
        {
            while(!nm.isEmpty() && nums2[i]>nm.peek())
            {
                nm.pop();
            }
            map.put(nums2[i], nm.isEmpty() ? -1 : nm.peek());
            nm.push(nums2[i]);
        }
        int ans[]=new int[nums1.length];
        for(int i=0; i<nums1.length; i++)
        {
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}