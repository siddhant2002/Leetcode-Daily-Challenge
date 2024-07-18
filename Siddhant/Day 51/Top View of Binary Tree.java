class Pair
{
    int val;
    Node node;
    Pair(Node node, int val)
    {
        this.node=node;
        this.val=val;
    }
}
class Solution {
    static ArrayList<Integer> topView(Node root) {
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> nm=new LinkedList<>();
        nm.offer(new Pair(root,0));
        while(!nm.isEmpty())
        {
            Pair data1=nm.poll();
            int val=data1.val;
            if(data1.node.left!=null)
            {
                nm.offer(new Pair(data1.node.left,val-1));
            }
            if(data1.node.right!=null)
            {
                nm.offer(new Pair(data1.node.right,val+1));
            }
            if(!map.containsKey(val))
            {
                map.put(val,data1.node.data);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i: map.keySet())
        {
            ans.add(map.get(i));
        }
        return ans;
    }
}