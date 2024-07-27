/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        int a[]=new int[1];
        a[0]=-3;
        task(root,a);
        return a[0];
    }
    private void task(Node root, int a[])
    {
        if(root==null)
        {
            if(a[0]==-3)
            {
                a[0]=-1;
            }
            return;
        }
        a[0]=root.data;
        task(root.left,a);
    }
}
