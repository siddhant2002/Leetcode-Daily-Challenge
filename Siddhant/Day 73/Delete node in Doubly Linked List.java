

/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if(x==1)
        {
            head=head.next;
            head.prev=null;
            return head;
        }
        int i=1;
        for(Node ptr=head;ptr!=null;ptr=ptr.next,i++)
        {
            if(i==x-1)
            {
                ptr.next.prev=ptr;
                ptr.next=ptr.next.next;
                return head;
            }
        }
        return head;
    }
}