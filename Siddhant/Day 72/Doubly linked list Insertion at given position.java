

/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/

class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{
	    int i=0;
	    for(Node ptr=head_ref;ptr!=null;ptr=ptr.next,i++)
	    {
	        if(i==pos)
	        {
	            Node fresh=new Node(data);
	            fresh.next=ptr.next;
	            fresh.prev=ptr;
	            ptr.next=fresh;
	            break;
	        }
	    }
	}
}