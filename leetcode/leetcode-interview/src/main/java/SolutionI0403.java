import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionI0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<List<Integer>> resList = new ArrayList<>();
        if (tree == null) {
            return new ListNode[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                curLevel.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            resList.add(curLevel);
        }
        // List<Integer> => ListNode
        int resLen = resList.size();
        ListNode[] res = new ListNode[resLen];
        for (int i = 0; i < resLen; i++) {
            res[i] = buildListNode(resList.get(i));
        }
        return res;
    }

    private ListNode buildListNode(List<Integer> nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}
/*
面试题 04.03. 特定深度节点链表
https://leetcode.cn/problems/list-of-depth-lcci/

给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
返回一个包含所有深度的链表的数组。
示例：
输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]

二叉树层次遍历。
相似题目: 102. 二叉树的层序遍历
https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */