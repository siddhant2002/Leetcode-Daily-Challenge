public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> nm=new Stack<>();
        int ans[]=new int[A.length];
        nm.push(A[0]);
        ans[0]=-1;
        for(int i=1;i<A.length;i++)
        {
            while(!nm.isEmpty() && A[i]<=nm.peek())
            {
                nm.pop();
            }
            ans[i]=nm.isEmpty() ? -1 : nm.peek();
            nm.push(A[i]);
        }
        return ans;
    }
}