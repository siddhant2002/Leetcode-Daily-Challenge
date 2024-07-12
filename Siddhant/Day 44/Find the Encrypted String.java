class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder nm=new StringBuilder();
        int len=s.length();
        k=k%len;
        for(int i=0;i<len;i++)
        {
            char d=s.charAt((i+k)%len);
            nm.append(d);
        }
        return nm.toString();
    }
}