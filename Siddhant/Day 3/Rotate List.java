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
        if(head==null)
        {
            return head;
        }
        int c=count(head);
        k=k%c;
        for(ListNode ptr=head;ptr!=null;ptr=ptr.next)
        {
            if(ptr.next==null)
            {
                ptr.next=head;
                break;
            }
        }
        int pos=c-k,ind=1;
        for(ListNode ptr=head;ptr!=null;ptr=ptr.next,ind++)
        {
            if(ind==pos)
            {
                head=ptr.next;
                ptr.next=null;
            }
        }
        return head;
    }
    private int count(ListNode head)
    {
        int count=0;
        for(ListNode ptr=head;ptr!=null;ptr=ptr.next)
        {
            count++;
        }
        return count;
    }
}