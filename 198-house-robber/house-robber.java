class Solution {

    public static int Solve(int i, int[] nums, int[] dp)
    {
        if(i >= nums.length)
        {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + Solve(i+2, nums, dp);
        int notTake = Solve(i+1, nums, dp);

        return dp[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            dp[i] = -1;
        }

        return Solve(0, nums, dp);
    }
}