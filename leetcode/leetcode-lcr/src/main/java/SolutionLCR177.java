public class SolutionLCR177 {
    public int[] sockCollocation(int[] sockets) {
        int xors = 0;
        for (int n : sockets) {
            xors ^= n;
        }
        int bit = 1; // 找出首个不一样的二进制位
        while ((bit & xors) == 0) {
            bit <<= 1;
        }
        int a = 0, b = 0;
        for (int n : sockets) {
            if ((bit & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
/*
LCR 177. 撞色搭配
https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/

整数数组 sockets 记录了一个袜子礼盒的颜色分布情况，其中 sockets[i] 表示该袜子的颜色编号。礼盒中除了一款撞色搭配的袜子，每种颜色的袜子均有两只。请设计一个程序，在时间复杂度 O(n)，空间复杂度O(1) 内找到这双撞色搭配袜子的两个颜色编号。
提示：
2 <= sockets.length <= 10000

分组异或。
官方题解: https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
 */