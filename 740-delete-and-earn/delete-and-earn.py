class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        d = collections.Counter(nums)
        n = max(nums)
        houses = [0]*(n+1)

        for i in range(n+1):
            houses[i] = i*d[i]

        dp = [0]*(n+1)
        dp[0], dp[1] = houses[0], max(houses[0], houses[1])

        for i in range(2, n+1):
            dp[i] = max(dp[i-1], houses[i] + dp[i-2])

        return dp[-1]