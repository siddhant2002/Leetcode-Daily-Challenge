class Solution {
    public int passThePillow(int n, int time) {
        int ind = 1;

        boolean flag = true;

        while(time-- > 0) {
            if(flag) ind++;
            else ind--;

            if(ind == n) flag = false;
            else if(ind == 1) flag = true;
        }

        return ind;
    }
}