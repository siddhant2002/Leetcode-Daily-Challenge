import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        if(m > n) return -1;

        int left = 0, right = 0;

        for(int i : arr) {
            left = Math.max(left, i);
            right += i;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int res = task(arr, mid);

            if(res > m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return (int)left;
    }

    static int task(ArrayList<Integer> arr, int n) {

        int count = 1;

        int temp = 0;

        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) + temp <= n) {
                temp += arr.get(i);
            }
            else {
                count++;

                temp = arr.get(i);
            }
        }
        return count;
    }
}