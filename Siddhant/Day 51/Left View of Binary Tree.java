class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        task(root,0,ans);
        return ans;
    }
    private void task(Node root, int level, ArrayList<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        if(level==ans.size())
        {
            ans.add(root.data);
        }
        task(root.left,level+1,ans);
        task(root.right,level+1,ans);
    }
}