import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, nums, res);
        return res;
    }

    private void solve(int idx, int[] nums, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            res.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            solve(idx + 1, nums, res);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}   