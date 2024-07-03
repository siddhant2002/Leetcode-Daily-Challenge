class KthLargest {
    PriorityQueue<Integer> nm;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        nm=new PriorityQueue<>();
        for(int i:nums)
        {
            add(i);
        }
    }
    
    public int add(int val) {
        if(nm.size()<k)
        {
            nm.offer(val);
        }
        else if(nm.peek()<val)
        {
            nm.poll();
            nm.offer(val);
        }
        return nm.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */