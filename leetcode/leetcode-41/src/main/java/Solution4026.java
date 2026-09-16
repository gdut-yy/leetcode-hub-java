public class Solution4026 {
    public int maximumGap(String skill, String station) {
        char[] s = skill.toCharArray();
        char[] t = station.toCharArray();

        int n = s.length;
        int[] suf = new int[n]; // s[i,|s|-1] 是 t[suf[i],|t|-1] 的子序列
        int j = t.length - 1;
        for (int i = n - 1; i > 0; i--) {
            while (t[j] != s[i]) { // 题目保证 s 是 t 的子序列，下标不会越界
                j--;
            }
            suf[i] = j;
            j--;
        }

        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n - 1; i++) {
            while (t[pre] != s[i]) {
                pre++;
            }
            // 此时 s[0,i] 是 t[0,pre] 的子序列
            // 此时 s[i+1,|s|-1] 是 t[suf[i+1],|t|-1] 的子序列
            ans = Math.max(ans, suf[i + 1] - pre);
            pre++;
        }
        return ans;
    }
}
/*
4026. 工位的最大间隔
https://leetcode.cn/problems/maximum-gap-between-stations/description/

第 515 场周赛 T3。

给你两个长度分别为 n 和 m 的字符串 skill 和 station。
skill[i] 表示工人 i 的技能，station[j] 表示工位 j 所支持的技能。
你必须将每一名工人分配到一个互不相同的工位。令 ji 表示分配给工人 i 的工位下标。有效的分配方案必须满足：
- 对于每个 0 <= i < n，都有 station[ji] == skill[i]。
- 按照工人的顺序，分配的工位下标必须严格递增，即 j0 < j1 < ... < jn - 1。
分配方案的间隔是分配给两名相邻工人的工位下标之间的最大差值。换句话说，它等于所有 1 <= i < n 中 ji - ji - 1 的最大值。
如果只有一名工人，则间隔为 0。
返回所有有效分配方案中可能得到的最大间隔。题目保证至少存在一种有效的分配方案。
提示：
skill.length == n
station.length == m
1 <= n <= m <= 10^5
skill 和 station 仅由小写英文字母组成。
题目保证所有工人都存在一种有效的分配方案。

前后缀分解。
时间复杂度 O(n + m)。
 */