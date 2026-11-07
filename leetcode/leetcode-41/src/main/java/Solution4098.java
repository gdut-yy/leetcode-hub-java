public class Solution4098 {
    public long minimumMaxValue(int n, int index, int value) {
        int minP = minPrimeDivisor(value);
        if (value == 1 || value - minP - (index - 1) * 2 <= 0) { // nums[0] <= 0
            return -1;
        }
        if (index == n - 1) {
            return value;
        }
        return (long) value + minP + (n - 2 - index) * 2;
    }

    // 返回 value 的最小质因子
    private int minPrimeDivisor(int value) {
        for (int p = 2; p * p <= value; p++) {
            if (value % p == 0) {
                return p;
            }
        }
        return value; // value 是质数或者 1
    }
}
/*
4098. 最小化 GCD 连通数组的最大值
https://leetcode.cn/problems/minimize-the-maximum-value-of-gcd-connected-array/description/

第 526 场周赛 T2。

给你三个整数 n、index 和 value。
如果长度为 n 的整数数组 nums 满足以下条件，则称其为 GCD 连通数组：
- 对于 0 <= i <= n - 1，有 nums[i] > 0。
- 对于 0 <= i <= n - 2，有 nums[i] < nums[i + 1]。
- nums[index] = value。
- 对于 0 <= i <= n - 2，有 gcd(nums[i], nums[i + 1]) > 1。
在所有 GCD 连通数组 nums 中，返回最大元素 nums[n - 1] 可能的最小值。如果不存在这样的数组，返回 -1。
其中，gcd(a, b) 表示 a 和 b 的最大公约数。
示例 1：
输入： n = 4, index = 2, value = 8
输出： 10
示例 2：
输入： n = 2, index = 1, value = 3
输出： -1
示例 3：
输入： n = 2, index = 0, value = 3
输出： 6
提示：
2 <= n <= 10^9
1 <= value <= 10^9
0 <= index <= n - 1

贪心构造。
 */