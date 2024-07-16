/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pointer
 {
     int row,col;
     TreeNode node;
     Pointer(int col, int row, TreeNode node)
     {
         this.col=col;
         this.row=row;
         this.node=node;
     }
 }
 class Solution {
     public List<List<Integer>> verticalTraversal(TreeNode root) {
         Map<Integer, TreeMap<Integer,PriorityQueue<Integer>>> ans=new TreeMap<>();
         Queue<Pointer> nm=new LinkedList<>();
         nm.offer(new Pointer(0,0,root));
         while(!nm.isEmpty())
         {
             Pointer val=nm.poll();
             int row=val.row;
             int col=val.col;
             TreeNode node=val.node;
             if(!ans.containsKey(col))
             {
                 ans.put(col, new TreeMap<>());
             }
             if(!ans.get(col).containsKey(row))
             {
                 ans.get(col).put(row, new PriorityQueue<>());
             }
             ans.get(col).get(row).offer(node.val);
             if(node.left!=null)
             {
                 nm.offer(new Pointer(col-1,row+1,node.left));
             }
             if(node.right!=null)
             {
                 nm.offer(new Pointer(col+1,row+1,node.right));
             }
         }
         List<List<Integer>> kk=new ArrayList<>();
         for(Map<Integer,PriorityQueue<Integer>> val: ans.values())
         {
             kk.add(new ArrayList<>());
             for(int key:val.keySet())
             {
                 while(!val.get(key).isEmpty())
                 {
                     kk.get(kk.size()-1).add(val.get(key).poll());
                 }
             }
         }
         return kk;
     }
 }