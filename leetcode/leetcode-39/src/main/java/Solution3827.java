public class Solution3827 {
    public int countMonobit(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (Integer.bitCount(i) == bitsLen(i)) ans++;
        }
        return ans;
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    private int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
3827. 统计单比特整数
https://leetcode.cn/problems/count-monobit-integers/description/

第 487 场周赛 T1。

给你一个整数 n。
如果一个整数的二进制表示中所有位都相同，则称其为 单比特数（Monobit）。
返回范围[0, n]（包括两端）内 单比特数 的个数。
提示：
0 <= n <= 1000

模拟。
时间复杂度 O(logn)。
 */