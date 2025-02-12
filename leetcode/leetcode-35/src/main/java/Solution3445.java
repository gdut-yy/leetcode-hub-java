public class Solution3445 {
    public int maxDifference(String S, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        char[] s = S.toCharArray();
        int ans = -INF;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (y == x) {
                    continue;
                }
                int[] curS = new int[5];
                int[] preS = new int[5];
                int[][] minS = {{INF, INF}, {INF, INF}};
                int left = 0;
                for (int i = 0; i < s.length; i++) {
                    curS[s[i] - '0']++;
                    int r = i + 1;
                    while (r - left >= k && curS[x] > preS[x] && curS[y] > preS[y]) {
                        int p = preS[x] & 1;
                        int q = preS[y] & 1;
                        minS[p][q] = Math.min(minS[p][q], preS[x] - preS[y]);
                        preS[s[left] - '0']++;
                        left++;
                    }
                    ans = Math.max(ans, curS[x] - curS[y] - minS[curS[x] & 1 ^ 1][curS[y] & 1]);
                }
            }
        }
        return ans;
    }
}
/*
3445. 奇偶频次间的最大差值 II
https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-ii/description/

第 435 场周赛 T4。

给你一个字符串 s 和一个整数 k 。请你找出 s 的子字符串 subs 中两个字符的出现频次之间的 最大 差值，freq[a] - freq[b] ，其中：
- subs 的长度 至少 为 k 。
- 字符 a 在 subs 中出现奇数次。
- 字符 b 在 subs 中出现偶数次。
返回 最大 差值。
注意 ，subs 可以包含超过 2 个 互不相同 的字符。.
子字符串 是字符串中的一个连续字符序列。
提示：
3 <= s.length <= 3 * 10^4
s 仅由数字 '0' 到 '4' 组成。
输入保证至少存在一个子字符串是由一个出现奇数次的字符和一个出现偶数次的字符组成。
1 <= k <= s.length

枚举+前缀和+滑动窗口。
https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-ii/solutions/3061845/mei-ju-qian-zhui-he-hua-dong-chuang-kou-6cwsm/
rating 2710 (clist.by)
 */