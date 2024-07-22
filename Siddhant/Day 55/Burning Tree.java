class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int k) 
    {
        Map<Node,Node> map=new HashMap<>();
        Queue<Node> nm=new LinkedList<>();
        parent_track(map,root);
        Node target[]=new Node[1];
        task(root,k,target);
        Map<Node,Boolean> vis=new HashMap<>();
        nm.offer(target[0]);
        vis.put(target[0],true);
        int cur_level=0;
        while(!nm.isEmpty())
        {
            cur_level++;
            int size=nm.size();
            for(int i=1;i<=size;i++)
            {
                Node val=nm.poll();
                if(val.left!=null && vis.get(val.left)==null)
                {
                    nm.offer(val.left);
                    vis.put(val.left,true);
                }
                if(val.right!=null && vis.get(val.right)==null)
                {
                    nm.offer(val.right);
                    vis.put(val.right,true);
                }
                if(map.get(val)!=null && vis.get(map.get(val))==null)
                {
                    nm.offer(map.get(val));
                    vis.put(map.get(val),true);
                }
            }
        }
        return cur_level-1;
    }
    private static void parent_track(Map<Node,Node> map, Node root)
    {
        Queue<Node> nm=new LinkedList<>();
        nm.offer(root);
        while(!nm.isEmpty())
        {
            int size=nm.size();
            for(int i=1;i<=size;i++)
            {
                Node val=nm.poll();
                if(val.left!=null)
                {
                    map.put(val.left,val);
                    nm.offer(val.left);
                }
                if(val.right!=null)
                {
                    map.put(val.right,val);
                    nm.offer(val.right);
                }
            }
        }
    }
    private static void task(Node root, int k, Node arr[])
    {
        if(root==null)
        {
            return;
        }
        if(root.data==k)
        {
            arr[0]=root;
            return;
        }
        task(root.left,k,arr);
        task(root.right,k,arr);
    }
}