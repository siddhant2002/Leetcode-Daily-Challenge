class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // First way - using HashMap
        // TC = O(N), SC = O(N)

        // HashMap<Integer, Integer> map = new HashMap<>();

        // int prefixSum = 0;

        // map.put(0, 1);

        // int ans = 0;

        // for(int i = 0; i < nums.length; i++) {
        //     prefixSum += nums[i];

        //     if(map.containsKey(prefixSum - goal)) ans += map.get(prefixSum - goal);

        //     map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        // }

        // return ans;

        // -------------------------------------------------------------

        // 2ND WAY
        // TC = O(N), SC = O(1)

        // We will find the count of all subarrays with sum <= goal
        // We will find the count of all subarrays with sum <= goal - 1
        // We will subtrac tem to get our answer.

        return task(nums, goal) - task(nums, goal - 1);
    }

    static int task(int[] nums, int goal) {
        if(goal < 0) return 0;

        int l = 0, r = 0, count = 0, sum = 0;

        while(r < nums.length) {
            sum += nums[r];

            while(sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);

            r++;
        }

        return count;
    }
}