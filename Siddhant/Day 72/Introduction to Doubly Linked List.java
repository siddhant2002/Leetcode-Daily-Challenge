

// User function Template for Java

class Solution {
    Node constructDLL(int arr[]) {
        Node start=null,prev=null,next=null;
        for(int i=0;i<arr.length;i++)
        {
            Node fresh=new Node(arr[i]);
            if(start==null)
            {
                start=fresh;
            }
            else
            {
                prev.next=fresh;
                fresh.prev=next;
            }
            prev=fresh;
            next=fresh;
        }
        return start;
    }
}