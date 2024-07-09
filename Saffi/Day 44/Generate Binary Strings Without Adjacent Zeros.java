class Solution {
    public List<String> validStrings(int n) {
        Set<String> ans = new HashSet<>();

        task(n, ans, "", true);

        List<String> list = new ArrayList<>();

        for(String it : ans) {
            list.add(it);
        }

        return list;
    }

    static void task(int n, Set<String> ans, String s, boolean flag) {
        if(n == 0) {

            ans.add(s);
            return;
        }

        if(flag) {
            task(n - 1, ans, s + "0", false);
        }

        task(n - 1, ans, s + "1", true);
        task(n - 1, ans, s + "1", false);

    }
}