import java.util.HashMap;
import java.util.Map;

public class SolutionP666 {
    int ans = 0;
    Map<Integer, Integer> values;

    public int pathSum(int[] nums) {
        values = new HashMap<>();
        for (int num : nums) {
            values.put(num / 10, num % 10);
        }
        dfs(nums[0] / 10, 0);
        return ans;
    }

    public void dfs(int node, int sum) {
        if (!values.containsKey(node)) return;
        sum += values.get(node);
        int depth = node / 10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        if (!values.containsKey(left) && !values.containsKey(right)) {
            ans += sum;
        } else {
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}
/*
$666. 路径总和 IV
https://leetcode.cn/problems/path-sum-iv/description/

对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。给定一个由三位数组成的 递增 的数组 nums 表示一棵深度小于 5 的二叉树，对于每个整数：
- 百位上的数字表示这个节点的深度 d，1 <= d <= 4。
- 十位上的数字表示这个节点在当前层所在的位置 p， 1 <= p <= 8。位置编号与一棵 满二叉树 的位置编号相同。
- 个位上的数字表示这个节点的权值 v，0 <= v <= 9。
返回从 根 到所有 叶子结点 的 路径 之 和。
保证 给定的数组表示一个有效的连接二叉树。
示例 1：
输入: nums = [113, 215, 221]
输出: 12
解释: 列表所表示的树如上所示。
路径和 = (3 + 5) + (3 + 1) = 12。
示例 2：
输入: nums = [113, 221]
输出: 4
解释: 列表所表示的树如上所示。
路径和 = (3 + 1) = 4。
提示:
1 <= nums.length <= 15
110 <= nums[i] <= 489
nums 表示深度小于 5 的有效二叉树
nums 以升序排序。
 */