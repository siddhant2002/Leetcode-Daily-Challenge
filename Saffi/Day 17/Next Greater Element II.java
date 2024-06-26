class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        for(int i = nums.length - 2; i >= 0; i--) {
            stk.push(nums[i]);
        }

        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);

        for(int i = nums.length - 1; i>= 0; i--) {
            while(!stk.isEmpty() && stk.peek() <= nums[i]) {
                stk.pop();
            }

            if(!stk.isEmpty()) {
                if(stk.peek() > nums[i]) {
                    ans[i] = stk.peek();
                }
            }

            stk.push(nums[i]);
        }

        return ans;
    }


}