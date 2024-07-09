class Solution {
    public int majorityElement(int[] nums) {
        int element = Integer.MIN_VALUE, freq = 0;

        for(int i : nums) {
            if(element == i) {
                freq++;
            }
            else {
                if(freq > 0) freq--;
                else {
                    element = i;
                    freq = 1;
                }
            }
        }

        return element;
    }
}