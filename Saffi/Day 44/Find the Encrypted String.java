class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder str = new StringBuilder("");

        int n = s.length();

        for(int i = 0; i < n; i++) {
            str.append(s.charAt((i + k) % n));
        }

        return str.toString();
    }
}