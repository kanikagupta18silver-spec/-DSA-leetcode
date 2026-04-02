class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        int[] count = new int[128];
        for (char[] row : board) {
            for (char c : row) count[c]++;
        }
        for (char c : word.toCharArray()) {
            if (--count[c] < 0) return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, word, i + 1, j, k + 1) ||
                        dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1) ||
                        dfs(board, word, i, j - 1, k + 1);

        board[i][j] = temp;
        return found;
    }
}