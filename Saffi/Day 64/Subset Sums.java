class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        task(n - 1, arr, ans, 0);
        
        return ans;
    }
    
    static void task(int ind, ArrayList<Integer> arr, ArrayList<Integer> ans, int sum) {
        if(ind < 0) {
            ans.add(sum);
            return;
        }
        
        task(ind - 1, arr, ans, sum + arr.get(ind));
        
        task(ind - 1, arr, ans, sum);
    }
}