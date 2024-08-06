

// User function Template for Java

/*
class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
*/
class Solution {
    static Node constructLL(int arr[]) {
        Node start=null,prev=null,fresh;
        for(int i=0;i<arr.length;i++)
        {
            fresh=new Node(arr[i]);
            if(start==null)
            {
                start=fresh;
            }
            else
            {
                prev.next=fresh;
            }
            prev=fresh;
        }
        return start;
    }
}