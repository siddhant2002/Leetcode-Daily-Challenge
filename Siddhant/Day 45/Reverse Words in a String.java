class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder nm=new StringBuilder();
        StringBuilder kk=new StringBuilder();
        for(int i=s.length()-1; i>=0; i--)
        {
            char c=s.charAt(i);
            if(c==' ' && kk.length()>0)
            {
                nm.append(kk);
                nm.append(" ");
                kk.setLength(0);
            }
            else if(c!=' ')
            {
                kk.insert(0,c);
            }
        }
        nm.append(kk);
        return nm.toString();
    }
}