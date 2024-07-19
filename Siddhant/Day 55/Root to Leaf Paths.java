class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        task(ans,new ArrayList<>(),root);
        return ans;
    }
    private static void task(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, Node root)
    {
        if(root==null)
        {
            return;
        }
        temp.add(root.data);
        if(root.left==null && root.right==null)
        {
            ans.add(new ArrayList<>(temp));
        }
        task(ans,temp,root.left);
        task(ans,temp,root.right);
        temp.remove(temp.size()-1);
    }
}