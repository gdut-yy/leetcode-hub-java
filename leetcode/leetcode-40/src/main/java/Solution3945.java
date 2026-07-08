public class Solution3945 {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            int d = n % 10;
            freq[d]++;
            n /= 10;
        }
        int ans = 0;
        for (int d = 1; d <= 9; d++) {
            if (freq[d] > 0) {
                ans += d * freq[d];
            }
        }
        return ans;
    }
}
/*
3945. 计算数字频率得分
https://leetcode.cn/problems/digit-frequency-score/description/

第 504 场周赛 T1。

给你一个整数 n。
n 的 得分 定义为：对所有 不同 数字 d，计算 d * freq(d) 的总和，其中 freq(d) 表示数字 d 在 n 中出现的次数。
返回一个整数，表示 n 的得分。
提示：
1 <= n <= 10^9

数位和。
时间复杂度 O(logn)。
 */