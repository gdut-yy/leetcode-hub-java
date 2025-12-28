public class Solution3783 {
    public int mirrorDistance(int n) {
        String rev = new StringBuilder(String.valueOf(n)).reverse().toString();
        return (int) Math.abs(Long.parseLong(rev) - n);
    }
}
/*
3783. 整数的镜像距离
https://leetcode.cn/problems/mirror-distance-of-an-integer/description/

第 481 场周赛 T1。

给你一个整数 n。
定义它的 镜像距离 为：abs(n - reverse(n))，其中 reverse(n) 表示将 n 的数字反转后形成的整数。
返回表示 n 的镜像距离的整数。
其中，abs(x) 表示 x 的绝对值。
提示：
1 <= n <= 10^9

库函数模拟。
时间复杂度 O(logn)。
 */