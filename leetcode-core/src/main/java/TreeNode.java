import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

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
