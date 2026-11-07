public class Solution4062 {
    public boolean canTransform(int[] source, int[] target) {
        long sumSource = 0;
        long sumTarget = 0;
        for (int v : source) sumSource += v;
        for (int v : target) sumTarget += v;
        return sumSource == sumTarget;
    }
}
/*
4062. 成对操作转化数组
https://leetcode.cn/problems/transform-array-using-pair-operations/description/

第 192 场双周赛 T2。

给你两个整数数组 source 和 target。
在一次 操作 中，你可以选择 source 中两个 不同 的下标 i 和 j，以及任何整数 delta。然后按如下方式更新 source：
- source[i] = source[i] + source[j] - delta
- source[j] = delta
如果在执行该操作 任意 次（包括零次）后能够使 source 等于 target，则返回 true。否则，返回 false。
示例 1：
输入： source = [1,2,3], target = [0,2,4]
输出： true
示例 2：
输入： source = [-5,-5], target = [-15,5]
输出： true
示例 3：
输入： source = [1,2,1], target = [0,2,5]
输出： false
提示：
2 <= source.length == target.length <= 10^5
-10^9 <= source[i], target[i] <= 10^9

不变量。
时间复杂度 O(n)。
 */