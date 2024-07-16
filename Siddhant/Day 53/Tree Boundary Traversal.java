class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    if(node==null)
	    {
	        return ans;
	    }
	    if(isLeaf(node))
	    {
	        ans.add(node.data);
	        return ans;
	    }
	    ans.add(node.data);
	    task(node,ans);
	    task2(node,ans);
	    task1(node,ans);
	    return ans;
	}
	private void task(Node node, ArrayList<Integer> ans)
	{
	    Node root=node.left;
	    while(root!=null)
	    {
	        if(!isLeaf(root))
	        {
	            ans.add(root.data);
	        }
	        root= root.left!=null ? root.left : root.right;
	    }
	}
	private void task1(Node node, ArrayList<Integer> ans)
	{
	    Node root=node.right;
	    int size=ans.size()-1;
	    Stack<Integer> nm=new Stack<>();
	    while(root!=null)
	    {
	        if(!isLeaf(root))
	        {
	           // ans.add(size,root.data);
	           nm.add(root.data);
	        }
	        root= root.right!=null ? root.right : root.left;
	    }
	    while(!nm.isEmpty())
	    {
	        ans.add(nm.pop());
	    }
	}
	private void task2(Node node, ArrayList<Integer> ans)
	{
	    Node root=node;
	    if(root==null)
	    {
	        return;
	    }
	    if(isLeaf(root))
        {
            ans.add(root.data);
            return;
        }
        task2(root.left,ans);
        task2(root.right,ans);
	}
	private boolean isLeaf(Node node)
	{
	    if(node==null)
	    {
	        return false;
	    }
	    return node.left==null && node.right==null;
	}
}