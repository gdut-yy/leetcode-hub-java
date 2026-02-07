public class SolutionP3344 {
    public int maxSizedArray(long s) {
        long n = 0;
        long current = 0;
        long zero_coeff = 0;

        // For n = 2^k, \sum A = n(n-1)/2 * (n-1) * 3n^2 / 4 = 3/8 * n^3(n-1)^2
        // when k >= 1, \sum A > 3/8 * 2^(5k-2)
        long step = 1L << ((bitsLen((s * 8L + 2) / 3) + 7) / 5);

        while (step > 0) {
            long term1 = zero_coeff * step;
            long term2 = n * step * (2 * n + 2 * step);
            long term3 = 3 * step * (2 * n + step) * (step - 1) / 4;
            long current2 = current + term1 + term2 + term3;

            if (current2 * (n + step) * (n + step - 1) / 2 > s) {
                // This bit is 0
                zero_coeff += n * step;
            } else {
                // This bit is 1
                n += step;
                current = current2;
            }
            step /= 2;
        }
        return (int) n;
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    private int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
$3344. 最大尺寸数组
https://leetcode.cn/problems/maximum-sized-array/description/

给定一个正整数 s，令 A 为一个 n × n × n 的三维数组，其中每个元素 A[i][j][k] 定义为：
- A[i][j][k] = i * (j OR k)，其中 0 <= i, j, k < n。
返回使数组 A 中所有元素的和不超过 s 的 最大的 n。
提示：
0 <= s <= 10^15

比二分更快的O(log n)逐位确定法
https://leetcode.cn/problems/maximum-sized-array/solutions/3703073/bi-er-fen-geng-kuai-de-olog-nzhu-wei-que-95sq/
 */