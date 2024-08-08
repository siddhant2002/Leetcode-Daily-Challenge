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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        if(head.next.next==null)
        {
            ListNode ptr=head.next;
            ptr.next=head;
            head.next=null;
            head=ptr;
            return head;
        }
        ListNode ptr=null,ptr1=null,ptr2=null;
        for(ptr1=head,ptr2=head.next,ptr1.next=null;ptr2!=null;ptr2=ptr2.next,ptr1.next=ptr)
        {
            ptr=ptr1;
            ptr1=ptr2;
        }
        return ptr1;
    }
}