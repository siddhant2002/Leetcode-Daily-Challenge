/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int ans[] = new int[2];

        ans[0] = Integer.MAX_VALUE;

        ListNode prev = head;

        ListNode curr = head.next;

        int first = -1, second = -1;

        int level = 1;

        while(curr.next != null) {
            level++;

            if((prev.val > curr.val && curr.next.val > curr.val) || (prev.val < curr.val && curr.next.val < curr.val)) {
                if(first == -1) {
                    first = level;
                    ans[1] = level;
                }
                else {
                    second = first;
                    first = level;

                    ans[0] = Math.min(ans[0], first - second);
                }
            } 

            prev = curr;
            curr = curr.next;
        }

        if(second == -1) {
            ans[0] = -1;
            ans[1] = -1;

            return ans;
        }

        ans[1] = first - ans[1];

        return ans;
    }
}