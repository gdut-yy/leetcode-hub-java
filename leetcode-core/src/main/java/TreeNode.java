import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    /**
     * 自定义断言
     *
     * @param expected 期望值
     * @param actual   实际值
     * @return true 相等
     */
    public static boolean assertTreeNodeEquals(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return true;
        } else if (expected == null || actual == null) {
            return false;
        } else if (expected.val != actual.val) {
            return false;
        } else {
            return assertTreeNodeEquals(expected.left, actual.left) && assertTreeNodeEquals(expected.right, actual.right);
        }
    }

    /**
     * 构造 TreeNode
     *
     * @param text text
     * @return TreeNode
     */
    public static TreeNode buildTreeNode(String text) {
        if (text.equals("[]")) {
            return null;
        }
        String[] texts = text.substring(1, text.length() - 1).split(",");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(texts[idx++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (idx < texts.length && !texts[idx].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(texts[idx]));
                queue.add(cur.left);
            }
            idx++;
            if (idx < texts.length && !texts[idx].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(texts[idx]));
                queue.add(cur.right);
            }
            idx++;
        }
        return root;
    }
}
