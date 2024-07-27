class Solution {
    public static int floor(Node root, int x) {
        int a[]=new int[1];
        task(root,x,a);
        return a[0]==0 ? -1 : a[0];
    }
    private static void task(Node root, int key, int a[])
    {
        if(root==null)
        {
            return;
        }
        if(root.data <= key)
        {
            a[0]=root.data;
            task(root.right,key,a);
        }
        else
        {
            task(root.left,key,a);
        }
    }
}