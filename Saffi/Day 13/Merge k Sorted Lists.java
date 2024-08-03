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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode root : lists) {
            while(root != null) {
                pq.offer(root.val);
                root = root.next;
            }
        }

        if(pq.isEmpty()) return null;

        ListNode ans = new ListNode(pq.poll());

        ListNode ptr = ans;

        while(!pq.isEmpty()) {
            ptr.next = new ListNode(pq.poll());
            ptr = ptr.next;
        }

        return ans;
    }
}