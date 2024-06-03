class KthLargest {
    static int kth;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();

        for(int i : nums) {
            pq.offer(i);
        }

        kth = k;

        while(pq.size() > kth) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > kth) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */