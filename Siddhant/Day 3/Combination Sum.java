class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        task(ans,new ArrayList<>(),0,target,candidates);
        return ans;
    }
    private void task(List<List<Integer>> ans, List<Integer> nm, int ind, int target, int arr[])
    {
        if(ind==arr.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(nm));
            }
            return;
        }
        if(arr[ind]<=target)
        {
            nm.add(arr[ind]);
            task(ans,nm,ind,target-arr[ind],arr);
            nm.remove(nm.size()-1);
        }
        task(ans,nm,ind+1,target,arr);
    }
}