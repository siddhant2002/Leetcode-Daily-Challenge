class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        Stack<Integer> stk = new Stack<>();

        for(char c : num.toCharArray()) {
            while(!stk.isEmpty() && k > 0 && stk.peek() > (c - '0')) {
                stk.pop();
                k--;
            }

            stk.push(c - '0');
        }

        while(k > 0 && !stk.isEmpty()) {
            k--;
            stk.pop();
        }

        if(k > 0) return "0";

        StringBuilder str = new StringBuilder("");

        while(!stk.isEmpty()) {
            str.append(stk.pop());
        }

        str.reverse();

        while (str.length() > 0 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        
        return str.length() > 0 ? str.toString() : "0";
    }
}