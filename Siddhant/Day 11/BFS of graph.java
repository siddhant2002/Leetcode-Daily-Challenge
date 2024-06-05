class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> nm=new ArrayList<>();
        Queue<Integer> kk=new LinkedList<>();
        boolean vis[]=new boolean[V];
        kk.offer(0);
        vis[0]=true;
        while(!kk.isEmpty())
        {
            int size=kk.size();
            for(int i=1;i<=size;i++)
            {
                int val=kk.poll();
                //System.out.println(val);
                for(int j:adj.get(val))
                {
                    if(!vis[j])
                    {
                        kk.offer(j);
                        vis[j]=true;
                    }
                }
                nm.add(val);
            }
        }
        return nm;
    }
}