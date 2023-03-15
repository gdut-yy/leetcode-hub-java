import java.util.ArrayList;
import java.util.List;

public class SolutionLCP60 {
    // 前缀和，占用，左下指针，右下指针
    private List<List<int[]>> level_infs;
    private List<int[]> remove_list;

    // https://leetcode.cn/problems/WInSav/solution/by-newhar-7hps/
    public int getMaxLayerSum(TreeNode root) {
        level_infs = new ArrayList<>();
        remove_list = new ArrayList<>();
        collect(0, root);

        int height = level_infs.size() - 1;
        int res = Integer.MIN_VALUE;
        for (int level = 0; level < height; level++) {
            List<int[]> levelList = level_infs.get(level);
            res = Math.max(res, levelList.get(levelList.size() - 1)[0]);
        }

        for (int idx = 0; idx < remove_list.size(); idx++) {
            int[] tuple = remove_list.get(idx);
            int node = tuple[0];
            int start = tuple[1];

            int left = node, right = node;
            int lost = level_infs.get(start).get(left)[0] - level_infs.get(start).get(left - 1)[0];
            for (int level = start; level < height; level++) {
                if (left > right) {
                    break;
                }
                List<int[]> levelList = level_infs.get(level);

                // 如果当前 "管辖区间" 为整层的节点，那么没有必要继续遍历下去，它相当于删除该层
                // 另外，这个优化还能避坑 "如果最后一层全删掉，那么这个和为 0 是没有意义的"
                if (right - left + 1 == levelList.size() - 1) {
                    break;
                }

                int[] tupleL = levelList.get(left);
                int[] tupleR = levelList.get(right);
                int lsum = tupleL[0], luse = tupleL[1], ne_left = tupleL[2], _unused1 = tupleL[3];
                int rsum = tupleR[0], ruse = tupleR[1], _unused2 = tupleR[2], ne_right = tupleR[3];

                //  剪枝：如果当前区间已经被使用过，则跳过后续部分
                if (luse != -1 && luse == ruse) {
                    break;
                }
                tupleL[1] = tupleR[1] = idx;

                int add = 0;
                if (ne_left <= ne_right) {
                    add = level_infs.get(level + 1).get(ne_right)[0] - level_infs.get(level + 1).get(ne_left - 1)[0];
                }
                res = Math.max(res, levelList.get(levelList.size() - 1)[0] - lost + add);

                left = ne_left;
                right = ne_right;
                lost = add;
            }
        }
        return res;
    }

    private int collect(int level, TreeNode node) {
        if (node == null) {
            return 0;
        }
        while (level + 1 >= level_infs.size()) {
            level_infs.add(new ArrayList<>(List.of(new int[]{0, -1, -1, -1})));
        }
        List<int[]> levelList = level_infs.get(level);
        levelList.add(new int[]{
                levelList.get(levelList.size() - 1)[0] + node.val, // 前缀和
                -1, // 被占用的情况
                level_infs.get(level + 1).size(), // 左侧向下指针
                -1 // 右侧向下指针(需要等遍历完之后再补充)
        });
        node.val = levelList.size() - 1;
        if (collect(level + 1, node.left) + collect(level + 1, node.right) != 2) {
            remove_list.add(new int[]{levelList.size() - 1, level});
        }
        levelList.get(levelList.size() - 1)[3] = level_infs.get(level + 1).size() - 1;
        return 1;
    }
}
/*
LCP 60. 力扣泡泡龙
https://leetcode.cn/problems/WInSav/

LCCUP 力扣杯 2022 春季编程大赛战队赛 T6。

欢迎各位勇者来到力扣城，本次试炼主题为「力扣泡泡龙」。
游戏初始状态的泡泡形如二叉树 root，每个节点值对应了该泡泡的分值。勇者最多可以击破一个节点泡泡，要求满足：
- 被击破的节点泡泡 至多 只有一个子节点泡泡
- 当被击破的节点泡泡有子节点泡泡时，则子节点泡泡将取代被击破泡泡的位置
  > 注：即整棵子树泡泡上移
请问在击破一个节点泡泡操作或无击破操作后，二叉泡泡树的最大「层和」是多少。
注意：
- 「层和」为同一高度的所有节点的分值之和
提示：
2 <= 树中节点个数 <= 10^5
-10000 <= 树中节点的值 <= 10000

这道题的真正解决方法，应当是 启发式合并 O(nlogn)，或者 树链剖分 (O(n))，
 */