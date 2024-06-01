class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != element2) {
                count1++;
                element1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != element1) {
                count2++;
                element2 = nums[i];
            }
            else if(nums[i] == element1) {
                count1++;
            }
            else if(nums[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == element1) count1++;
            else if(nums[i] == element2) count2++;
        }

        List<Integer> ans = new ArrayList<>();

        if(count1 > n / 3) ans.add(element1);

        if(count2 > n / 3) ans.add(element2);
        return ans;
    }
}