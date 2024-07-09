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
class Pair{
    int first, second;
    Pair(int f, int s) {
        first = f;
        second = s;
    }
}
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;

        ListNode ptr = head;

        while(ptr != null) {
            ptr = ptr.next;
            n++;
        }

        int ans[] = new int[n];

        Stack<Pair> stk = new Stack<>();

        ListNode node = head;

        int ind = 0;

        while(node != null) {
            while(!stk.isEmpty() && stk.peek().first < node.val) {
                ans[stk.peek().second] = node.val;
                stk.pop();
            }

            stk.push(new Pair(node.val, ind));

            node = node.next;

            ind++;
        }

        return ans;
    }
}