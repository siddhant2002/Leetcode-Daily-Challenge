class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> nm=new HashMap<>();
        for(int i: nums)
        {
            nm.put(i, nm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> kk=new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer,Integer> map: nm.entrySet())
        {
            kk.offer(map);
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++)
        {
            Map.Entry<Integer,Integer> map=kk.poll();
            ans[i]=map.getKey();
        }
        return ans;
    }
}