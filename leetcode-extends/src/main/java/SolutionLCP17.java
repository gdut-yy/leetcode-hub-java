public class SolutionLCP17 {
    public int calculate(String s) {
        int len = s.length();
        return 1 << len;
    }
}
/*
LCP 17. 速算机器人
https://leetcode-cn.com/problems/nGK0Fy/

数学问题
A: x + y => (x = 2 * x + y) + y = 2 * (x + y)
B: x + y => x + (y = 2 * y + x) = 2 * (x + y)
因此结果等于 A/B 个数 * 2
 */