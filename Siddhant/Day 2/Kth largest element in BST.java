/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        int a[]=new int[3];
        task1(root,a);
        task(root,a,K,a[2]);
        return a[0];
    }
    private static void task1(Node root, int a[])
    {
        if(root==null)
        {
            return;
        }
        task1(root.left,a);
        a[2]++;
        task1(root.right,a);
    }
    private static void task(Node root, int a[], int k, int count)
    {
        if(root==null)
        {
            return;
        }
        task(root.left,a,k,count);
        a[1]+=1;
        if(a[1] == count-k+1)
        {
            a[0]=root.data;
        }
        task(root.right,a,k,count);
    }
}