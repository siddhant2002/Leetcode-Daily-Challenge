class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        s = " " + s;

        StringBuilder str = new StringBuilder("");

        int start = s.length(), end = s.length();

        for(int i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);

            if(c == ' ' && s.charAt(i + 1) == ' ') {
                end--;
                start--;
                continue;
            }

            if(c == ' ') {
                str.append(s.substring(start, end));

                if(i != 0)
                    str.append(" ");

                end = i;
                start = i;
            }
            else {
                start--;
            }
        }

        return str.toString();
        
    }
}