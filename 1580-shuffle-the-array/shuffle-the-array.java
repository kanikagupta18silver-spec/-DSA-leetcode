import java.util.*;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        ArrayList<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(nums[i]);
            s.add(nums[i + n]);
        }

        int[] result = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            result[i] = s.get(i);
        }

        return result;
    }
}