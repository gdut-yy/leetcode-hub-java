public class Solution297 {
    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }
            String leftStr = serialize(root.left);
            String rightStr = serialize(root.right);
            return root.val + "," + leftStr + "," + rightStr;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodeStrs = data.split(",");
            int[] i = {0};
            return preorder(nodeStrs, i);
        }

        private TreeNode preorder(String[] strs, int[] i) {
            String str = strs[i[0]];
            i[0]++;
            if (str.equals("null")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = preorder(strs, i);
            node.right = preorder(strs, i);
            return node;
        }
    }
}
/*
297. 二叉树的序列化与反序列化
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

前序遍历
 */