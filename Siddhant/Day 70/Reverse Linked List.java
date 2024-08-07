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
        ListNode ptr=null,ptr1=head,ptr2=head.next;
        head.next=null;
        return task(ptr,ptr1,ptr2);
    }
    private ListNode task(ListNode ptr, ListNode ptr1, ListNode ptr2)
    {
        if(ptr2==null)
        {
            return ptr1;
        }
        ptr=ptr1;
        ptr1=ptr2;
        ptr2=ptr2.next;
        ptr1.next=ptr;
        return task(ptr,ptr1,ptr2);
    }
}