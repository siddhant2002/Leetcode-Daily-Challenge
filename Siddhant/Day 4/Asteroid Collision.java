class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> nm=new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            int c=asteroids[i];
            int size=nm.size();
            while(!nm.isEmpty() && nm.peek()>0 && Math.abs(c)>nm.peek() && c<0)
            {
                nm.pop();
            }
            if(!nm.isEmpty() && nm.peek()==Math.abs(c) && c<0)
            {
                nm.pop();
                continue;
            }
            if(nm.isEmpty() || ((nm.peek()<0 && c<0) || (nm.peek()>0 && c>0)) || !(c<nm.peek() && c<0))
            {
                nm.push(c);
            }
        }
        int ans[]=new int[nm.size()];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i]=nm.pop();
        }
        return ans;
    }
}