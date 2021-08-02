public class Solution1954 {
    public long minimumPerimeter(long neededApples) {
        // 打表
        // 10^14 233920
        // 10^15 503968
        long[] sum = new long[503968];
        for (int i = 1; i < 503968; i++) {
            sum[i] = sum[i - 1] + 12L * i * i;
            if (sum[i] >= neededApples) {
                return i * 8;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long max = (long) Math.pow(10, 15);
        System.out.println(new Solution1954().minimumPerimeter(max));
    }
}
/*
1954. 收集足够苹果的最小花园周长
https://leetcode-cn.com/problems/minimum-garden-perimeter-to-collect-enough-apples/

第 252 场周赛 T3。
打表模拟。

边长为 2 时:
2 1 2
1 0 1
2 1 2

边长为 4 时:
4 3 2 3 4
3 2 1 2 3
2 1 0 1 2
3 2 1 2 3
4 3 2 3 4

边长为 6 时:
6 5 4 3 4 5 6
5 4 3 2 3 4 5
4 3 2 1 2 3 4
3 2 1 0 1 2 3
4 3 2 1 2 3 4
5 4 3 2 3 4 5
6 5 4 3 4 5 6

将正方形分成 4 等分:
    1 2      = (1 + 2) * 1
  3 2 3 4    = (2 + 4) * 2
5 4 3 4 5 6  = (3 + 6) * 3
即第 i 层和为 (i + 2i) * i, 一圈的和需乘 4，即 12 * i * i
对应周长为 8 * i
 */