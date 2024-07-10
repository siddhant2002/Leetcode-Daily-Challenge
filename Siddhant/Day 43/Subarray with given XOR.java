public class Solution {
    public int solve(int[] A, int B) {
        Map<Integer,Integer> nm=new HashMap<>();
        nm.put(0,1);
        int ans=0,val=0;
        for(int i=0;i<A.length;i++)
        {
            val^=A[i];
            if(nm.containsKey(val^B))
            {
                ans+=nm.get(val^B);
            }
            nm.put(val^B, nm.getOrDefault(val^B,0)+1);
        }
        return ans;
    }
}