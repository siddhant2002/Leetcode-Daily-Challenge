/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    if(head.next==null)
    {
        return head;
    }
    if(head.next.next==null)
    {
        Node val=head.next;
        val.prev=null;
        val.next=head;
        head.prev=val;
        head.next=null;
        return val;
    }
    Node ptr=head;
    while(ptr!=null)
    {
        Node val=ptr.prev;
        ptr.prev=ptr.next;
        ptr.next=val;
        if(ptr.prev==null)
        {
            head=ptr;
        }
        ptr=ptr.prev;
    }
    return head;
}