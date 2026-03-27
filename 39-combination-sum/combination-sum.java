import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    public void solve(int i, int[] arr, int target, List<Integer> temp, List<List<Integer>> res) {
        if (i == arr.length) {
            if (target == 0) res.add(new ArrayList<>(temp));
            return;
        }

        if (arr[i] <= target) {
            temp.add(arr[i]);
            solve(i, arr, target - arr[i], temp, res);
            temp.remove(temp.size() - 1);
        }

        solve(i + 1, arr, target, temp, res);
    }
}