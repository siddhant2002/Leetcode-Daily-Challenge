class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> nm=new ArrayList<>();
        boolean vis[]=new boolean[v];
        task(adj,vis,0,nm);
        return nm;
    }
    private void task(ArrayList<ArrayList<Integer>> adj, boolean vis[], int ind, ArrayList<Integer> nm)
    {
        if(vis[ind])
        {
            return;
        }
        vis[ind]=true;
        nm.add(ind);
        for(int i: adj.get(ind))
        {
            if(!vis[i])
            {
                task(adj,vis,i,nm);
            }
        }
    }
}