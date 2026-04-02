import java.util.*;

class Solution {
    public static void Solve(int i , int[] nums ,  List<List<Integer>> ans , List<Integer> curr)
    {
        ans.add(new ArrayList<>(curr));

        for(int j = i; j < nums.length; j++)
        {
            if(j > i && nums[j] == nums[j-1]) continue;

            curr.add(nums[j]);
            Solve(j+1, nums, ans, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        Solve(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }
}