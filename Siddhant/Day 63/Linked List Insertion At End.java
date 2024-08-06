/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        if(head==null)
        {
            Node ne=new Node(x);
            return ne;
        }
        Node ptr=head;
        while(ptr.next!=null)
        {
            ptr=ptr.next;
        }
        ptr.next=new Node(x);
        return head;
    }
}