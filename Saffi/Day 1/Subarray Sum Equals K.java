class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;

        int ans = 0;

        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            ans += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, 1 + map.getOrDefault(prefixSum, 0));

        }
        return ans;
    }
}