class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 2; i <= (int)Math.sqrt(N); i++) {
            if(N % i == 0) {
                ans.add(i);
                while(N % i == 0) {
                    N /= i;
                }
            }
        }
        
        if(N != 1) ans.add(N);
        
        int res[] = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        
        Arrays.sort(res);
        
        return res;
    }
}