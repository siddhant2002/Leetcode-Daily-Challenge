// User function Template for Java

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        int a[]=new int[1];
        task(root,key,a);
        return a[0]==0 ? -1 : a[0];
    }
    private void task(Node root, int key, int a[])
    {
        if(root==null)
        {
            return;
        }
        if(root.data < key)
        {
            task(root.right,key,a);
        }
        else
        {
            a[0]=root.data;
            task(root.left,key,a);
        }
    }
}
