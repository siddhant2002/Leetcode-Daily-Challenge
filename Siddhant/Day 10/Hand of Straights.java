class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len=hand.length;
        if(len%groupSize != 0)
        {
            return false;
        }
        Map<Integer,Integer> nm=new TreeMap<>();
        for(int i:hand)
        {
            nm.put(i, nm.getOrDefault(i,0)+1);
        }
        for(int i:nm.keySet())
        {
            int freq=nm.get(i);
            if(freq==0)
            {
                continue;
            }
            while(freq>0)
            {
                for(int ind=i; ind<i+groupSize; ind++)
                {
                    if(!nm.containsKey(ind) || (nm.containsKey(ind) && nm.get(ind)==0))
                    {
                        return false;
                    }
                    nm.put(ind, nm.get(ind)-1);
                }
                freq=nm.get(i);
            }
        }
        return true;
    }
}