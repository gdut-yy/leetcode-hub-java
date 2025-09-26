public class Solution3675 {
    public int minOperations(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int i = 1; i < 26; i++) {
            if (cnt[i] > 0) return 26 - i;
        }
        return 0;
    }
}
/*
3675. 转换字符串的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-transform-string/description/

第 466 场周赛 T2。

给你一个仅由小写英文字母组成的字符串 s。
你可以执行以下操作任意次（包括零次）：
- 选择字符串中出现的一个字符 c，并将 每个 出现的 c 替换为英文字母表中 下一个 小写字母。
返回将 s 转换为仅由 'a' 组成的字符串所需的最小操作次数。
注意：字母表是循环的，因此 'z' 的下一个字母是 'a'。
提示：
1 <= s.length <= 5 * 10^5
s 仅由小写英文字母组成。

统计出现过的字符。答案就是最小的非 a 字母到 z+1 的距离。
时间复杂度 O(n)。
 */