class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i : map.keySet()) {
            pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int n = pq.peek();

            for(int i = 0; i < groupSize; i++) {
                if(!map.containsKey(n + i)) {
                    return false;
                }
                else {
                    map.put(n + i, map.get(n + i) - 1);

                    if(map.get(n + i) == 0) {
                        map.remove(n + i);
                        pq.remove(n + i);
                    }
                }
            }
        }

        return true;

    }
}