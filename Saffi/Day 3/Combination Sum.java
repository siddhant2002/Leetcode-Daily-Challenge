class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        task(0, candidates, target, temp, ans);

        return ans;
    }

    static void task(int pos, int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans) {

        if(pos == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(temp));
            }

            return;
        }

        if(candidates[pos] <= target) {
            temp.add(candidates[pos]);

            task(pos, candidates, target - candidates[pos], temp, ans);

            temp.remove(temp.size() - 1);
        }

        task(pos + 1, candidates, target, temp, ans);
    }
}