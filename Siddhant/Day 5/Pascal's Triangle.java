class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> nm=new ArrayList<>();
        List<Integer> prev=new ArrayList<>();
        prev.add(1);
        if(n==1)
        {
            nm.add(new ArrayList<>(prev));
            return nm;
        }
        nm.add(new ArrayList<>(prev));
        prev.clear();
        prev.add(1);
        prev.add(1);
        if(n==2)
        {
            nm.add(new ArrayList<>(prev));
            return nm;
        }
        nm.add(new ArrayList<>(prev));
        for(int i=3;i<=n;i++)
        {
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=0;j<prev.size()-1;j++)
            {
                cur.add(prev.get(j)+prev.get(j+1));
            }
            cur.add(1);
            nm.add(new ArrayList<>(cur));
            prev=cur;
        }
        return nm;
    }
}