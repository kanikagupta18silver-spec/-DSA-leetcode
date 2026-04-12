class Solution:
    def maxSlidingWindow(self, nums, k):
        i = 0
        j = 0
        count = 0
        curMax = -99999
        n = len(nums)
        
        if n == 1 or k == 1:
            return nums
        
        ans = [0] * (n - k + 1)
        from collections import defaultdict
        import bisect
        
        map = defaultdict(int)
        sorted_keys = []
        
        while j < n:
            map[nums[j]] += 1
            if map[nums[j]] == 1:
                bisect.insort(sorted_keys, nums[j])
            
            if j - i + 1 > k:
                map[nums[i]] -= 1
                if map[nums[i]] == 0:
                    idx = bisect.bisect_left(sorted_keys, nums[i])
                    sorted_keys.pop(idx)
                i += 1
            
            if j - i + 1 == k:
                ans[count] = sorted_keys[-1]
                count += 1
            
            j += 1
        
        return ans