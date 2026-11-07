import java.util.HashSet;
import java.util.Set;

public class Solution4078 {
    private static final Set<Integer> fibSet = new HashSet<>();

    static {
        int a = 0;
        int b = 1;
        while (b < 1e9) {
            int x = a + b;
            a = b;
            b = x;
            fibSet.add(b);
        }
    }

    public boolean threeFibonacciSum(int n) {
        return n % 2 == 0 && fibSet.contains(n / 2);
    }
}
/*
4078. 连续三项斐波那契数之和
https://leetcode.cn/problems/three-fibonacci-sum/description/

第 523 场周赛 T1。

给你一个整数 n。
斐波那契数列 以 0 和 1 开始，之后的每个数都是前两个数之和。它的前几项为 0, 1, 1, 2, 3, 5, 8, 13, ...。
如果 n 可以表示为斐波那契数列中 连续三项之和，则返回 true；否则返回 false。
示例 1：
输入： n = 16
输出： true
示例 2：
输入： n = 8
输出： false
示例 3：
输入： n = 2
输出： true
提示：
1 <= n <= 10^9

中国时间 2026-10-11 周日 10:30
深圳。仙湖植物园。
预处理。
时间复杂度 O(1)。
 */