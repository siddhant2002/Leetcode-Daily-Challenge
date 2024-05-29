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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int n = 1;

        ListNode temp = head;

        while(temp.next != null) {
            n++;

            temp = temp.next;
        }

        temp.next = head;

        k = k % n;

        k = n - k - 1;

        ListNode curr = head;

        while(k-- > 0) {
            curr = curr.next;
        }

        ListNode ans = curr.next;

        curr.next = null;

        return ans;
    }
}