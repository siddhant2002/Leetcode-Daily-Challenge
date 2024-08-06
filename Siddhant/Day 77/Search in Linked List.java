// User function Template for Java

/* Node of a linked list
  class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        for(Node ptr=head;ptr!=null;ptr=ptr.next)
        {
            if(ptr.data==key)
            {
                return true;
            }
        }
        return false;
    }
}