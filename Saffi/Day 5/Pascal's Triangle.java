class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<Integer>());

        ans.get(0).add(1);

        for(int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();

            List<Integer> t = ans.get(ans.size() - 1);

            temp.add(1);

            for(int j = 0; j < t.size() - 1; j++) {
                temp.add(t.get(j) + t.get(j + 1));
            }

            temp.add(1);

            ans.add(temp);
        }
        return ans;
    }
}