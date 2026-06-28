/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class NodeInfo {
        TreeNode node;
        int row, col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<NodeInfo> q = new LinkedList<>();

        q.offer(new NodeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo cur = q.poll();

            map.computeIfAbsent(cur.col, k -> new ArrayList<>())
               .add(new int[]{cur.row, cur.node.val});

            if (cur.node.left != null) {
                q.offer(new NodeInfo(cur.node.left, cur.row + 1, cur.col - 1));
            }

            if (cur.node.right != null) {
                q.offer(new NodeInfo(cur.node.right, cur.row + 1, cur.col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            list.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> col = new ArrayList<>();
            for (int[] p : list) {
                col.add(p[1]);
            }
            ans.add(col);
        }

        return ans;
    }
}