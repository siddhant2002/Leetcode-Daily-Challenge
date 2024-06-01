class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int stack[] = new int[asteroids.length];

        int pos = -1;

        for(int i = 0; i < asteroids.length; i++) {
            if(pos == -1) {
                stack[++pos] = asteroids[i];
            }
            else {
                if(asteroids[i] >= 0) {
                    stack[++pos] = asteroids[i];
                }
                else {
                    if(stack[pos] < 0) {
                        stack[++pos] = asteroids[i];
                    }
                    else {
                        while(pos >= 0 && stack[pos] > 0 && stack[pos] < Math.abs(asteroids[i])) {
                            pos--;
                        }

                        if(pos >= 0) {
                            if(stack[pos] > 0 && stack[pos] == Math.abs(asteroids[i])) {
                                pos--;
                            }
                            else if(stack[pos] < 0) {
                                stack[++pos] = asteroids[i];
                            }
                        }
                        else {
                            stack[++pos] = asteroids[i];
                        }
                    }
                }
            }
        }
        int ans[] = new int[pos + 1];

        for (int i = 0; i <= pos; i++) {
            ans[i] = stack[i];
        }

        return ans;
    }
}