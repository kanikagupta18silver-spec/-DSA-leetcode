import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, dp, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int start, String s, boolean[][] dp, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(end + 1, s, dp, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}