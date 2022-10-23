import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hhrc220925T3 {
    private int id;
    private Map<String, Integer> serialUidMap;
    private Map<Integer, Integer> cntMap;
    private List<TreeNode> resList;

    public List<TreeNode> lightDistribution(TreeNode root) {
        this.id = 1;
        this.serialUidMap = new HashMap<>();
        this.cntMap = new HashMap<>();
        this.resList = new ArrayList<>();

        dfs(root);
        return resList;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 序列化
        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        int uid = serialUidMap.computeIfAbsent(serial, key -> id++);
        cntMap.put(uid, cntMap.getOrDefault(uid, 0) + 1);
        if (cntMap.get(uid) == 2) {
            resList.add(root);
        }
        return uid;
    }
}
/*
题目-03. 重复的彩灯树
https://leetcode.cn/contest/hhrc2022/problems/VAc7h3/

有一棵结构为二叉树的圣诞树 root 挂满了彩灯，各节点值表示彩灯的颜色。
如果两棵子树具有 相同的结构 和 相同的彩灯颜色分布，则它们是 重复 的。
请返回这棵树上所有 重复的子树。
注意：
对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
提示：
树中的结点数在[1,6000]范围内。
-200 <= Node.val <= 200

相似题目: 652. 寻找重复的子树
https://leetcode.cn/problems/find-duplicate-subtrees/
 */