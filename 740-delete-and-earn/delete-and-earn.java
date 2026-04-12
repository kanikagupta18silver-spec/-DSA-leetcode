import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> d = new HashMap<>();
        
        for (int num : nums) {
            d.put(num, d.getOrDefault(num, 0) + 1);
        }

        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }

        int[] houses = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            houses[i] = i * d.getOrDefault(i, 0);
        }

        int[] dp = new int[n + 1];
        dp[0] = houses[0];
        if (n >= 1) {
            dp[1] = Math.max(houses[0], houses[1]);
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], houses[i] + dp[i - 2]);
        }

        return dp[n];
    }
}