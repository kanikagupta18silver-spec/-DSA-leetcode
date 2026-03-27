class Solution {

    public static void Solve(int i , int[] arr , int target , List<List<Integer>> ans , List<Integer> curr)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(curr)) ;
            return ;
        }
        if(i == arr.length)
        {
            // ans.add(new ArrayList<>(curr)) ;
            return ;
        }
        if(target >= arr[i])
        {
            curr.add(arr[i]) ;
            Solve(i,arr,target-arr[i],ans,curr) ;
            curr.remove(curr.size()-1) ;
        }
      

        Solve(i+1,arr,target,ans,curr) ;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList() ;
        Solve(0,candidates,target,ans,new ArrayList<Integer>()) ;
        return ans ;
    }
}