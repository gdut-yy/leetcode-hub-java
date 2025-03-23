public class Solution3494 {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        // f[i][j] 表示 药水 i 被巫师 j 处理完的时间，答案为 f[m][n]
        long[][] f = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) + (long) skill[j - 1] * mana[i - 1];
            }
            // 校准
            for (int j = n - 1; j >= 1; j--) {
                f[i][j] = f[i][j + 1] - (long) skill[j + 1 - 1] * mana[i - 1];
            }
        }
        return f[m][n];
    }
}
/*
3494. 酿造药水需要的最少总时间
https://leetcode.cn/problems/find-the-minimum-amount-of-time-to-brew-potions/description/

第 442 场周赛 T3。

给你两个长度分别为 n 和 m 的整数数组 skill 和 mana 。
在一个实验室里，有 n 个巫师，他们必须按顺序酿造 m 个药水。每个药水的法力值为 mana[j]，并且每个药水 必须 依次通过 所有 巫师处理，才能完成酿造。第 i 个巫师在第 j 个药水上处理需要的时间为 timeij = skill[i] * mana[j]。
由于酿造过程非常精细，药水在当前巫师完成工作后 必须 立即传递给下一个巫师并开始处理。这意味着时间必须保持 同步，确保每个巫师在药水到达时 马上 开始工作。
返回酿造所有药水所需的 最短 总时间。
提示：
n == skill.length
m == mana.length
1 <= n, m <= 5000
1 <= mana[i], skill[i] <= 5000

正向贪心 + 反向校准。
时间复杂度 O(mn)。
 */