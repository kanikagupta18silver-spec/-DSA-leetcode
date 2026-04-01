class Solution {
    public static int Solve(int[] arr, int sum, int i) {
        if (i == arr.length) {
            if (sum == 0) return 1;
            return 0;
        }

        int take = 0;
        if (sum >= arr[i]) {
            take = Solve(arr, sum - arr[i], i + 1);
        }

        int notTake = Solve(arr, sum, i + 1);

        return take + notTake;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int TotalSum = 0;
        for (int num : nums) {
            TotalSum += num;
        }

        if ((TotalSum + target) % 2 != 0 || TotalSum < Math.abs(target)) return 0;

        int sum = (TotalSum + target) / 2;

        return Solve(nums, sum, 0);
    }
}