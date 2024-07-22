/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> nm=new LinkedList<>();
        parent_track(map,root);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        nm.offer(target);
        vis.put(target,true);
        int cur_level=0;
        while(!nm.isEmpty())
        {
            if(cur_level==k)
            {
                break;
            }
            cur_level++;
            int size=nm.size();
            for(int i=1;i<=size;i++)
            {
                TreeNode val=nm.poll();
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
        List<Integer> ans=new ArrayList<>();
        while(!nm.isEmpty())
        {
            ans.add(nm.poll().val);
            System.out.println(ans);
        }
        return ans;
    }
    private void parent_track(Map<TreeNode,TreeNode> map, TreeNode root)
    {
        Queue<TreeNode> nm=new LinkedList<>();
        nm.offer(root);
        while(!nm.isEmpty())
        {
            int size=nm.size();
            for(int i=1;i<=size;i++)
            {
                TreeNode val=nm.poll();
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
}