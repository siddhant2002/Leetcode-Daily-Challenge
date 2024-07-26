import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int left = 0, right = 0;

        for(int i : boards) {
            left = Math.max(i, left);
            right += i;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int count = task(boards, mid);

            if(count > k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    static int task(ArrayList<Integer> boards, int n) {
        int temp = 0;
        int count = 1;

        for(int i = 0; i < boards.size(); i++) {
            if(temp + boards.get(i) <= n) {
                temp += boards.get(i);
            }
            else {
                count++;
                temp = boards.get(i);
            }
        }

        return count;
    }
}