public class Solution3790 {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int mod = 9 * k;
        int r = 1;
        for (int m = 1; m <= mod; ++m) {
            r = (r * 10) % mod;
            if (r == 1) {
                return m;
            }
        }
        return -1;
    }
}
/*
3790. 最小全 1 倍数
https://leetcode.cn/problems/smallest-all-ones-multiple/description/

第 482 场周赛 T3。

给你一个正整数 k。
找出满足以下条件的 最小 整数 n：n 能被 k 整除，且其十进制表示中 只包含数字 1（例如：1、11、111、……）。
返回一个整数，表示 n 的十进制表示的 位数 。如果不存在这样的 n，则返回 -1。
提示：
2 <= k <= 10^5

模运算。
时间复杂度 O(k)。
相似题目: 1015. 可被 K 整除的最小整数
https://leetcode.cn/problems/smallest-integer-divisible-by-k/
 */