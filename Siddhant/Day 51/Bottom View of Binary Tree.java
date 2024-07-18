class Pair
{
    Node node;
    int val;
    Pair(Node node, int val)
    {
        this.node=node;
        this.val=val;
    }
}
class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> nm=new LinkedList<>();
        nm.offer(new Pair(root,0));
        while(!nm.isEmpty())
        {
            Pair data=nm.poll();
            int val=data.val;
            Node node=data.node;
            if(node.left!=null)
            {
                nm.offer(new Pair(node.left,val-1));
            }
            if(node.right!=null)
            {
                nm.offer(new Pair(node.right,val+1));
            }
            map.put(val,node.data);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i:map.keySet())
        {
            ans.add(map.get(i));
        }
        return ans;
    }
}