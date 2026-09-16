public class Solution4021 {
    public int minOperations(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = Integer.MAX_VALUE;
        for (int rot = 0; rot < n; rot++) {
            int op = rot;
            for (int i = 0; i < n / 2; i++) {
                int d = Math.abs(s[(rot + i) % n] - s[(rot + n - 1 - i) % n]);
                op += Math.min(d, 26 - d); // 注：这里可以加个剪枝，如果 op >= ans 则 break
            }
            ans = Math.min(ans, op);
        }
        return ans;
    }
}
/*
4021. 得到旋转回文字符串的最少操作次数 I
https://leetcode.cn/problems/minimum-operations-to-make-a-rotated-palindrome-i/description/

第 189 场双周赛 T2。

给你一个由小写英文字母组成的字符串 s 。
你可以按任意顺序执行以下操作任意次（包括零次）：
- 递增：选择任意一个下标 i 并将 s[i] 替换为下一个小写英文字母。'z' 之后的字母是 'a' 。
- 左旋：将字符串的第一个字符移动到末尾。
返回使 s 成为 回文串 所需的 最少 操作次数。
回文串 是正着读和反着读都一样的字符串。
提示：
2 <= s.length <= 2000
s 仅由小写英文字母组成。

暴力枚举。
时间复杂度 O(n^2)。
 */