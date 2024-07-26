class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int newNums[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);

            for(char c : s.toCharArray()) {
                newNums[i] = newNums[i] * 10 + (mapping[c - '0']);
            }
        }

        mergeSort(newNums, nums, 0, nums.length - 1);
        return nums;
    }

    static void mergeSort(int newNums[], int[] nums, int start, int end) {
        if(start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(newNums, nums, start, mid);
        mergeSort(newNums, nums, mid + 1, end);

        sort(newNums, nums, start, mid, end);
    }

    static void sort(int[] newNums, int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int temp1[] = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0, ind = 0;

        while(i <= mid && j <= end) {
            if(newNums[i] <= newNums[j]) {
                temp[k++] = newNums[i];

                temp1[ind++] = nums[i];

                i++;
            }
            else {
                temp[k++] = newNums[j];

                temp1[ind++] = nums[j];

                j++;
            }
        }

        while(i <= mid) {
            temp[k++] = newNums[i];

            temp1[ind++] = nums[i];

            i++;
        }

        while(j <= end) {
            temp[k++] = newNums[j];

            temp1[ind++] = nums[j];

            j++;
        }

        for(i = start; i <= end; i++) {
            newNums[i] = temp[i - start];

            nums[i] = temp1[i - start];
        }
    }
}