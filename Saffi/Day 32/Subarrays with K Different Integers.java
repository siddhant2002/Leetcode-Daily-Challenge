class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return task(nums, k + 1) - task(nums, k);
    }

    static int task(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        int ans = 0;

        while(right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if(map.size() < k) {
                ans += right - left + 1;
            }
            else if(map.size() == k) {
                while(map.size() == k) {
                    map.put(nums[left], map.get(nums[left]) -  1);

                    if(map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }

                    left++;
                }

                ans += right - left + 1;
            }

            right++;
        }

        return ans;
    }
}