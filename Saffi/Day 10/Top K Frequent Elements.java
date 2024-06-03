class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            pq.offer(m);
        }

        int ans[] = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = pq.peek().getKey();

            pq.poll();
        }

        return ans;
    }
}