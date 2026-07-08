public class Solution3954 {
    public int sumOfGoodIntegers(int n, int k) {
        // -k <= n-x <= k
        // x <= n+k
        // n-k <= x
        int ans = 0;
        for (int x = n - k; x <= n + k; x++) {
            if (x < 0) continue;
            if ((n & x) == 0) ans += x;
        }
        return ans;
    }
}
/*
3954. 区间内的兼容数字之和 I
https://leetcode.cn/problems/sum-of-compatible-numbers-in-range-i/description/

第 505 场周赛 T1。

给你两个整数 n 和 k。
如果一个 正 整数 x 同时满足以下两个条件，则称其为 兼容 整数：
- abs(n - x) <= k
- (n & x) == 0
返回所有 兼容 整数 x 的总和。
注意：
- 这里，& 表示 按位与 运算符。
- 整数 i 和 j 之间的 绝对 差定义为 abs(i - j)。
提示：
1 <= n <= 100
1 <= k <= 100

暴力枚举。
时间复杂度 O(k)。
 */