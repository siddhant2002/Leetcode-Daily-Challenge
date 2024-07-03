class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> nm=new Stack<>();
        for(char c:num.toCharArray())
        {
            while(!nm.isEmpty() && nm.peek()>c && k>0)
            {
                nm.pop();
                k--;
            }
            if(nm.isEmpty())
            {
                if(c!='0')
                {
                    nm.push(c);
                }
            }
            else
            {
                nm.push(c);
            }
        }
        while(k>0 && !nm.isEmpty())
        {
            nm.pop();
            k--;
        }
        StringBuilder str=new StringBuilder();
        while(!nm.isEmpty())
        {
            str.insert(0,nm.pop());
        }
        return str.length() == 0 ? "0" : str.toString();
    }
}